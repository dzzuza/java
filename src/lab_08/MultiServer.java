package lab_08;

import jdk.nashorn.api.tree.Tree;
import java.lang.Thread;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MultiServer {

    static TreeMap<String, LinkedList<String>> users;
    static TreeMap<String, String> files;
    static Boolean logged;
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

        logged = false;

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
            new Thread(new ServerThread(clientSocket)).start();
        }
    }
}

