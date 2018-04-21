package game;
/**
 * Esta clase se utiliza para instanciar objetos de tipo Ammo
 * Los cuales son utilizados como proyectiles en el juego y se guardan en listas
 * @author daniel brenes martínez
 *
 */
public class Ammo extends Sprite{
	private final int Ancho_display = 390;
	private final int Alto_display = 290;
	private final int Velocidad = 2;
	/**
	 * Este metodo es el constructor
	 * @param x posicion en el eje de las x
	 * @param y posicion en el eje de las y
	 */
	public Ammo(int x, int y) {
		super(x,y);
		iniciarAmmo();
	}
	/**
	 * Este metodo carga la imagen a utilizar e inicia la clase de misiles
	 */
	private void iniciarAmmo() {
		cargarImagen("src/Resources/ammo.png");
		getDimensionesImagen();
	}
	/**
	 * Este metodo controla el movimiento de los misiles en la pantalla
 	 */
	public void mover() {
		y -= Velocidad;
		//if(y>Alto_display) {
		//	visible = false;
		//}
	}

}
