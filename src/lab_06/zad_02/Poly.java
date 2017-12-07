package lab_06.zad_02;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;


class Poly extends JPanel {
    int x;
    int y=300;
    int sampling;
    int[] coefficient;
    int xp;
    int yp;
    int stop;

    Poly(int sampling,int start, int stop, int...coeefficient){
        this.sampling= sampling;
        this.stop=stop;
        this.coefficient=coeefficient;
        this.x=300+start*10;
        //this.x=300+start;
    }
    int i=0;
    int flag=0;
    @Override
    public void paint(Graphics g){
        setBackground(Color.WHITE);
        Graphics2D gg=(Graphics2D) g;
        //grid
        while(i<600) {
            gg.setColor(Color.GRAY);
            gg.drawLine(600 - i, 0, 600 - i, 600);
            gg.drawLine(0,600-i,600,600-i);
            i=i+10;
        }
        gg.setStroke(new BasicStroke(2));
        //axver
        gg.drawLine(300,0,300,600);
        //axhor
        gg.drawLine(0,300,600,300);
        //axdiv
        int axx=0;
        int byy=0;
        for(int i=0;i<600;i+=10){
            gg.drawLine(axx,297,axx,303);
            gg.drawLine(297,byy,303,byy);
            axx=i;
            byy=i;
        }
        //chart
        gg.setColor(Color.BLUE);
        gg.setStroke(new BasicStroke(4));
        if(flag>1){
            gg.drawLine(xp-sampling,yp,x-sampling,y);}
        count();
        if(x>=0 && x<(310+stop*10+sampling) ){
            repaint();
        }
    }

    public void count(){
        try{
            if(flag<2){ flag+=1;}
            int ax,by;
            int sum=0;
            ax=x-300;
            for(int i=0;i<coefficient.length;i++) {
                sum += coefficient[i] * Math.pow(0.1*ax, coefficient.length - 1 - i);
            }
            by=10*sum;
            //by=sum;
            xp=x;
            yp=y;

            x=ax+300;
            y=300-by;
            x=x+sampling;
        }
        catch(Exception e){
            System.out.println("error");
        }
    }

}