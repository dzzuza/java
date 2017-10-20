package lab_04;
import lab_01.pesel.Pesel;

import java.util.Scanner;

public abstract class Pracownik {
    private Pesel pesel;
    private double brutto;

    Pracownik(String p){
        this.pesel= new Pesel(p);
    }
    String getPeselFromPracownik() {
        return pesel.getPesel();
    }

    double getBrutto() {
        return brutto;
    }

    void setBrutto(double brutto) {
        this.brutto=brutto;
    }
    public void fill() {
        Scanner in = new Scanner(System.in);
        System.out.println("wprowadź płacę osoby"+pesel);
        this.setBrutto(in.nextDouble());
        }

    public abstract double netto();

}
