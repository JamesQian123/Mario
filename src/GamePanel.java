import java.awt.Color;
import java.awt.Font;
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
	   Font titleFont = new Font("Arial", Font.PLAIN, 48);
	   Font startFont = new Font("Arial", Font.PLAIN, 30);
	GamePanel(){
		p = new Player();
		frameDraw = new Timer(1000/60, this);
		frameDraw.start();
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
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("MarioDupe", 250, 150);
		g.setFont(startFont);
		g.setColor(Color.yellow);
		g.drawString("Press Enter to Start", 250, 250);
	}
	void drawGameState(Graphics g) {
		if(gotImage) {
			g.drawImage(image, 0, 0, 800,500,null);
		}
	}
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, MarioDupe.WIDTH, MarioDupe.HEIGHT);
		
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
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		}   
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
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
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU) {
			drawMenuState(g);
		}
		else if(currentState == GAME) {
			drawGameState(g);
		}
		else if(currentState == END) {
			drawEndState(g);
		}
	}
	}
	
	
