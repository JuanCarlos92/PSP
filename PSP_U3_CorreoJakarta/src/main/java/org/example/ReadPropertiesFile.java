package org.example;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class ReadPropertiesFile {
    public static void main(String[] args){
        // Prepare SMTP configuration into a Property object
        final Properties prop = new Properties();
        prop.put("mail.smtp.username", "juancarlosfilter@gmail.com");
        prop.put("mail.smtp.password", "dadufijihpvolyta");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); // TLS

        // Habilitar depuración
        prop.put("mail.debug", "true");
        // Create the Session with the user credentials
        Session mailSession = Session.getInstance(prop, new jakarta.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(prop.getProperty("mail.smtp.username"),
                        prop.getProperty("mail.smtp.password"));
            }
        });

        try {
            // Prepare the MimeMessage
            Message message = new MimeMessage(mailSession);
            // Set From and subject email properties
            message.setFrom(new InternetAddress("juancarlosfilter@gmail.com"));
            message.setSubject("CARAAAA PINGAAAAAA");
            // Set to, cc & bcc recipients
            InternetAddress[] toEmailAddresses =
                    InternetAddress.parse("juancarlosfilter@gmail.com, albertoheblesjimenez@gmail.com");
            message.setRecipients(Message.RecipientType.TO, toEmailAddresses);
            message.setText("Cacho zurullo te estoy enviando este correo por jakarta en java, chupame el pie y estudia php");

            Transport.send(message);

            System.out.println("Correo enviado");

        } catch (RuntimeException | MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}