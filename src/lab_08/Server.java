package lab_08;

import jdk.nashorn.api.tree.Tree;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server {

    static TreeMap<String, LinkedList<String>> users;
    static TreeMap<String, String> files;

    public static void main(String[] args) throws IOException {
        String pass = "lala";
        String id = "";

        //id/user,lista plikow
        //id/user,lista plikow
        users = new TreeMap<>();
        files = new TreeMap<>();
        LinkedList list = new LinkedList();

        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        users.put("1234567890", list);
        files.put("aaa", "zawartość aaa");
        files.put("bbb", "zawartość bbb");
        files.put("ccc", "zawartość ccc");

        Boolean logged = false;

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(3000);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 3000");
            System.exit(-1);
        }

        while (true) {
            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.out.println("Accept failed: 3000");
                System.exit(-1);
            }

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    clientSocket.getInputStream()));
            String inputLine;
            inputLine = in.readLine();


            if (inputLine.startsWith("LOGIN")) {
                String passInput = inputLine.split(" ")[1].split(";")[1];
                System.out.println(passInput);
                if (passInput.equals(pass)) {
                    logged = true;
                    //ID = UUID.randomUUID().toString();
                    //System.out.println(ID);
                    id = "1234567890";
                    out.println(logged);
                    out.println(id);
                } else {
                    logged = false;
                    out.println("logowanie nie powiodło się, zalogowany: " + logged);
                }
            }
            if (inputLine.startsWith("LOGOUT")) {
                System.out.println("logout");
                String idInput = inputLine.split(" ")[1];
                System.out.println("id" + idInput);
                if (logged = true && idInput.equals("1234567890")) {
                    logged = false;
                    out.println(logged);
                } else {
                    out.println("error");
                }

            }
            if (inputLine.startsWith("LS")) {
                System.out.println(inputLine);
                System.out.println(logged);
                String idInput = inputLine.split(" ")[1];
                System.out.println("id" + idInput);
                System.out.println(logged);
                if (idInput.equals("1234567890")) {
                    out.println(users.get(idInput));
                }
            }
            if (inputLine.startsWith("GET")) {
                System.out.println(inputLine);
                LinkedList<String> filenames;
                String idInput = inputLine.split(" ")[1];
                int number = Integer.parseInt(inputLine.split(" ")[2]);
                if (idInput.equals("1234567890")) {
                    filenames = (users.get(idInput));
                    out.println(files.get(filenames.get(number)));
                    System.out.println(files.get(filenames.get(number)));
                }
            }
        }
    }
}


/*                        Pattern pattern = Pattern.compile("(LOGIN|LOGOUT) ([^ ]+)([;]+)([^ ]+)?");
                        Matcher matcher = pattern.matcher(inputLine);
                        //System.out.println("1tu jestem"+matcher.group(1)+"2"+matcher.group(2)+"3"+matcher.group(3)+"4"+matcher.group(4));

                        if (matcher.find()) {
                            if (matcher.group(1).equals("LOGIN")) {
                                if (matcher.group(4).equals(pass)) {
                                    logged = true;
                                    id = "1234567890";
                                    out.println(logged);
                                    out.println(id);
                                } else {
                                    logged = false;
                                    out.println("logowanie nie powiodło się, zalogowany: " + logged);
                                }
                            }
                            if (matcher.group(1).equals("LOGOUT")) {
                                System.out.println("kto to");
                                if(matcher.group(2).equals("1234567890")){
                                    System.out.println("co to");
                                    logged=false;
                                    out.println(logged);
                                }
                            }
                        }
//                    if (matcher.group(1).equals("LS")) {}
//                    if (matcher.group(1).equals("GET")) {}

                        out.close();
                        in.close();
                        clientSocket.close();
                        serverSocket.close();*/

//}
