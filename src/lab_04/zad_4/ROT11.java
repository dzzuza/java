package lab_04.zad_4;

public class ROT11 implements Algorithm{
    static final int diff =11;
    //static final String alfabet="abcdefghijklmnopqrstuvwxyz";
    final char[] alphabet = {'a', 'b', 'c', 'd', 'e',
            'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    final char[] alphabet2 ={'A', 'B', 'C', 'D', 'E',
            'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    @Override
    public String crypt(String word) {
        String cipheredText = "";
        for (char j : word.toCharArray()) {
            if (j == ' ') {
                cipheredText = cipheredText + " ";
            }
                if ((j >= 'a') && (j <= 'z')) {
                    cipheredText = cipheredText + alphabet[((j - 'a' + 11) % 26)];
                    // System.out.println();
                }
                if ((j >= 'A') && (j <= 'Z')) {
                    cipheredText = cipheredText + alphabet2[((j - 'A' + 11) % 26)];
                    // System.out.println();
                }
            System.out.println(cipheredText);
        }
        return cipheredText;
    }

    public String decrypt(String word) {
        String decipheredText = "";
        for (char k : word.toCharArray()) {
            if(k==' ') {
                decipheredText = decipheredText + " ";
            }
            if ((k >= 'a') && (k <= 'z')) {
                decipheredText = decipheredText + alphabet[((k - 'a'-11+alphabet.length) % alphabet.length)];
            }
            if ((k >= 'A') && (k <= 'Z')) {
                decipheredText = decipheredText + alphabet2[((k - 'A'-11+alphabet.length) % alphabet.length)];
            }
        }
        System.out.println(decipheredText);
    return decipheredText;
    }
}