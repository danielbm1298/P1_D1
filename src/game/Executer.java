package game;
import javax.swing.*;
import java.awt.EventQueue;
/**
 * Esta clase es la clase main, ejecuta el juego.
 * @author daniel brenes martínez
 *
 */
public class Executer extends JFrame{
	/**
	 * Constructor de la clase
	 */
	public Executer() {
		iniciarIG();
	}
	/**
	 * Inicia el juego, tiene las caracteristicas de la pantalla o frame
	 */
	private void iniciarIG() {
		add(new Display());
		setResizable(false);
		pack();
		
		setTitle("Invaders");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * Metodo main que ejecuta el juego, al usar awt y swing se debe usar eventqueue.
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			Executer ex = new Executer();
			ex.setVisible(true);
			});
	}
}
