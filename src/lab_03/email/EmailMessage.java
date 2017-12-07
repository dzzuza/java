package lab_03.email;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailMessage {
    private String from; //required (must be e-mail)
    private LinkedList<String> to; //required at least one (must be e-mail)
    private String subject; //optional
    private String content; //optional
    private String mimeType;  // optional
    private LinkedList<String> cc; //optional
    private LinkedList<String> bcc; // optional

    //Przykładowy konstruktor (można założyć, że pola opcjonalne mogą być null)
    public EmailMessage(Builder builder) {
        this.from=builder.from;
        this.to=builder.to;
        this.subject=builder.subject;
        this.content=builder.content;
        this.mimeType=builder.mimeType;
        this.cc=builder.cc;
        this.bcc=builder.bcc;
    }
    @Override
    public String toString() {
        return "EmailMessage{" +
                "from='" + from + '\'' +
                ", to=" + to +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", cc=" + cc +
                ", bcc=" + bcc +
                '}';
    }
    public static Builder builder(){
        return new EmailMessage.Builder();
    }

    public static class Builder {
        private String from; //required (must be e-mail)
        private LinkedList<String> to; //required at least one (must be e-mail)
        private String subject; //optional
        private String content; //optional
        private String mimeType;  // optional
        private LinkedList<String> cc; //optional
        private LinkedList<String> bcc; // optional
        String a = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";

        public Builder from(String _from) {
            if (!_from.matches(a)) {
                throw new IllegalArgumentException("to nie email");
            }
            this.from = _from;
            return this;
        }

        public Builder to(String... _to) {
            for (String p : _to) {
                //for (lab_02.punkty.Punkt3D p : punkty) {
                if (!p.matches(a)) {
                    throw new IllegalArgumentException("to nie ");
                }
            }
            this.to = new LinkedList<>(Arrays.asList(_to));
            return this;
        }

        public Builder content(String _content) {
            this.content = _content;
            return this;
        }

        public Builder subject(String _subject) {
            this.subject = _subject;
            return this;
        }

        public Builder mimeType(String _mimeType) {
            this.mimeType = _mimeType;
            return this;
        }

        public Builder cc(String... _cc) {
            this.cc = new LinkedList<>(Arrays.asList(_cc));
            return this;
        }

        public Builder bcc(String... _bcc) {
            this.bcc = new LinkedList<>(Arrays.asList(_bcc));
            return this;
        }

        EmailMessage build() {
            return new EmailMessage(this);
        }


    }

    public void send(){
        //from = "amakota321@gmail.com";
        //final String password = "javajava";

        final String username = "mailfortests3@gmail.com";
        final String password = "kwiatek123";

        Properties props = new Properties();
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to.get(0)));
            message.setSubject("Testing Subject");
            message.setText("Dear Mail Crawler,"
                    + "\n\n No spam to my email, please!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}