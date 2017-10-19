package lab_02.pkg1;

public class B extends A{
    public B(int _num, String _nam){
        super(_num,_nam);
        //System.out.println(super.name+", "+super.number);
    }
    private void increment(){

        number+=2;
    }
    protected void decrement(){
        number-=2;
    }
    void changeName(String _change){

        name=_change;
    }
}
