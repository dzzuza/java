package lab_05.zad_1.zad_04_indico;

import io.indico.Indico;
import io.indico.api.results.IndicoResult;
import io.indico.api.results.BatchIndicoResult;
import io.indico.api.utils.IndicoException;
//import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MainFoto {
    private static String[] filesNames(String dirName) {
        String[] folder = new File(dirName).list();
        //File folder=new File(dirName);
        String[] listOfFiles = new String[folder.length];


        /*        for(int i=0;i<folder.length;i++) {
            System.out.println("lista"+folder[i]);
        }*/

        for (int i = 0; i < folder.length; i++) {
            listOfFiles[i] = dirName + "/" + folder[i];
        }
        return listOfFiles;
    }
    private static String[] getNames(String dirName) {
        String[] input = new File(dirName).list();
        String[] listOfNames = new String[input.length];
        for (int i = 0; i < input.length; i++) {
            listOfNames[i] = input[i];
        }
        return listOfNames;
    }
    public static void main(String[] args){
        Indico indico = null;
        try {
            indico = new Indico("d110c9126ffdb0a721752ee5785a13e6");
        } catch (IndicoException e) {
            e.printStackTrace();
        }
        String dirName = "src/lab_05/zad_1/zad_04_indico/foto";
        String[] input= filesNames(dirName);
        String[] output= getNames(dirName);

        // single example

        Map<String,Object>params=new HashMap<>();
        params.put("top_n",1);


        for (int i=0;i<input.length;i++){
            IndicoResult single = null;
            try {
                single = indico.imageRecognition.predict(
                        input[i],params
                );
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IndicoException e) {
                e.printStackTrace();
            }

            Map <String, Double> result = null;
            try {
                result = single.getImageRecognition();
            } catch (IndicoException e) {
                e.printStackTrace();
            }
            //File newDir=new File("src/lab_05/zad_1/zad_04_indico/foto_output_"+ result.entrySet().iterator().next().getKey());

            //newDir.mkdirs();
            try {
                FileUtils.copyFile(new File(input[i]),new File("src/lab_05/zad_1/zad_04_indico/foto_output_"+ result.entrySet().iterator().next().getKey()+"/"+output[i]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //System.out.println(result);

    }
}