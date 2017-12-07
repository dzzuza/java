package lab_04.zad_2_3;

import java.util.Comparator;

public class SortujBrutto implements Comparator<Pracownik> {
  // Overriding the compare method to sort
        public int compare(Pracownik a1,Pracownik a2) {
            return  (int)(a1.getBrutto()-a2.getBrutto());
        }
    }
