package lab_02.pkg1;

public class A {
    public int number;
    protected String name;

    public A(int _number, String _name) {
        number = _number;
        name = _name;
    }

    public void callChangeName(String _change) {

        this.changeName(_change);
        System.out.println(this.name);
    }

    public void callIncrement() {

        this.increment();
    }

    public void callDecrement() {
        this.decrement();
    }

    private void increment() {
        number += 1;
    }

    protected void decrement() {
        number -= 1;
    }

    void changeName(String _change) {
        this.name=_change;
        //name = "newnamealfa";
    }

}
