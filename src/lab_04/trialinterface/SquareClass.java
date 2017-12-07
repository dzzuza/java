package lab_04.trialinterface;

public class SquareClass implements Shape{
    public void draw(){
        System.out.println("kwadrat");
    }
    public static void main(String[] argv) {
        SquareClass sq=new SquareClass();
        sq.draw();
        System.out.println(sq.maxArea);
    }
}
