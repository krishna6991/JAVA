import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
public class Connectivity extends Absfunc{
	@Override
	public Map<String, String> fetch() {
		Map<String,String> bday_data=new HashMap<String,String>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			Statement stmt=con.createStatement();
			ResultSet res=stmt.executeQuery("select * from Emply e where ((extract(month from e.Emp_DOB)) = (extract(month from sysdate))) and ((extract(day from e.Emp_DOB)) = (extract(day from sysdate)))");
			if(!res.next()) {
				System.out.println("Nothing Fetched");
			}
			while (res.next()) {
				bday_data.put(res.getString(2), res.getString(4));
			}
			for(String i:bday_data.keySet()) {
				System.out.println(i);
				System.out.println(bday_data.get(i));
			}
			con.close();
		
	}catch(Exception e) {System.out.println(e);}
	return bday_data;
	}
	
	public void SendMail(Map<String, String> map) {
		   String from = "irfan.irfan.ali35@gmail.com";
		      final String username = "irfan.irfan.ali35";
		      final String password = "xup.$786";
		      String host = "smtp.gmail.com";

		      Properties props = new Properties();
		      props.put("mail.smtp.auth", "true");
		      props.put("mail.smtp.starttls.enable", "true");
		      props.put("mail.smtp.host", host);
		      props.put("mail.smtp.port", "25");
		      Session session = Session.getInstance(props,
		         new javax.mail.Authenticator() {
		            protected PasswordAuthentication getPasswordAuthentication() {
		               return new PasswordAuthentication(username, password);
			   }
		         });
		      String to=null;
		      String Name=null;
		      try {
		    	  for(String i:map.keySet()) {
						  to = i;
						Name = map.get(i);
		          Message message = new MimeMessage(session);
		          message.setFrom(new InternetAddress(from));
		          message.setRecipients(Message.RecipientType.TO,
		             InternetAddress.parse(Name));
		          message.setSubject("Testing Subject");
		          MimeMultipart multipart = new MimeMultipart("related");
		          BodyPart messageBodyPart = new MimeBodyPart();
		          String htmlText = "<H1>Happy BirthDay "+to+"</H1><img src=\"cid:image\">";
		          messageBodyPart.setContent(htmlText, "text/html");
		          multipart.addBodyPart(messageBodyPart);
		          messageBodyPart = new MimeBodyPart();
		          DataSource fds = new FileDataSource(
		             "C:\\Users\\admin\\Desktop\\hbd.png");

		          messageBodyPart.setDataHandler(new DataHandler(fds));
		          messageBodyPart.setHeader("Content-ID", "<image>");
		          multipart.addBodyPart(messageBodyPart);
		          message.setContent(multipart);
		          Transport.send(message);
		          System.out.println("Sent message successfully....");
		    	  }
		      } catch (Exception e) {
		         throw new RuntimeException(e);
		      }
	   }
}