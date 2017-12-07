package lab_02.punkty;

import java.util.Scanner;

public class Punkt3D extends Punkt2d {
    double z;

    public Punkt3D(double _x, double _y, double _z) {
        super(_x, _y);
        z = _z;
    }
    boolean filled=false;
    public double getZ() {
        return z;
    }

    public void setZ(double _zz) {
        z = _zz;
    }

    public double distance(Punkt3D punkt) {
        double result;
        result = Math.sqrt(Math.pow(Math.sqrt(Math.pow(x - punkt.x, 2) + Math.pow(y - punkt.y, 2)), 2) + Math.pow(z - punkt.z, 2));
        return result;
    }

    public void fill() {
        Scanner in = new Scanner(System.in);
        //double x, y, z;;
        if(!filled) {
            System.out.println("wczytaj punkt, podaj x: ");
            this.setX(in.nextDouble());
            System.out.println("podaj y: ");
            this.setY(in.nextDouble());
            System.out.println("podaj z: ");
            this.setZ(in.nextDouble());
            filled=true;
        }
        //System.out.println("wspołrzędne punktu: "+this.x+" "+this.y+" "+this.z);
    }

}
