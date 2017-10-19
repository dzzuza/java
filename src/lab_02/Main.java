package lab_02;

import lab_02.pkg1.A;
import lab_02.pkg1.B;
import lab_02.pkg2.C;

public class Main {
    public static void main(String[] argv) {
        A a = new A(5, "alfa");
        B b = new B(15, "beta");
        C c = new C(25, "gamma");
        System.out.println(c.number);
        System.out.println(b.number);
        System.out.println(a.number);
        c.callChangeName("newalfa");
//        System.out.println(c.name);
        b.callChangeName("newbeta");
        //      System.out.println(b.name);
        a.callChangeName("newgamma");
        //    System.out.println(a.name);

        c.callIncrement();
        System.out.println(c.number);
        a.callDecrement();
        System.out.println(a.number);
        b.callDecrement();
        System.out.println(b.number);
        b.callIncrement();
        System.out.println(b.number);
        /*b.decrement();
        System.out.println(b.number);
        a.decrement();
        System.out.println(a.number);
*/
    }
}
