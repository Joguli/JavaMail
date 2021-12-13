package enviar.email.enviar.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class AppTest 
{
	
	private String userName = "josuejdevjava@gmail.com";
	private String senha = "ruiandrade";
	@org.junit.Test
	public void testeEmail() {
		
		try {
			//Olha as configurações do smtp do seu email.
			Properties properties = new Properties();
			
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
		 
		System.out.println(senha);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
  
}
