package lab_03.zad1;

import java.util.LinkedList;

public class ex_main {
    public static void main(String[] argv) {
        Ex1 a=new Ex1();
        double m=9;
        final LinkedList<Double> list = new LinkedList();
        list.add(3.2);
        list.add(m);
        a.changeVar(list);
        //list= new LinkedList<>(); tego nie wolno zrobic
        System.out.println(list);
    }
}
