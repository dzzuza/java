package lab_05.zad_04_indico;

import io.indico.Indico;
import io.indico.api.results.IndicoResult;
import io.indico.api.utils.IndicoException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainIndico {
        Indico indico;
        String katalog;
        String[] spis;
        List<File> fileList;

        public MainIndico(Indico _indico, String _katalog) throws IOException, NotImageException{
            indico = _indico;
            katalog = _katalog;
            File dirObj = new File(katalog);
            spis=dirObj.list();
            fileList = new ArrayList();
            for (int i = 0; i < spis.length; i++){
                File file= new File(katalog + "/" + spis[i]);
                String typ= Files.probeContentType(file.toPath()).split("/")[0];
                if(!typ.equals("image")){throw new NotImageException("something else is here");};
                fileList.add(file);
            }
        }

        public Map<String,Double> probability(int indeks) throws IndicoException, IOException {
            Map<String, Object> parametry = new HashMap<String, Object>();
            parametry.put("top_n", 5);
            parametry.put("hq", true);

            IndicoResult single = indico.imageRecognition.predict(fileList.get(indeks).toPath().toString(), parametry);
            Map<String, Double> result = single.getImageRecognition();

            System.out.println(spis[indeks] + " --> " + result.keySet() + ": " + result.values());
            return result;
        }
    }
