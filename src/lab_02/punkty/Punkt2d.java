package lab_02.punkty;

public class Punkt2d {
    double x;
    double y;

    public Punkt2d(double _x, double _y) {
        x = _x;
        y = _y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double _xx) {
        x = _xx;
    }

    public void setY(double _yy) {
        y = _yy;
    }

    public double distance(Punkt2d punkt) {
        double result;
        result = Math.sqrt((Math.pow(x - punkt.x, 2) + Math.pow(y - punkt.y, 2)));
        return result;
    }
}
