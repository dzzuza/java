package lab_05.zad_1.z_01;
import lab_01.matrix.Matrix;

import java.io.IOException;

public class MainMatrix {
    public static void main(String[] argv) throws IOException {
//==================
        String fileName="D:\\informatyka\\java\\Lab\\src\\lab_05\\zad_1\\z_01\\matrix";
        String fileName2="D:\\informatyka\\java\\Lab\\src\\lab_05\\zad_1\\z_01\\matrix2";

        //==================
        Matrix a = new Matrix(fileName);
        a.show();
        Matrix c = new Matrix(fileName2);
        c.show();
        try {
            System.out.println("a+c=");
            a.add(c).show();
            System.out.println("a*c=");
            a.mul(c).show();
        } catch (MatrixDimensionsException e) {
            e.getMessage();
            System.out.println(e.getMessage());
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