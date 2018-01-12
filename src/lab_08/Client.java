package lab_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedList;

public class Client {
    private Socket echoSocket;
    private PrintWriter out;
    private BufferedReader in;
    private String ID;
    String state;

    public void connect() {

        try {
            echoSocket = new Socket("localhost", 3000);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
            System.out.println("connected");

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: localhost.");
            System.exit(1);
        }
    }

    private String login(String password) throws IOException {
        connect();
        System.out.println("tu zaczyna sie logowanie");

        String login = "szymon";
        out.printf("LOGIN %s;%s\n", login, password);

        state = in.readLine();

        System.out.println("zalogowany: "+state);



        if(state.equals("true")){
            ID = in.readLine();
            System.out.println("id: "+ID);
            out.close();
            in.close();
            echoSocket.close();
            return ID;
        }
        else {
            Integer lev = computeLevenshteinDistance(password,"lala");
            System.out.println("odległość Levenshteina: "+lev);
            out.close();
            in.close();
            echoSocket.close();
            return null;
        }

    }
    private void logout() throws IOException {

        connect();

        System.out.println("tu zaczyna sie wylogowywanie");
        //String state;
        out.printf("LOGOUT "+"1234567890\n");
        state=in.readLine();
        System.out.println("zalogowany: "+state);

        out.close();
        in.close();
        echoSocket.close();
    }

    public String ls() throws IOException {
        connect();
        String output;
        String login="szymon";
        System.out.println("Start ls");
        //login("lala");
        out.printf("LS " + "1234567890\n");
        output = in.readLine();

        out.close();
        in.close();
        echoSocket.close();
        System.out.println(output);

        return output;
    }

    public boolean get(int number) throws IOException {
        connect();
        String output;
        //System.out.println(files.length);
        //ID=login("lala");
        ID="1234567890";
        out.println("GET " + ID+" "+number+"\n");
        output=in.readLine();

        out.close();
        in.close();
        echoSocket.close();
        System.out.println("ooo");
        System.out.println(output);
        return true;
    }

//levensthein z wikipedii

        private static int minimum(int a, int b, int c) {
            return Math.min(Math.min(a, b), c);
        }

        public static int computeLevenshteinDistance(CharSequence lhs, CharSequence rhs) {
            int[][] distance = new int[lhs.length() + 1][rhs.length() + 1];

            for (int i = 0; i <= lhs.length(); i++)
                distance[i][0] = i;
            for (int j = 1; j <= rhs.length(); j++)
                distance[0][j] = j;

            for (int i = 1; i <= lhs.length(); i++)
                for (int j = 1; j <= rhs.length(); j++)
                    distance[i][j] = minimum(
                            distance[i - 1][j] + 1,
                            distance[i][j - 1] + 1,
                            distance[i - 1][j - 1] + ((lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1));

            return distance[lhs.length()][rhs.length()];
        }

    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.login("lala");
            client.logout();
            client.ls();
            client.get(2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}