package lab_03.shapes;

import lab_03.shapes.Circle;
import lab_03.shapes.Rectangular;
import lab_03.shapes.Shape;

import java.util.LinkedList;

public class ShapeList {
    public static void main(String[] argv) {
        Circle kolo1 = new Circle();
        Circle kolo2 = new Circle();
        Rectangular prost1 = new Rectangular();
        Rectangular prost2 = new Rectangular();
        //LinkedList<Shape> shapelist = new LinkedList<>();
        //shapelist.add(kolo1);

        Shape[] shapel = {new Circle(), new Circle(), new Rectangular(), new Rectangular()};

        for (Shape p : shapel) {
            //for (lab_02.punkty.Punkt3D p : punkty) {
            p.draw();
        }

    }
}
