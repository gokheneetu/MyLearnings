package com.example.selenium4java17.Sawal;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class SendEmail {

    public static void sendReportEmail(String toEmail, String subject, String body, String filePath) {
        // SMTP server configuration
        String host = "smtp.gmail.com"; // SMTP host for Gmail
        final String user = "neetugokhe089@gmail.com"; // Sender's email ID
        final String password = "@Vrishti1589"; // Sender's email password

        // Set up properties for the mail session
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Create a new session with the email account's credentials
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        try {
            // Create a MimeMessage
            MimeMessage message = new MimeMessage(session);

            // Set the from, to, subject, and body
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject(subject);

            // Create the body part of the email
            MimeBodyPart bodyPart = new MimeBodyPart();
            bodyPart.setText(body);

            // Create another body part for the attachment
            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(filePath);

            // Create a multipart message to combine the body and attachment
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(bodyPart);
            multipart.addBodyPart(attachmentPart);

            // Set the content of the message to the multipart object
            message.setContent(multipart);

            // Send the message
            Transport.send(message);
            System.out.println("Email sent successfully with the report!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Send the report via email
        sendReportEmail("gokhenisha1@gmail.com",
                "Test Execution Report",
                "Please find the attached test execution report.",
                "src/main/resources/email.html");
    }
}
