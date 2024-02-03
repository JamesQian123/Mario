import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements KeyListener, ActionListener{
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
		Player p;
		Timer frameDraw;
		public static BufferedImage image;
		public static boolean needImage = true;
		public static boolean gotImage = false;
	GamePanel(){
		p = new Player();
		frameDraw = new Timer(1000/60, this);
		if(needImage) {
			loadImage("background.png");
		}
	}
	void updateMenuState(){
		
	}
	void updateGameState() {
		
	}
	void updateEndState() {
		
	}
	void drawMenuState(Graphics g) {
		if(gotImage) {
			g.drawImage(image, 0, 0, 800,500,null);
		}
	}
	void drawGameState(Graphics g) {
		
	}
	void drawEndState(Graphics g) {
		
	}
	void loadImage(String imageFile) {
		if(needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch(Exception e) {
				e.printStackTrace();
			}
			needImage = false;
		}
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
			updateMenuState();
		}else if(currentState == GAME){
			updateGameState();
		}else if(currentState == END){
			updateEndState();
		}
		repaint();
	}
	}
	
	
