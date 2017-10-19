package lab_01.login;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package lab_01.login.Login;
import java.io.*;
/**
 *
 * @author Szymon
 */
public class LoginProgram {
    public static void main(String[] argv){
        Login log = new Login ("ala","makota");
        try{
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);

            System.out.println("Wpisz login");
            String login = bfr.readLine();
            System.out.println("Wpisz haslo");
            String haslo = bfr.readLine();
            //System.out.println(haslo);

        /*TODO: sprawdzenie czy podane hasło i lab_01.login zgadzaja sie z tymi
         przechowywanymi w obiekcie log Jeśli tak, to ma zostać
         wyswietlone "OK", jesli nie - prosze wyswietlić informacje o błedzie
         */
        if( log.check(login,haslo)){
            System.out.println("login i haslo poprawne");
        }
        else{
            System.out.println("zly login lub haslo");
        }

        }catch(IOException e){e.printStackTrace();}

    }
}
