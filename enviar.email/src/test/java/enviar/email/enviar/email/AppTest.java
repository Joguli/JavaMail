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
		stringBuilderEnviarEmail.append("<h1>Olá<h1/><br/><br/>");
		stringBuilderEnviarEmail.append("<h2>Você está recebendo acesso ao curso de HTML.<h2/><br/>");
		stringBuilderEnviarEmail.append("<h4>Você pode ter acesso no botão abaixo.<h4/>");
		stringBuilderEnviarEmail.append("<a target=\"_blank\" href=\"https://projetojavaweb.com/certificado-aluno/login\" "
				+ "style=\" color:#252507; padding: 14px 25px; text-align: center; text-decoration: none;"
				+ "display: inline-block; border-radius: 30px; font-size: 20px; font-family: courier; border: 3px solid green;"
				+ "background-color: #99DA39\">"
				+ "Acesse o portal</a>");
		
		ObjetoEnviaEmail enviaEmail = 
				new ObjetoEnviaEmail("jolimonjes@gmail.com, vintetrezi@gmail.com",
						"DJv treinamento",
							"josuejdevjava@gmail.com", 
								stringBuilderEnviarEmail.toString());
		
		enviaEmail.enviarEmail(true);
		Thread.sleep(5000);

	}
    
}
