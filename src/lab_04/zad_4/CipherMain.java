package lab_04.zad_4;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CipherMain {
    public static void main(String[] argv){
        String cipheredText = "012344";
        String decipheredText = "";
        String inputFile ="D:\\informatyka\\java\\Lab\\src\\lab_04\\zad_4\\input";
        //String inputFile2 ="D:\\informatyka\\java\\Lab\\src\\lab_04\\zad_4\\output";
        String outputFile ="D:\\informatyka\\java\\Lab\\src\\lab_04\\zad_4\\output";
        String outputFile2 ="D:\\informatyka\\java\\Lab\\src\\lab_04\\zad_4\\output2";
        Algorithm code= new Polibiusz();
        Algorithm code2= new ROT11();
        Cryptographer.cryptfile(inputFile,code,outputFile);
        Cryptographer.decryptfile(outputFile,code,outputFile2);
        //Cryptographer.cryptfile(inputFile,code2,outputFile);
        //Cryptographer.decryptfile(outputFile,code2,outputFile2);
    }
    }