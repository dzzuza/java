package lab_01.matrix;

public class Main {
    public static void main(String[] argv){
        Matrix a= new Matrix(3,3);
        System.out.println("wpisz elementy macierzy a:");
        a.fill();
        a.show();

        Matrix b= new Matrix(3,3);
        System.out.println("Wpisz elementy macierzy b:");
        b.fill();
        b.show();
        System.out.println();
        System.out.println("a+b=");
        a.add(b).show();
        System.out.println("a-b=");
        a.sub(b).show();
        System.out.println("a*b=");
        a.mul(b).show();
    }
}
