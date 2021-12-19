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
	public void testeEmail() throws Throwable {
		
		StringBuilder stringBuilderEnviarEmail = new StringBuilder();
		stringBuilderEnviarEmail.append("Testando HTML.");
		ObjetoEnviaEmail enviaEmail = 
				new ObjetoEnviaEmail("jolimonjes@gmail.com, vintetrezi@gmail.com",
						"DJv treinamento",
							"josuejdevjava@gmail.com", 
								"Serviço de envio de email com java. Testando HTML",
									stringBuilderEnviarEmail.toString());
		
		enviaEmail.enviarEmail(true);
		Thread.sleep(5000);

	}
    
}
