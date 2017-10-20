package lab_04;

import lab_01.pesel.Pesel;

public class Student extends Pracownik{
    public Student(String pesel){
        super(pesel);
    }


    public double netto(){
        double net=0.8*this.getBrutto();
        return net;
    }
}
