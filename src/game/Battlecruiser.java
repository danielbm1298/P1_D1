package game;

import java.awt.event.KeyEvent;
/**
 * Esta clase es la de la nave espacial, hereda de la clase Sprite
 * genera los objetos tipo Battlecruiser que se utilizaran en la pantalla de juego
 * @author daniel brenes martínez
 *
 */
public class Battlecruiser extends Sprite{
	private int dx;
	private int dy;
	private SLL<Ammo> ammo;
	//Guardar los misiles en la lista
	/**
	 * Constructor de la clase
	 * @param x posicion en x
	 * @param y posicion en y
	 */
	public Battlecruiser(int x,int y) {
		super(x,y);
		iniciarBattlecruiser();
	}
	/**
	 * Carga la imagen para que se pueda utilizar en el juego
	 */
	private void iniciarBattlecruiser() {
		ammo = new SLL<Ammo>();
		cargarImagen("src/Resources/battlecruiser.png");
		getDimensionesImagen();
	}
	/**
	 * Este metodo hace que se mueva la nave
	 */
	public void mover() {
		x += dx;
		//y += dy;
		if(x<1) {
			x = 1;
		}
		//if(y<1) {
		//	y = 1;
		//}
	}
	public SLL<Ammo> getAmmo(){
		return ammo;
	}
	/**
	 * Este metodo revisa cuando una tecla es presionada
	 * @param e evento del teclado
	 */
	//Getter de misiles
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_SPACE) {
			disparar();
		}
		if(key == KeyEvent.VK_LEFT) {
			dx = -1;
		}
		if(key == KeyEvent.VK_RIGHT) {
			dx = 1;
		}
		if(key == KeyEvent.VK_UP) {
			dy = -1;
		}
		if(key == KeyEvent.VK_DOWN) {
			dy = 1;
		}
	}
	/**
	 * Este metodo hace posible disparar y que se desplieguen los misiles en pantalla
	 */
	public void disparar() {
		ammo.append(new Ammo(x + ancho/2,y + alto ));
	}
	/**
	 * Este metodo es cuando se deja de presionar una tecla en el teclado.
	 * @param e evento de tecla del teclado
	 */
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT) {
			dx = 0;
		}
		if(key == KeyEvent.VK_RIGHT) {
			dx = 0;
		}
		if(key == KeyEvent.VK_UP) {
			dy = 0;
		}
		if(key == KeyEvent.VK_DOWN) {
			dy = 0;
		}
	}
}
