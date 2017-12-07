package lab_05.zad_02;
import lab_05.zad_01.MatrixDimensionsException;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Matrix {
    int rows;
    int columns;
    int matrix[][];

    public Matrix(int _m, int _n) {
        rows = _m;
        columns = _n;
        matrix = new int[rows][columns];
    }

    public Matrix(String fileName) throws IOException {
        BufferedReader bufferedReader = null;
        int row = 0;
        int col = 0;
        LinkedList<Integer> elements = new LinkedList<>();
        try {
            FileReader fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            StringTokenizer token;
            String line;
            //line=bufferedReader.
            while ((line=bufferedReader.readLine()) != null) {
                token = new StringTokenizer(line, " ");
                row++;
                while (token.hasMoreElements()) {
                    elements.add(Integer.parseInt(token.nextToken()));
                    //System.out.println(elements.getLast());
                    col++;
                }
            }
            matrix = new int[row][col / row];
            //for(int i:elements)
            for (int c = 0; c < row; c++) {
                for (int d = 0; d < (col/row); d++) {
                    //System.out.println("podaj element: ");
                    matrix[c][d] = elements.getFirst();
                    elements.removeFirst();
                }
            }
            this.rows = row;
            this.columns = col / row;
            //System.out.println("mac" + row + (col / row));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                bufferedReader.close();
            }
            catch (IOException e) {
                e.getMessage();
                throw e;
            }
        }
    }

    public Matrix fill() {
        Scanner in = new Scanner(System.in);
        if (rows > 0 && columns > 0) {
            for (int c = 0; c < rows; c++) {
                for (int d = 0; d < columns; d++) {
                    //System.out.println("podaj element: ");
                    matrix[c][d] = in.nextInt();
                }
            }
        }
        return this;
    }

    //wypisywanie
    public void show() {
        for (int c = 0; c < rows; c++) {
            for (int d = 0; d < columns; d++) {
                System.out.print(matrix[c][d] + "\t");
            }
            System.out.println();
        }
    }

    //dodawanie :(
    public Matrix add(Matrix b) throws MatrixDimensionsException {
        Matrix result = new Matrix(this.rows, this.columns);
        if (this.rows == b.rows && this.columns == b.columns) {
            for (int c = 0; c < rows; c++) {
                for (int d = 0; d < columns; d++) {
                    result.matrix[c][d] = this.matrix[c][d] + b.matrix[c][d];
                }
            }
        } else {
            throw new MatrixDimensionsException("Wrong size");
        }
        return result;
    }

    public Matrix sub(Matrix b) throws MatrixDimensionsException {
        Matrix result = new Matrix(this.rows, this.columns);
        if (this.rows == b.rows && this.columns == b.columns) {
            for (int c = 0; c < rows; c++) {
                for (int d = 0; d < columns; d++) {
                    result.matrix[c][d] = this.matrix[c][d] - b.matrix[c][d];
                }
            }
        } else {
            throw new MatrixDimensionsException("Wrong size");
        }
        return result;
    }

    public Matrix mul(Matrix b) throws MatrixDimensionsException, MatrixDummyDimensionsException {
        Matrix result = new Matrix(this.rows, b.columns);
        if (this.columns != b.rows) {
            System.out.println("tu");
            throw new MatrixDimensionsException("Wrong");
        } else {
            for (int c = 0; c < result.rows; c++) {
                //System.out.println("c: "+c);
                for (int d = 0; d < result.columns; d++) {
                    //System.out.println("d: "+d);
                    for (int e = 0; e < this.columns; e++) {
                        //System.out.println("e: "+e);
                        result.matrix[c][d] += this.matrix[c][e] * b.matrix[e][d];
                    }
                }
            }
            return result;
        }
    }
}