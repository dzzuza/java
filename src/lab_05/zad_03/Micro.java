package lab_05.zad_03;
import java.io.*;
import java.util.StringTokenizer;

public class Micro {
    static void delay(String in, String out, int delay, int fps) throws lab_05.zad_03.SyntaxException {
        int time=0;
        try {
            FileReader fileReader = new FileReader(in);
            FileWriter fileWriter = new FileWriter(out);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


            String textLine = bufferedReader.readLine();
            while (textLine != null) {

                int start = textLine.indexOf("{",0);
                int stop = textLine.indexOf("}",0);
                int start2 = textLine.indexOf("{",stop);
                int stop2 = textLine.indexOf("}", stop+1);
                int stop3 = textLine.indexOf(".",stop2+1);

                String timeStart = textLine.substring(start+1, stop);
                String timeStop = textLine.substring(start2+1, stop2);
                String text = textLine.substring(stop2+1,stop3);
                //System.out.println(timeStart);
                //System.out.println(str2);
                for(int i=0;i<timeStart.length();i++){
                    if(!Character.isDigit(timeStart.charAt(i))){
                        throw new SyntaxException("Wrong input");
                    }
                }
                for(int i=0;i<timeStop.length();i++){
                    if(!Character.isDigit(timeStop.charAt(i))){
                        throw new SyntaxException("Wrong input");
                    }
                }
                if(Integer.parseInt(timeStart)>Integer.parseInt(timeStop)){
                    throw new OrderException("wrong time order");
                }

                time=delay*fps;
                //System.out.println(time);
                int timeStartDelay=Integer.parseInt(timeStart)+time;
                Integer timeStopDelayed=Integer.valueOf(timeStop)+time;

                bufferedWriter.write("{"+timeStartDelay+"}{"+timeStopDelayed+"}"+text);
                textLine = bufferedReader.readLine();
                bufferedWriter.newLine();
            }

            bufferedReader.close();
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("empty file");
        }
    }
}
        /*

            BufferedReader bufferedReader = null;
        int row = 0;
        try {
            FileReader fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            StringTokenizer token;
            String line;
            //line=bufferedReader.
            while ((line = bufferedReader.readLine()) != null) {
                token = new StringTokenizer(line, "}");
                while (token.hasMoreElements()) {
                    elements.add(Integer.parseInt(token.nextToken()));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                bufferedReader.close();
            }
            catch (IOException e) {
                e.getMessage();
                throw e;
            }
        }

    }*/