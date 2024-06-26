import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Player extends GameObject{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	boolean isMovingUp = false;
	boolean isMovingDown = false;
	boolean isMovingRight = false;
	boolean isMovingLeft = false;
	int gravity = 1;
	int yVelocity = 0;
	int jumpPower = 20;
	
	int yLimit = 300;

	boolean canJump = false;
	boolean firstPlatform = false;
	Player(int x, int y, int height, int width){
		super(x,y,height,width);
		speed = 5;
		if (needImage) {
		    loadImage ("rabbit.png");
		}
	}
	void draw(Graphics g) {
	
        if (gotImage) {
        	g.drawImage(image, x, y, width, height, null);
        } else {
        	g.setColor(Color.BLUE);
        	g.fillRect(x, y, width, height);
        }
	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	
	public void jump(){
		if(canJump){
			yVelocity -= jumpPower;
			canJump = false;
		}
	}
	
	
	public void right() {
        x+=speed;
        
    }
	public void left() {
        x-=speed;
        
    }
	public void up() {
        jump();
       
    }
	public void down() {
        y+=speed;
      
    }
	void updatePos() {
		if(yLimit < 300) {
			x-=12;
		}
		if(isMovingUp && y > 0 && canJump) {
			//canJump = true;
			isMovingUp = false;
			up();
		}
		if(isMovingDown && y < MarioDupe.HEIGHT-width) {
			down();
		}
		if(isMovingRight && x < MarioDupe.WIDTH-width) {
			right();
		}
		if(isMovingLeft && x > 0) {
			left();
		}
		yVelocity += gravity;
		y += yVelocity;
		if(y >= yLimit) {
			y = yLimit;
			yVelocity = 0;
			canJump = true;
		}
		super.update();
	}
	
}
