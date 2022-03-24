package tela;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import controle.TarefaControle;
import dao.EnviaEmailDAO;
import entidade.EnviaEmail;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTabbedPane abas;

	public Principal() throws Exception {

		super(" R O B O ");
		this.setSize(1200, 1000);

		abas = new JTabbedPane();
		abas.setFont(this.retornaFonte());

		abas.addTab("Tarefas", null, montarAbaTarefa());

		this.add(abas);

		TarefaControle tarefaControle = new TarefaControle();

		tarefaControle.start();

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		this.setVisible(true);

		EnviaEmailDAO emailDAO = new EnviaEmailDAO();

		List<EnviaEmail> listaEmails = new ArrayList<EnviaEmail>();

		listaEmails = emailDAO.listarTodos();
		
		for (EnviaEmail enviaEmail : listaEmails) {
			
			System.out.println(enviaEmail);
			
		}

	}

	private JPanel montarAbaTarefa() {

		JPanel aba = new JPanel();

		JPanel panelTarefas = new JPanel();

		JPanel botoes = new JPanel();

		botoes.setLayout(new FlowLayout());

		panelTarefas.add(botoes);

		aba.add(panelTarefas);

		return aba;

	}

	private Font retornaFonte() {

		return new Font("Arial", Font.PLAIN, 20);

	}

	public static void main(String args[]) throws Exception {

		String modo = System.getProperty("mode");

		if ((modo != null) && (modo.toUpperCase().equals("SERVER"))) {

			TarefaControle tarefaControle = new TarefaControle();

			tarefaControle.start();

			System.out.println("### Modo server ###");

		} else {

			new Principal();

		}

	}

}
