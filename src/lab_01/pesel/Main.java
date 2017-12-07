package lab_01.pesel;

import java.util.Scanner;

public class Main {
    public static void main(String[] argv) {
        Scanner in = new Scanner(System.in);
        System.out.println("Type the number: ");
        Pesel p=new Pesel(in.nextLine());
        //p.pesel=in.nextLine();
        System.out.println(p.pesel);
        if(p.check()){
            System.out.println("pesel.Pesel ok");
        }
        else {
            System.out.println("Pesel niepoprawny");
        }

    }
}