package lab_06.zad_02;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;


public class MainPoly extends JFrame {

    public MainPoly() {
        JFrame window = new JFrame();
        Poly panel=new Poly(1,-2,5,1,-5,-3,10);
        //Poly panel2=new Poly(1,-50,50,1,0,0,10);
        window.setSize(600,600);
        window.setTitle("shapes drawer");
        window.setVisible(true);
        window.add(panel);
        //window.add(panel2);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        //new MainPoly().setVisible(true);
        MainPoly aa=new MainPoly();

    }
}