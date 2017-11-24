package lab_06.zad_01A;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;


public class Circ extends Shap {
    int rr;

    public Circ(){
        Random random=new Random();
        this.rr=50;
        this.xx = random.nextInt(700);
        this.yy = random.nextInt(500);
    }


    @Override
    public void draw(Graphics graph) {
        graph.fillOval(xx,yy,rr,rr);
        this.setSize(rr,rr);
        this.setLocation(xx,yy);
    }
}
