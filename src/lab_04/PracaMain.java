package lab_04;

import lab_01.pesel.Pesel;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class PracaMain {
    public static void main(String[] argv) {
        //LinkedList<Pracownik> listaPracownikow=new LinkedList<>();
        Kadry kadry=new Kadry();
        kadry.addP(new Student("91022514260"));
        kadry.addP(new Student("91022544265"));
        kadry.addP(new PracownikEtatowy("95022514260"));
        kadry.addP(new PracownikEtatowy("61022514260"));

        kadry.removeP("91022514260");
        kadry.changeBrutto("61022514260",6000);
        kadry.changeBrutto("95022514260",2000);
        kadry.changeBrutto("91022544265",4000);

        //uzupełnienie całej listy plac brutto
        /*for(Pracownik p: kadry.lista){
            Scanner in = new Scanner(System.in);
            double brut=in.nextDouble();
            p.setBrutto(brut);
        }*/

        System.out.println(kadry.find("61022514260").getPeselFromPracownik());
        kadry.printOut();
        System.out.println("");
        kadry.changeBrutto("61022514260",9000);
        kadry.getBrutto("61022514260");
        kadry.getNetto("61022514260");
        System.out.println("");

        kadry.sort();
        kadry.printOut();
        //Collections.sort(kadry.lista);
        //SortujBrutto
    }
}
