package enviar.email.enviar.email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class AppTest 
{
	
	private String userName = "josuejdevjava@gmail.com";
	private String senha = "ruiandrade";
	@org.junit.Test
	public void testeEmail() {
		
		try {
			//Olha as configurações do smtp do seu email.
			Properties properties = new Properties();
			
			properties.put("mail.smtp.ssl.trust", "*");
			properties.put("mail.smtp.auth", "true");// Autorização.
			properties.put("mail.smtp.starttls", "");// Autenticação.
			properties.put("mail.smtp.host", "smtp.gmail.com");// Servidor gmail google.
			properties.put("mail.smtp.port", "465");//Porta do servidor.
			properties.put("mail.smtp.socketFactory.port", "465");// Expecifica a porta a ser usada pelo socket.
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");//Classe socket de conexão.
		
			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					// TODO Auto-generated method stub
					return new PasswordAuthentication(userName, senha);
				}
			 });
		 
	Address[] toUser = InternetAddress.parse("jolimonjes@gmail.com, lisliefernandes@gmail.com");
	
	Message message = new MimeMessage(session);
	message.setFrom(new InternetAddress(userName, "Primeiro sistema de envio de email - Josué"));//Quem está enviando.
	message.setRecipients(Message.RecipientType.TO, toUser);// email de destino.	
	message.setSubject("Este email foi enviado pelo java - Josué");//Assunto do email.
	message.setText("Você acaba de receber um email enviado pelo curso JDEV-Treinamento.");
	
	Transport.send(message);
	
	
		} catch (Exception e) {
			e.printStackTrace();
		}	

	}
  
}
