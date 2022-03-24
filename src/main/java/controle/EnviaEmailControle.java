package controle;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.mail.internet.InternetAddress;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import entidade.ContaEmail;
import entidade.Email;
import entidade.ModeloEmail;
import entidade.ServidorEmail;

public class EnviaEmailControle {

	private HtmlEmail htmlEmail;
	private List<Email> emailsEnviar;
	private ModeloEmail modelo;
	private ContaEmail conta;
	private Email email;
	private ServidorEmail servidor;

	public void enviar() {

		emailsEnviar = new ArrayList<>();

		Email emailTeste = new Email("TESTE");

		emailsEnviar.add(emailTeste);

		for (Email emailTemp : emailsEnviar) {

			try {
				
				this.email = emailTemp;

				modelo   = new ModeloEmail("TESTE");
				conta    = new ContaEmail("TESTE");
				servidor = new ServidorEmail("TESTE");

				htmlEmail = new HtmlEmail();
				
				htmlEmail.setStartTLSEnabled(false);

				
				//htmlEmail.setHostName("diferpan-com-br.mail.protection.outlook.com");
				htmlEmail.setHostName(servidor.getHostname());

				htmlEmail.setSmtpPort(servidor.getPorta().intValue());
				

				//htmlEmail.setAuthenticator(new DefaultAuthenticator("luiz.neto@diferpan.com.br", "lrn2027@"));
				htmlEmail.setAuthenticator(new DefaultAuthenticator(conta.getEmail(), conta.getSenha()));
				
				

				htmlEmail.setFrom(conta.getEmail(), conta.getNome());
			

				htmlEmail.setSubject(modelo.getTitulo());
				
				// temos que montar o texto
				htmlEmail.setHtmlMsg(modelo.getTexto());
				
				// insere os contatos
				this.insereContatos();

				htmlEmail.send();
				
				System.out.println("E-mail enviado!");

			} catch (Exception e) {

				e.printStackTrace();
				
			}

		}

	}
	

	private void insereContatos() throws UnsupportedEncodingException, EmailException {
		
		
		Collection<InternetAddress> listaEmail = new ArrayList<>();
		
		String[] contatos = email.getEmails().split(";");
		
		for(int x = 0; x < contatos.length; x++){
			
			String[] contato = contatos[x].split("#");
			
			InternetAddress endereco = new InternetAddress(contato[1], contato[0]);
			
			listaEmail.add(endereco);
            
        }
		
		htmlEmail.setTo(listaEmail);
		
	}

	public List<Email> getEmailsEnviar() {
		return emailsEnviar;
	}

	public void setEmailsEnviar(List<Email> emailsEnviar) {
		this.emailsEnviar = emailsEnviar;
	}

}
