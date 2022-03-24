package controle;

public class TarefaControle extends Thread {

	@SuppressWarnings("unused")
	private volatile boolean executa;

	public TarefaControle() {
		executa = true;
	
	}


	@Override
	public void run() {
 
		while (true) {

			try {
				new EnviaEmailControle().enviar();
		
				Thread.sleep(60000);

			} catch (Exception e) {


			}

		}

	}

}
