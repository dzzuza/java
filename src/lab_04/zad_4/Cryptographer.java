package lab_04.zad_4;

import java.io.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Cryptographer {
    public static void cryptfile(String inputFile, Algorithm algorithm, String outputFile) {
        try {
            FileReader fileReader = new FileReader(inputFile);
            FileWriter fileWriter = new FileWriter(outputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String textLine = bufferedReader.readLine();
            while (textLine != null) {
                bufferedWriter.write(algorithm.crypt(textLine));
                bufferedWriter.newLine();
                textLine = bufferedReader.readLine();
            }

            bufferedReader.close();
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void decryptfile(String inputFile, Algorithm algorithm, String outputFile) {
        try {
            FileReader fileReader = new FileReader(inputFile);
            FileWriter fileWriter = new FileWriter(outputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String textLine = bufferedReader.readLine();
            while (textLine != null) {
                bufferedWriter.write(algorithm.decrypt(textLine));
                bufferedWriter.newLine();
                textLine = bufferedReader.readLine();
            }

            bufferedReader.close();
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
