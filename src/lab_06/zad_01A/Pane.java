package lab_06.zad_01A;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

public class Pane extends JPanel {

    LinkedList<Shap> shapes;

    public Pane() {
        super();
        this.setBackground(Color.lightGray);
        shapes = new LinkedList<>();
        Circ aa = new Circ();
        Circ bb = new Circ();
        Rect cc = new Rect();
        Rect dd = new Rect();

        shapes.add(aa);
        shapes.add(bb);
        shapes.add(cc);
        shapes.add(dd);
        for (Shap a: shapes){
            Motion mot=new Motion();
            a.addMouseListener(mot);
            a.addMouseMotionListener(mot);
            this.add(a);
        }
    }

    public void paintComponent(Graphics graph) {
        super.paintComponent(graph);
        graph.setColor(Color.DARK_GRAY);
        for (Shap a : shapes) {
            a.draw(graph);
        }

    }

}