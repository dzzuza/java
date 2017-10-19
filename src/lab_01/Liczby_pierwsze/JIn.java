package lab_01.Liczby_pierwsze;

import java.io.*;
import java.util.Scanner;


public class JIn {
    public static String getString() {
        String text=null;
        try{
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);
            text = bfr.readLine();

        }catch(IOException e){e.printStackTrace();}
        return text;
    }
    public  static int getInt(){
        int number;

        Scanner num=new Scanner(System.in);
        //System.out.println(num.nextInt());
        number=num.nextInt();
        return number;
    }
}