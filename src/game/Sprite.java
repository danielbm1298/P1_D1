package game;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Sprite {
	protected int x;
	protected int y;
	protected int ancho;
	protected int alto;
	protected boolean visible;
	protected Image imagen;
	
	public Sprite(int x, int y) {
		this.x = x;
		this.y = y;
		visible = true;
	}
	protected void getDimensionesImagen() {
		ancho = imagen.getWidth(null);
		alto = imagen.getHeight(null);
	}
	protected void cargarImagen(String nombreImagen) {
		ImageIcon img = new ImageIcon(nombreImagen);
		imagen = img.getImage();
	}
	public Image getImage() {
		return imagen;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public boolean esVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public Rectangle getlimites() {
		return new Rectangle(x,y,ancho,alto);
	}

}
