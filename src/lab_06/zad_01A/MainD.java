//import oracle.jvm.hotspot.jfr.JFR;

package lab_06.zad_01A;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MainD extends JFrame{
    public static void main(String[] args){
        JFrame window = new JFrame();
        Pane shapespanel=new Pane();
        window.setSize(800,600);
        window.setTitle("shapes drawer");
        window.setVisible(true);

        window.add(shapespanel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}