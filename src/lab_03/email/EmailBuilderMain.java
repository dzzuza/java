package lab_03.email;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import java.util.LinkedList;
import java.util.Properties;

public class EmailBuilderMain {
    public static void main(String[] argv) {
        EmailMessage mail= null;
        try {
            mail=EmailMessage.builder()
                    .from("mailfortests3@gmail.com")
                    .to("dziedzic.zuzanna@gmail.com")
                    .subject("temat")
                    .content("tresc")
                    //.cc("")
                    .build();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        if(mail!=null){
            System.out.println("ok");
            System.out.println(mail.toString());
            mail.send();
        }
    }
}
