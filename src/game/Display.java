package game;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
/**
 * Esta clase se encarga de la pantalla del juego, 
 * despliega los enemigos, datos de juego, nave espacial entre otros
 * @author daniel brenes martínez
 *
 */
public class Display extends JPanel implements ActionListener{
	
	private Timer timer;
	private Battlecruiser battlecruiser;
	private SLL<Enemy> enemies;
	private boolean enjuego;
	private final int Battlecruiser_x = 190;
	private final int Battlecruiser_y = 282;
	private final int D_Ancho = 400;
	private final int D_Alto = 300;
	private final int DELAY = 15;
	/**
	 * Constructor de la clase
	 */
	private final int[][] pos = {
			{2380, 29}, {2500, 59}, {1380, 89},
	        {780, 109}, {580, 139}, {680, 239},
	        {790, 259}, {760, 50}, {790, 150},
	        {980, 209}, {560, 45}, {510, 70},
	        {930, 159}, {590, 80}, {530, 60},
	        {940, 59}, {990, 30}, {920, 200},
	        {900, 259}, {660, 50}, {540, 90},
	        {810, 220}, {860, 20}, {740, 180},
	        {820, 128}, {490, 170}, {700, 30}
	};
	
	public Display() {
		startDisplay();
	}
	/** 
	 * Inicia la pantalla de juego 
	 */
	private void startDisplay() {
		addKeyListener(new Adaptador());
		setFocusable(true);
		setBackground(Color.BLACK);
		setDoubleBuffered(true);
		enjuego = true;
		
		setPreferredSize(new Dimension(D_Ancho,D_Alto));
		
		battlecruiser = new Battlecruiser(Battlecruiser_x,Battlecruiser_y);
		
		iniciarEnemies();
		
		timer = new Timer(DELAY,this);
		timer.start();
	}
	/**
	 * Inicia los enemigos, para desplegarlos en pantalla
	 */
	public void iniciarEnemies() {
		enemies = new SLL<Enemy>();
		for(int[] p : pos) {
			enemies.append(new Enemy(p[0],p[1]));
		}
		
		//Lista de enemies
	}
	/**
	 * Despliega en pantalla los elementos de tipo graphics
	 * @param g elemento de tipo graphics
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(enjuego) {
			dibujarObjetos(g);
		}else {
			dibujarGameOver(g);
		}
		Toolkit.getDefaultToolkit().sync();
	}
	/**
	 * Despliega los objetos en pantalla
	 * @param g tipo de dato graphics
	 */
	private void dibujarObjetos(Graphics g) {
		if(battlecruiser.esVisible()) {
			//get x get y de la lista de misiles
			g.drawImage(battlecruiser.getImagen(), battlecruiser.getX(), battlecruiser.getY(), this);
		}
		SLL<Ammo> am = battlecruiser.getAmmo();
		for(int i =0;i<am.getLength();++i) {
			Ammo ammo = am.getNode(i).getData();
			if(ammo.esVisible()) {
				g.drawImage(ammo.getImagen(), ammo.getX(), ammo.getY(), this);
				
			}
		}
		for(int i=0;i<enemies.getLength();i++) {
			Enemy en = enemies.getNode(i).getData();
			if(en.esVisible()) {
				g.drawImage(en.getImagen(), en.getX(), en.getY(), this);
			}
		}
		g.setColor(Color.WHITE);
		g.drawString("Enemies left: " + enemies.getLength(),5, 15);
		
	}
	/**
	 * Escribe game over cuando termina el juego
	 * @param g dato de tipo graphics
	 */
	public void dibujarGameOver(Graphics g) {
		String msg = "Game Over";
		Font small = new Font("Helvetica",Font.BOLD,14);
		FontMetrics fm = getFontMetrics(small);
		
		g.setColor(Color.white);
		g.setFont(small);
		g.drawString(msg, (D_Ancho - fm.stringWidth(msg))/2, D_Alto/2);
	}
	/**
	 * Ejecuta los metodos para iniciar el juego
	 */
	public void actionPerformed(ActionEvent e) {
		enjuego();
		updateBattlecruiser();
		updateAmmo();
		updateEnemies();
		rev_coll();
		repaint();
	}
	/**
	 * Metodo sobre si se esta en juego o no
	 */
	private void enjuego() {
		if(!enjuego) {
			timer.stop();
		}
	}
	/**
	 * actualizar la nave en pantalla
	 */
	private void updateBattlecruiser() {
		if(battlecruiser.esVisible()) {
			battlecruiser.mover();
		}
	}
	/**
	 * actualizar los misisles en pantalla
	 */
	private void updateAmmo() {
		SLL<Ammo> am = battlecruiser.getAmmo();
		for(int i = 0; i<am.getLength();i++) {
			Ammo ammo = am.getNode(i).getData();
			if(ammo.esVisible()) {
				ammo.mover();
			}else {
				am.delete(i);
				updateAmmo();
			}
		}
	}
	/**
	 * actualiza los enemigos en pantalla
	 */
	private void updateEnemies() {
		if(enemies.getLength() == 0) {
			enjuego = false;
			return;
		}
		for(int i = 0; i<enemies.getLength();i++) {
			System.out.println(enemies.getLength());
			Enemy en = enemies.getNode(i).getData();
			if(en.esVisible()) {
				en.mover();
			}else{
				enemies.delete(i);
				updateEnemies();
			}
		}
	}
	/**
	 * revisa si hay una colision entre objetos
	 */
	private void rev_coll() {
		Rectangle r3 = battlecruiser.getlimites();
		for(int i=0;i<enemies.getLength();i++) {
			Enemy en = enemies.getNode(i).getData();
			Rectangle r2 = en.getlimites();
			if(r3.intersects(r2)) {
				battlecruiser.setVisible(false);
				en.setVisible(false);
				enjuego  = false;
			}
		}
		SLL<Ammo> am = battlecruiser.getAmmo();
		for(int i =0;i<am.getLength();++i) {
			Ammo ammo = am.getNode(i).getData();
			Rectangle r1 = ammo.getlimites();
			for(int j=0;j<enemies.getLength();j++) {
				Enemy en = enemies.getNode(j).getData();
				Rectangle r2 = en.getlimites();
				if(r1.intersects(r2)) {
					ammo.setVisible(false);
					en.setVisible(false);
				}					
			}
		}
		
	}
	/**
	 * Esta clase sobreescribe el metodo Key released del paquete awt
	 * para que se pueda utilizar en el juego
	 * @author daniel brenes martinez
	 *
	 */
	private class Adaptador extends KeyAdapter{
		public void keyReleased(KeyEvent e) {
			battlecruiser.keyReleased(e);
		}
		public void keyPressed(KeyEvent e) {
			battlecruiser.keyPressed(e);
		}
	}

}
