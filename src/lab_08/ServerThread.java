package lab_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;

public class ServerThread implements Runnable {

    PrintWriter out;
    BufferedReader in;

    ServerThread(Socket clientSocket) throws IOException {
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(
                clientSocket.getInputStream()));
    }

    @Override
    public void run() {

        String inputLine;
        try {
            inputLine = in.readLine();

            if (inputLine.startsWith("LOGIN")) {
                String passInput = inputLine.split(" ")[1].split(";")[1];
                System.out.println(passInput);
                //if (passInput.equals(pass)) {
                MultiServer.logged = true;
                //ID = UUID.randomUUID().toString();
                //System.out.println(ID);
                //id = "1234567890";
                out.println(MultiServer.logged);
                //out.println(id);
            } else {
                MultiServer.logged = false;
                out.println("logowanie nie powiodło się, zalogowany: ");
            }

            if (inputLine.startsWith("LOGOUT")) {
                System.out.println("logout");
                String idInput = inputLine.split(" ")[1];
                System.out.println("id" + idInput);
                if (MultiServer.logged = true && idInput.equals("1234567890")) {
                    MultiServer.logged = false;
                    out.println(MultiServer.logged);
                } else {
                    out.println("error");
                }

            }
            if (inputLine.startsWith("LS")) {
                System.out.println(inputLine);
                String idInput = inputLine.split(" ")[1];
                System.out.println("id" + idInput);
                if (idInput.equals("1234567890")) {
                    out.println(Server.users.get(idInput));
                }
            }
            if (inputLine.startsWith("GET")) {
                System.out.println(inputLine);
                LinkedList<String> filenames;
                String idInput = inputLine.split(" ")[1];
                int number = Integer.parseInt(inputLine.split(" ")[2]);
                if (idInput.equals("1234567890")) {
                    filenames = (Server.users.get(idInput));
                    out.println(Server.files.get(filenames.get(number)));
                    System.out.println(Server.files.get(filenames.get(number)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}