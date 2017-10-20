package lab_03.shapes;

public class shape_main {
    public static void main(String[] argv) {
        Circle circ = new Circle();
        circ.name = ("okrag1");
        System.out.println(circ.name);
        System.out.println("");
        circ.draw();
        Rectangular rec = new Rectangular();
        rec.name = ("prostokat1");
        System.out.println("");
        System.out.println(rec.name);
        System.out.println("  ");
        rec.draw();
    }
}
