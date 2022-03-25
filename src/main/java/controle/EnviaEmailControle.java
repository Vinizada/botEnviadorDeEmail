package controle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.mail.internet.InternetAddress;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import dao.EnviaEmailDAO;
import dao.ModeloEmailDAO;
import entidade.ContaEmail;
import entidade.EnviaEmail;
import entidade.ModeloEmail;
import entidade.ServidorEmail;
import entidade.TipoVariavel;

public class EnviaEmailControle {

	private HtmlEmail htmlEmail;
	private ModeloEmail modelo;
	private ContaEmail conta;
	private ServidorEmail servidor;
	private Collection<InternetAddress> contasParaEnviar;
	private EnviaEmailDAO emailDAO = new EnviaEmailDAO();
	private ModeloEmailDAO modeloDAO = new ModeloEmailDAO();

	public void enviar() {

		try {

			// COMEÇA A ENTRAR AS VARIAVEIS QUE VEM DA TB_EMAILS

			List<EnviaEmail> listaEmailsParaEnviar = emailDAO.listarEmailsParaEnviar();

			for (EnviaEmail email : listaEmailsParaEnviar) {

				conta = new ContaEmail("TESTE");
				servidor = new ServidorEmail("TESTE");

				htmlEmail = new HtmlEmail();

				htmlEmail.setStartTLSEnabled(false);

				// htmlEmail.setHostName("diferpan-com-br.mail.protection.outlook.com");
				htmlEmail.setHostName(servidor.getHostname());

				htmlEmail.setSmtpPort(servidor.getPorta().intValue());

				// htmlEmail.setAuthenticator(new
				// DefaultAuthenticator("luiz.neto@diferpan.com.br", "lrn2027@"));
				htmlEmail.setAuthenticator(new DefaultAuthenticator(conta.getEmail(), conta.getSenha()));

				this.modelo = new ModeloEmail();

				htmlEmail.setFrom(conta.getEmail(), conta.getNome());

				this.modelo = modeloDAO.buscar(email.getId());

				htmlEmail.setSubject(modelo.getTitulo());

				htmlEmail.setHtmlMsg(retornaTexto(email));

				retornaContas(email);

				htmlEmail.send();

				System.out.println("E-mail enviado!");

			}


		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	private String retornaTexto(EnviaEmail emailParaEnviar) throws Exception {

		String texto = modelo.getTexto();

		String[] variaveis = emailParaEnviar.getEmails().split(";");

		for (int x = 0; x < variaveis.length; x++) {

			String[] variavel = variaveis[x].split("#");

			texto = trataVariavel(variavel[0], variavel[1], "TEXTO", texto);

		}

		return texto;

	}

	private String trataVariavel(String tag, String valor, String tipo, String texto) throws EmailException {

		if (tipo == TipoVariavel.TEXTO.toString()) {

			texto = alteraVariavelTexto(tag, valor, texto);

		} else if (tipo == TipoVariavel.LINK.toString()) {

			texto = alteraVariavelLink(tag, valor, texto);

		}

//		} else if (tipo == TipoVariavel.IMAGEM.toString()) {
//
//			texto = alteraVariavelImagem(variavel, texto);
//
//		} else if (tipo == TipoVariavel.ANEXO.toString()) {
//
//			adicionaAnexo(variavel, textoVariavel);
//
//		}

		return texto;

	}

//	private void adicionaAnexo(VariavelModelo variavel, String path) throws EmailException {
//
//		EmailAttachment anexoEmail = new EmailAttachment();
//		
//		String valores[] = path.split(";");
//
//		anexoEmail.setPath(valores[0]);
//		anexoEmail.setDisposition(EmailAttachment.ATTACHMENT);
//		anexoEmail.setDescription(variavel.getDescricao());
//		anexoEmail.setName(valores[1]);
//
//		htmlEmail.attach(anexoEmail);
//
//	}

	private String alteraVariavelTexto(String chave, String valor, String texto) {

		return texto.replace(chave, valor);

	}

	private String alteraVariavelLink(String tag, String valor, String texto) {

		return texto.replace(tag, "<a href=" + valor + ">" + valor + "</a>");

	}

//	private String alteraVariavelImagem(VariavelModelo variavel, String texto) {
//
//		URL url = null;
//
//		String cid = null;
//
//		try {
//
//			url = new URL(variavel.getValor());
//
//			cid = htmlEmail.embed(url, variavel.getTag());
//
//			texto = texto.replace(variavel.getTag(), "<img src=\"cid:" + cid + "\">");
//
//		} catch (Exception e) {
//
//		}
//
//		return texto;
//
//	}

	private void retornaContas(EnviaEmail emailParaEnviar) {

		try {
			
			this.contasParaEnviar = new ArrayList<InternetAddress>();

			String[] contatos = emailParaEnviar.getEmails().split(";");

			for (int x = 0; x < contatos.length; x++) {

				String[] contato = contatos[x].split("#");

				InternetAddress endereco = new InternetAddress(contato[1], contato[0]);

				this.contasParaEnviar.add(endereco);

			}

			htmlEmail.setTo(this.contasParaEnviar);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}


}
