package com.example.sendemaildemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@RestController
public class EmailController {

    @RequestMapping(value = "/sendemail")
    public String sendEmail() throws IOException, MessagingException {
        sendmail();
        return "Email sent successfully";
    }

    private void sendmail() throws AddressException, MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("tieulongcp123@gmail.com", "longngo123");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("tieulongcp123@gmail.com", "Long Bee"));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("tieucongsonlong_t60@hus.edu.vn"));
        msg.setSubject("Send you my cat's photo");
//        msg.setContent("my cat's photo", "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("this is my miu miu , she is very beautiful , right ?? <3", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        MimeBodyPart attachPart = new MimeBodyPart();

        attachPart.attachFile("E://config/meo.jpg");
        multipart.addBodyPart(attachPart);
        msg.setContent(multipart);
        Transport.send(msg);
    }
}
