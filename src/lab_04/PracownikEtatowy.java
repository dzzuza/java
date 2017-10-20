package lab_04;

import lab_01.pesel.Pesel;

public class PracownikEtatowy extends Pracownik {

    public PracownikEtatowy(String pes){
        super(pes);
    }


    public double netto(){
        double net=0.8*this.getBrutto();
        return net;
    }
}
