package lab_01.login;/*
  To change this template, choose Tools | Templates
  and open the template in the editor.
 */

//import sun.font.TrueTypeFont;
//package lab_01.login.Login;

public class Login {
    private String login;
    private String password;

    /**
     *
     * @param _login lab_01.login jaki dana instancja klasy będiz eprzechowywać
     * @param _password hasło jakie dana instancja klasy będiz eprzechowywać
     */
    public Login(String _login, String _password){
        login = _login;
        password = _password;
    }

    /**
     *
     * @param _login lab_01.login do porównania z przechowywanym wewnątrz obiektu
     * @param _password hasło do porównania z przechowywanym wewnatrz obiektu
     * @return prawda, gdy lab_01.login i hasło zgadzaja sie, fałsz gdy albo lab_01.login albo hasło nie pasuje do tych rpzechowywanych przez instancję kalsy
     */
    public boolean check(String _login, String _password){
        if ((login.equals(_login)) && (password.equals(_password))) {
            return true;
        }
        else {
            return false;
        }
    }

}
