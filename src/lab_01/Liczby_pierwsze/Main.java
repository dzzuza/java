package lab_01.Liczby_pierwsze;

public class Main {
    public static void main(String[] argv){
        System.out.println("Type the number: ");
        int num = JIn.getInt();

        LiczbyPierwsze prim= new LiczbyPierwsze();
        System.out.println("Liczby pierwsze :");
        prim.getPrim(num);
    }
}
