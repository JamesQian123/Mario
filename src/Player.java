import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject{
	boolean isMovingUp = false;
	boolean isMovingDown = false;
	boolean isMovingRight = false;
	boolean isMovingLeft = false;
	int gravity = 1;
	int yVelocty = 0;
	int jumpPower = 20;
	
	int yLimit = 500;

	boolean canJump = false;
	
	Player(int x, int y, int height, int width){
		super(x,y,height,width);
	}
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
        speed = 5;
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
		if(isMovingUp && y > 0) {
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
		
		super.update();
	}
	public void jump(){
		if(canJump){
			yVelocty -= jumpPower;
			canJump = false;
		}
	}
}
