package lab_06.zad_01A;

import java.awt.*;
import java.util.Random;

public class Rect extends Shap{
    int hh;
    int ww;
    public Rect(){
        Random random=new Random();
        this.hh = 50;
        this.ww = 50;
        this.xx = random.nextInt(700);
        this.yy = random.nextInt(500);
}
    @Override
    public void draw(Graphics graph) {
        graph.fillRect(xx,yy,ww,hh);
        this.setSize(ww,hh);
        this.setLocation(xx,yy);
    }
}
