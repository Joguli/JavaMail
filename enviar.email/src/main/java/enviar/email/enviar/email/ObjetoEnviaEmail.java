package enviar.email.enviar.email;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.qrcode.ByteArray;

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
		
		/*parte 1 do email que é o texto e a descrição do email.
		MimeBodyPart corpoEmail = new MimeBodyPart();*/
		
		if(envioHTML){
			message.setContent(textoEmail, "text/html; charset=utf-8");
		}else {
			message.setText(textoEmail);
		}
		
		/* Parte 2 do email que sao os anexos em PDF
		MimeBodyPart anexoEmail = new MimeBodyPart();
		/* Onde é passado o simulador de PDF. *
		anexoEmail.setDataHandler(new DataHandler(new ByteArrayDataSource(simuladorDePDF(), "aplication/PDF")));
		anexoEmail.setFileName("anexoEmail.pdf");
		
		/* Junta as duas partes do email*
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(corpoEmail);
		multipart.addBodyPart(anexoEmail);
		
		message.setContent(multipart);*/
		
		Transport.send(message);
	}

	public void enviarEmailAnexo1(boolean envioHTML) throws Exception {

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
		
		/*parte 1 do email que é o texto e a descrição do email.*/
		MimeBodyPart corpoEmail = new MimeBodyPart();
		
		if(envioHTML){
			corpoEmail.setContent(textoEmail, "text/html; charset=utf-8");
		}else {
			corpoEmail.setText(textoEmail);
		}
		
		/* Parte 2 do email que sao os anexos em PDF*/
		MimeBodyPart anexoEmail = new MimeBodyPart();
		/* Onde é passado o simulador de PDF. */
		anexoEmail.setDataHandler(new DataHandler(new ByteArrayDataSource(simuladorDePDF(), "application/pdf")));
		anexoEmail.setFileName("anexoemail.pdf");
		
		/* Junta as duas partes do email*/
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(corpoEmail);
		multipart.addBodyPart(anexoEmail);
		
		message.setContent(multipart);
		
		Transport.send(message);
	}
	/*Esse método simula PDF ou qualquer outro arquivo.
	 * Retorna um PDF em branco com o texto do parágrafo.
	 * */
	private FileInputStream simuladorDePDF() throws Exception{
		Document documento = new Document();
		File file = new File("fileanexo.pdf");
		file.createNewFile();
		PdfWriter.getInstance(documento, new FileOutputStream(file));
		documento.open();
		documento.add(new Paragraph("Conteúdo do anexo JavaMail"));
		documento.close();
		
		return new FileInputStream(file);
		
	}
	public void enviarEmailAnexo(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
