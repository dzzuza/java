package lab_05.zad_02;

import lab_05.zad_01.MatrixDimensionsException;

public class MatrixDummyDimensionsException extends Exception {
        public MatrixDummyDimensionsException(String message, Matrix _m, Matrix _n) {
            super(message);
            int diff=0;
            Matrix M=null;

            Matrix result =new Matrix(_m.rows,_n.columns);
            if(_m.columns>_n.rows) {
                diff = _m.columns - _n.rows;
                M = new Matrix(_n.rows,_m.columns - diff);
                for (int c = 0; c < M.rows; c++) {
                    for (int d = 0; d < M.columns; d++) {
                        //System.out.println("podaj element: ");
                        M.matrix[c][d] = _m.matrix[c][d];
                    }
                }
            }
            else{
                diff=_n.rows-_m.columns;
                M = new Matrix( _m.rows, _m.columns + diff);
                for (int c = 0; c < _m.rows; c++) {
                    for (int d = 0; d < _m.columns; d++) {
                        //System.out.println("podaj element: ");
                        M.matrix[c][d] = _m.matrix[c][d];
                    }
                    for(int e=_m.columns;e<M.columns;e++){
                        M.matrix[c][e]=1;
                    }
                }
            }
            M.show();
            //System.out.println("ttttt");
            for (int c = 0; c < result.rows; c++) {
                //System.out.println("c: "+c);
                for (int d = 0; d < result.columns; d++) {
                    //System.out.println("d: "+d);
                    for (int e = 0; e < M.columns; e++) {
                        //System.out.println("e: "+e);
                        try {
                            result=M.mul(_n);
                        } catch (MatrixDimensionsException e1) {
                            e1.printStackTrace();
                        } catch (MatrixDummyDimensionsException e1) {
                            e1.printStackTrace();
                        }
                        //result.matrix[c][d] += M.matrix[c][e] * _n.matrix[e][d];
                    }
                }
            }
            result.show();

        }

    }
