package lab_04.zad_2_3;

public class Student extends Pracownik{
    public Student(String pesel){
        super(pesel);
    }


    public double netto(){
        double net=0.8*this.getBrutto();
        return net;
    }
}
