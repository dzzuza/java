package lab_01.pesel;

public class Pesel {
    String pesel;
    public boolean check(){
        if(pesel.length()!=11){
            return false;
        }
        for(int i=0;i<11;i++){
            if(!Character.isDigit(pesel.charAt(i))){
                return false;
            }
        }
        int[] tab={9,7,3,1,9,7,3,1,9,7};
        int sum=0;
        for(int i=0;i<10;i++){
            sum+=(tab[i])*((int)pesel.charAt(i)-48);
        }
        sum=sum%10;

        if((pesel.charAt(10)-48)!=sum){
            return false;
        }
        return true;
    }
}
