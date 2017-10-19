package lab_01.matrix;

import java.util.Scanner;

public class Matrix {
    int rows;
    int columns;
    int matrix[][];

    public Matrix(int _m, int _n) {
        rows = _m;
        columns = _n;
        matrix = new int[rows][columns];

    }

    public Matrix fill() {
        Scanner in = new Scanner(System.in);
        if(rows >0 && columns >0) {
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
    public Matrix add(Matrix b) {
        Matrix result = new Matrix(this.rows, this.columns);
        if (this.rows == b.rows && this.columns == b.columns) {
            for (int c = 0; c < rows; c++) {
                for (int d = 0; d < columns; d++) {
                    result.matrix[c][d] = this.matrix[c][d] + b.matrix[c][d];
                }
            }
        }
        return result;
        }

    public Matrix sub(Matrix b) {
        Matrix result = new Matrix(this.rows, this.columns);
        if (this.rows == b.rows && this.columns == b.columns) {
            for (int c = 0; c < rows; c++) {
                for (int d = 0; d < columns; d++) {
                    result.matrix[c][d] = this.matrix[c][d] - b.matrix[c][d];
                }
            }
        }
        return result;
    }
    public Matrix mul(Matrix b) {
        Matrix result = new Matrix(this.rows, b.columns);
        if (this.columns != b.rows) {
            System.out.println("nie mozna wykonac dzialania");
            return null;
        }
            for (int c = 0; c < result.rows; c++) {
                //System.out.println("c: "+c);
                for (int d = 0; d < this.rows; d++) {
                    //System.out.println("d: "+d);
                    for(int e = 0; e<this.columns; e++){
                        //System.out.println("e: "+e);
                        result.matrix[c][d] += this.matrix[c][e]*b.matrix[e][d];
                    }
                }
            }
        return result;
    }
}