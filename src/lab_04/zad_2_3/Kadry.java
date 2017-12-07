package lab_04.zad_2_3;

import java.util.LinkedList;

public class Kadry {
    protected LinkedList<Pracownik> lista=new LinkedList<>();

    void addP(Pracownik pracownik){
        lista.add(pracownik);
    }

    void removeP(String pesel){
        for (Pracownik pracownik : lista) {
            if (pracownik.getPeselFromPracownik().equals(pesel)){
                lista.remove(pracownik);
                break;
            }
        }
    }
    Pracownik find(String pesel){
        for (Pracownik p : lista){
            if(p.getPeselFromPracownik().equals((pesel))){
                return p;
            }
        }
        return null;
    }
    void changeBrutto(String pes,double brutto) {
        for (Pracownik p : lista){
            if(p.getPeselFromPracownik().equals(pes)){
                p.setBrutto(brutto);
                break;
            }
        }
        //System.out.println("nie ma takiego pracownika");
    }

    void getBrutto(String pes) {
        for (Pracownik p : lista){
            if(p.getPeselFromPracownik().equals(pes)){
                System.out.println(p.getBrutto());
            }
        }
    }

    void getNetto(String pes) {
        for (Pracownik p : lista){
            if(p.getPeselFromPracownik().equals(pes)){
                System.out.println(p.netto());
            }
        }
    }
    void sort(){
        lista.sort(new SortujBrutto());
    }

    void printOut(){
        for (Pracownik p : lista){
            System.out.println(p.getPeselFromPracownik());
            System.out.println(p.getBrutto());
        }
    }
}
