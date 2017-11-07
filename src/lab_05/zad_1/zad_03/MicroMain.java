package lab_05.zad_1.zad_03;

import java.io.IOException;

public class MicroMain {
    public static void main(String[] argv) throws SyntaxException{
        String inputFile ="D:\\informatyka\\java\\Lab\\src\\lab_05\\zad_1\\zad_03\\in";
        String outputFile ="D:\\informatyka\\java\\Lab\\src\\lab_05\\zad_1\\zad_03\\out";
        try{
            Micro.delay(inputFile, outputFile, 100, 30);
        }
        catch (SyntaxException e){
            e.printStackTrace();
        }
    }

}