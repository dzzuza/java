package lab_02.punkty;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] argv) {
        System.out.println("Menu");
        System.out.println("1.Dodaj punkt");
        System.out.println("2.Wypisz listę punktów");
        System.out.println("3.Dystans");
        System.out.println("4.Zakończ");

        Scanner in = new Scanner(System.in);
        int kk = in.nextInt();
        LinkedList<Punkt3D> punkty = new LinkedList<>();
        boolean ll=true;
        while (kk!=0 && ll==true) {
            switch (kk) {
                case 1:
                    //wczytaj punkt
                    /*punkty.add(new lab_02.punkty.Punkt3D(0, 0, 0));
                    for (lab_02.punkty.Punkt3D p : punkty) {
                        p.fill();
                    }*/
                    Punkt3D p=new Punkt3D(0,0,0);
                    p.fill();
                    punkty.add(p);
                    break;
                case 2:
                    //wypisz wszystko
                    for (int i = 0; i < punkty.size(); i++) {
                        System.out.println(punkty.get(i).x + " " + punkty.get(i).y + " " + punkty.get(i).z);
                    }
                    break;
                case 3:
                    //oblicz odległość
                    System.out.println("Pomiędzy którymi punktami chcesz zmierzyć odległość?");
                    int nn = in.nextInt();
                    int mm = in.nextInt();
                    System.out.println(punkty.get(nn - 1).distance(punkty.get(mm - 1)));
                    break;
                case 4:
                    ll=false;
                    break;
                default:
                    System.out.println("bledny wybor");
            }
            if(ll==true) {
                System.out.println("Menu");
/*              System.out.println("1.Dodaj punkt");
                System.out.println("2.Wypisz listę punktów");
                System.out.println("3.Dystans");
                System.out.println("4.Zakończ");*/
                kk = in.nextInt();
            }
        }
    }
}
