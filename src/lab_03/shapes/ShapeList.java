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

        //Shape[] shapel = {new Circle(), new Circle(), new Rectangular(), new Rectangular()};

        LinkedList<Shape> shape1=new LinkedList<>();
        shape1.add(kolo1);
        shape1.add(kolo2);
        shape1.add(prost1);
        for (Shape p : shape1) {
            p.draw();
        }

    }
}
