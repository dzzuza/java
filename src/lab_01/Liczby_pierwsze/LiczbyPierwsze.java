package lab_01.Liczby_pierwsze;

import java.util.ArrayList;
import java.util.List;

public class LiczbyPierwsze {

    public void getPrim(int n) {
        List prim = new ArrayList();
        List multi = new ArrayList();
        for (int i=2;i<n+1;i++){
            if(!multi.contains(i)){
                    prim.add(i);
            }
            for(int k=i;k<n+1;k++){
                if(!multi.contains(k))
                    multi.add(k);
                    k+=i-1;
            }
        }
        System.out.println(prim);
    }
}
