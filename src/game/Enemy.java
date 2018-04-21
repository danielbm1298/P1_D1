package game;
/**
 * Crea objetos de tipo enemy para utilizarlo en el juego
 * @author daniel brenes martínez
 *
 */
public class Enemy extends Sprite{
	private final int x_inicial = 400;
	/**
	 * Constructor de la clase
	 * @param x posicion en x
	 * @param y posicion en y
	 */
	public Enemy(int x,int y) {
		super(x,y);
		iniciarEnemy();
	}
	/**
	 * Inicia el tipo enemy carga la imagen del enemy
	 */
	private void iniciarEnemy() {
		cargarImagen("src/Resources/enemy.png");
		getDimensionesImagen();
	}
	public void mover() {
		if(x<0) {
			x = x_inicial;
		}
		x -= 1;
	}
}
