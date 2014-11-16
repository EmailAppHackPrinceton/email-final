package trial;

//File Name SendEmail.java
//Test Comment
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {

  //Go Patriots!!!
  static String from;
  static String password;
  static Session session;
  
  //creates the session
  public static void createSession()
  {
	  Properties properties = System.getProperties();
      properties.setProperty("mail.smtp.host", "smtp.gmail.com");
      properties.setProperty("mail.smtp.auth", "true");
      properties.setProperty("mail.smtp.port", "587");
      properties.setProperty("mail.smtp.starttls.enable", "true");
      session = Session.getInstance(properties,
              new javax.mail.Authenticator() {
                  protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                      return new javax.mail.PasswordAuthentication(from, password);
                  }
              });
      
  }
  
  public static void sendEmail(String to, String emailMessage) {
     try {
        // Create a default MimeMessage object.
        MimeMessage mimeMessage = new MimeMessage(session);
        // Set From: header field of the header.
        mimeMessage.setFrom(new InternetAddress(from));
        // Set To: header field of the header.
        mimeMessage.addRecipient(Message.RecipientType.TO,
                                 new InternetAddress(to));
        // Set Subject: header field
        mimeMessage.setSubject("butts"); //fixme
        // Now set the actual message
        mimeMessage.setText(emailMessage);

        // Send message
        Transport.send(mimeMessage);

     } catch (MessagingException mex) {
        mex.printStackTrace();
     }
  }

  /*public static String messageGenerator(String firstName, String lastName) {
      String completeMessage = "";
      String beginning = "Dear " + firstName + " " + lastName + ",\n\n";
      String generalMessage = "butts";

      completeMessage = completeMessage + beginning;
      completeMessage = completeMessage + generalMessage;
      return completeMessage;
  }*/
  
  public static void setEmail(String login)
  {
	  from = login;
	 // System.out.println(from);
  }

  public static void setPass(String pass)
  {
	  password = pass;
	//  System.out.println(password);
  }
  
  public static void main(String [] args) 
  {
	  	LoginScreen.createAndShowLogin();
  }
}