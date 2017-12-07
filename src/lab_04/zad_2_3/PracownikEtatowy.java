package lab_04.zad_2_3;

public class PracownikEtatowy extends Pracownik {

    public PracownikEtatowy(String pes){
        super(pes);
    }


    public double netto(){
        double net=0.8*this.getBrutto();
        return net;
    }
}
