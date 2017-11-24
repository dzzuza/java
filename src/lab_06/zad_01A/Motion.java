package lab_06.zad_01A;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Motion extends MouseAdapter{
    String oo = "Nothing";
    int mx;
    int my;

    //L
    @Override
    public void mouseClicked(MouseEvent e) {
        //mx = e.getX();
        //my = e.getY();
        oo = "click";
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mx = e.getX();
        my = e.getY();
        e.getComponent().repaint();
        //oo = "press";
        //repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //super.mouseReleased(e);
        //mx = e.getX();
        //my = e.getY();
        ((Shap) e.getComponent()).setXx(e.getComponent().getX() + e.getX() - mx);
        ((Shap) e.getComponent()).setYy(e.getComponent().getY() + e.getY() - my);
        oo = "released";
        e.getComponent().repaint();

    }
    @Override
    public void mouseDragged(MouseEvent e) {
        //super.mouseDragged(e);
        //mx = e.getX();
        //my = e.getY();
        ((Shap) e.getComponent()).setXx(e.getComponent().getX() + e.getX() - mx);
        ((Shap) e.getComponent()).setYy(e.getComponent().getY() + e.getY() - my);
        oo = "dragged";
        e.getComponent().repaint();
        //repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //mx=e.getX();
        //my=e.getY();
        oo = "moved";

    }
}
