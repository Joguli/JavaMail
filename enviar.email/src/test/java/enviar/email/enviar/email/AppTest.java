package enviar.email.enviar.email;

import java.util.Properties;

public class AppTest 
{
	@org.junit.Test
	public void testeEmail() {
		//Olha as configurações do smtp do seu email.
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", "true");// Autorização.
		properties.put("mail.smtp.starttls", "");// Autenticação.
		properties.put("mail.smtp.host", "smtp.gmail.com");// Servidor gmail google.
		properties.put("mail.smtp.port", "465");//Porta do servidor.
		properties.put("mail.smtp.socketFactory.port", "465");// Expecifica a porta a ser usada pelo socket.
		properties.put(properties, properties);
		
	}
  
}
