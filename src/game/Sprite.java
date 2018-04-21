package game;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
/**
 * Esta clase ayuda a crear objetos de tipo sprite para usar en el juego
 * @author daniel brenes martínez
 *
 */
public class Sprite {
	protected int x;
	protected int y;
	protected int ancho;
	protected int alto;
	protected boolean visible;
	protected Image imagen;
	/**
	 * constructor de la clase sprite
	 * @param x posicion en x
	 * @param y posicion en y
	 */
	public Sprite(int x, int y) {
		this.x = x;
		this.y = y;
		visible = true;
	}
	/**
	 * da las dimensiones de la imagen
	 */
	protected void getDimensionesImagen() {
		ancho = imagen.getWidth(null);
		alto = imagen.getHeight(null);
	}
	/**
	 * carga la imagen desde la direccion que se le de
	 * @param nombreImagen dato tipo string
	 */
	protected void cargarImagen(String nombreImagen) {
		ImageIcon img = new ImageIcon(nombreImagen);
		imagen = img.getImage();
	}
	/**
	 * retorna la imagen
	 * @return imagen
	 */
	public Image getImagen() {
		return imagen;
	}
	/**
	 * retorna la posicion en x
	 * @return posicion en x
	 */
	public int getX() {
		return x;
	}
	/**
	 * retorna la poscionion en y
	 * @return posicion en y
	 */
	public int getY() {
		return y;
	}
	/**
	 * visibilidad del sprite
	 * @return boolean
	 */
	public boolean esVisible() {
		return visible;
	}
	/**
	 * hacer visible 
	 * @param visible dato de tipo booleano
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	/**
	 * retorna los limites del rectangulo de la imagen, 
	 * esto para hacer la colision entre ojetos
	 * @return objeto de tipo rectangulo
	 */
	public Rectangle getlimites() {
		return new Rectangle(x,y,ancho,alto);
	}

}
