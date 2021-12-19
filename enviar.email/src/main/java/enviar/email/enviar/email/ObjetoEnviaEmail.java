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

public class ObjetoEnviaEmail {

	private String userName = "josuejdevjava@gmail.com";
	private String senha = "ruiandrade";
	private String listaDestinatarios = "";
	private String nomeRemetente = "";
	private String assuntoEmail = "";
	private String textoEmail = "";
	
	public ObjetoEnviaEmail(String listaDestinatario, String nomeRemetente, String assuntoEmail, String texString) {
		this.listaDestinatarios = listaDestinatario;
		this.nomeRemetente = nomeRemetente;
		this.assuntoEmail = assuntoEmail;
		this.textoEmail = texString;
	}
	public ObjetoEnviaEmail(String string, String string2, String string3, String string4, String string5) {
		// TODO Auto-generated constructor stub
	}
	public void enviarEmail(boolean envioHTML) throws Exception {

		// Olha as configurações do smtp do seu email.
		Properties properties = new Properties();

		properties.put("mail.smtp.ssl.trust", "*");
		properties.put("mail.smtp.auth", "true");// Autorização.
		properties.put("mail.smtp.starttls", "");// Autenticação.
		properties.put("mail.smtp.host", "smtp.gmail.com");// Servidor gmail google.
		properties.put("mail.smtp.port", "465");// Porta do servidor.
		properties.put("mail.smtp.socketFactory.port", "465");// Expecifica a porta a ser usada pelo socket.
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");// Classe socket de conexão.

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(userName, senha);
			}
		});

		Address[] toUser = InternetAddress.parse(listaDestinatarios);

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(userName, nomeRemetente));// Quem está
																										// enviando.
		message.setRecipients(Message.RecipientType.TO, toUser);// email de destino.
		message.setSubject(assuntoEmail);// Assunto do email.
		
		
		if(envioHTML){
			message.setContent(textoEmail, "text/html; charset=utf-8");
		}else {
			message.setText(textoEmail);
		}
		

		Transport.send(message);
	}

}
