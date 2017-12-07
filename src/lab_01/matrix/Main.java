package lab_01.matrix;

import lab_05.zad_01.MatrixDimensionsException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] argv) throws IOException {
//==================
        String fileName="D:\\informatyka\\java\\Lab\\src\\lab_05\\zad_1\\z_01\\matrix";
        String fileName2="D:\\informatyka\\java\\Lab\\src\\lab_05\\zad_1\\z_01\\matrix2";
        /*BufferedReader bufferedReader = null;
        BufferedReader bufferedReader2 = null;
        try {
            FileReader fn=new FileReader(fileName);
            bufferedReader=new BufferedReader(fn);
            Matrix a = new Matrix(bufferedReader);
            a.show();
            FileReader fn2=new FileReader(fileName2);
            bufferedReader2=new BufferedReader(fn2);
            Matrix c = new Matrix(bufferedReader2);
            c.show();
            System.out.println("a*c=");
            a.mul(c).show();
        } catch (IOException | MatrixDimensionsException e) {
            e.getMessage();
        }finally {
            bufferedReader.close();
        }*/
        //==================
        Matrix a = new Matrix(fileName);
        a.show();
        Matrix c = new Matrix(fileName2);
        c.show();
        System.out.println("a*c=");
        try {
            a.mul(c).show();
        } catch (MatrixDimensionsException e) {
            e.getMessage();
            System.out.println("wrrr");
        }
        /*
        Matrix b= new Matrix(4,2);
        System.out.println("Wpisz elementy macierzy b:");
        b.fill();
        b.show();
        System.out.println();
        //System.out.println("a+b=");
        //a.add(b).show();
        //System.out.println("a-b=");
        //a.sub(b).show();
        System.out.println("a*b=");
        try {
            a.mul(b).show();
        } catch (MatrixDimensionsException e) {
            System.out.println(e.getMessage());
        }*/
    }
}