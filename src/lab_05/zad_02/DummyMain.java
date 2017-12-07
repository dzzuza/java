package lab_05.zad_02;
import lab_05.zad_01.MatrixDimensionsException;

import java.io.IOException;

public class DummyMain {
    public static void main(String[] argv) throws IOException {
        String fileName="D:\\informatyka\\java\\Lab\\src\\lab_05\\zad_1\\zad_02\\m1";
        DummyMatrix A=new DummyMatrix(fileName);
        String fileName2="D:\\informatyka\\java\\Lab\\src\\lab_05\\zad_1\\zad_02\\m2";
        DummyMatrix B=new DummyMatrix(fileName2);

        try {
            //A.add(B).show();
            A.mul(B).show();
            //B.mul(A).show();
        } catch (MatrixDummyDimensionsException e) {
            e.printStackTrace();
        }

    }
}
