package lab_06.zad_01A;
import java.awt.*;
import javax.swing.*;



public abstract class Shap extends JComponent{
    public String name;

    int xx;
    int yy;
    public abstract void draw(Graphics g);

    public int getX(){
        return xx;
    }
    public int getY(){return yy; }
    public void setXx(int x){
        this.xx=x;
    }
    public void setYy(int y){
        this.yy=y;
    }


}
