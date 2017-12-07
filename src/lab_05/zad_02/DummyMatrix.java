package lab_05.zad_02;
import lab_05.zad_01.MatrixDimensionsException;

import java.io.IOException;

public class DummyMatrix extends Matrix{
    public DummyMatrix(int _m, int _n) {
        super(_m, _n);
    }
    public DummyMatrix(String fileName) throws IOException {
        super(fileName);
    }

    @Override
/*    public Matrix mul(Matrix b) throws MatrixDimensionsException {
        return super.mul(b);
    }*/
    public Matrix mul(Matrix b) throws MatrixDummyDimensionsException {
        //Matrix result = new Matrix(this.rows, b.columns);
        if (this.columns != b.rows) {
            //System.out.println("tu");
            throw new MatrixDummyDimensionsException("Wrong",this,b);
        } else {
            Matrix result = new Matrix(this.rows, b.columns);
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
