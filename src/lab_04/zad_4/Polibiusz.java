package lab_04.zad_4;

public class Polibiusz implements Algorithm {
    private final char[][] alphabet = { { 'A', 'B', 'C', 'D', 'E' },
            { 'F', 'G', 'H', 'I', 'K' }, { 'L', 'M', 'N', 'O', 'P' },
            { 'Q', 'R', 'S', 'T', 'U' }, { 'V', 'W', 'X', 'Y', 'Z' } };

    @Override
    public String crypt(String word) {
        String cipheredText = "";
        for(char j:word.toCharArray()){
            if(j==' '){
                cipheredText=cipheredText+" ";
            }
            for(int i=0;i<5;i++){
                for(int k=0;k<5;k++){
                    if(j==alphabet[i][k]){
                        cipheredText=cipheredText+i+k;
                    }
                }
            }
        }

            return cipheredText;
    }

    @Override
    public String decrypt(String cipheredText) {
        String decipheredText = "";
        //System.out.println(alphabet[0][1]);
        for (int i = 0; i < (cipheredText.length()); i +=2) {
            if(cipheredText.toCharArray()[i]==' '){
                System.out.println(i);
                decipheredText=decipheredText+' ';
                i-=1;
            }
            else {
                //decipheredText = decipheredText + alphabet[(cipheredText.charAt(i))][(cipheredText.charAt(i+1))];
                //System.out.println(Character.getNumericValue(cipheredText.charAt(i))+"x"+Character.getNumericValue(cipheredText.charAt(i+1))+"y");
                System.out.println(alphabet[Character.getNumericValue(cipheredText.charAt(i))][Character.getNumericValue(cipheredText.charAt(i + 1))]);
                decipheredText = decipheredText + (alphabet[Character.getNumericValue(cipheredText.charAt(i))][Character.getNumericValue(cipheredText.charAt(i + 1))]);
            }
        }
    return decipheredText;
    }
}
