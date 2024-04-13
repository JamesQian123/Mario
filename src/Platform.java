import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Platform extends GameObject{
	boolean landed = false;
	Platform(int x, int y, int height, int width) {
		super(x, y, height, width);
		// TODO Auto-generated constructor stub
		speed = 6;
		isActive = true;
		
	}
	void update() {
		x -= speed;
		super.update();
	}
	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x,y,width,height);
		
	}


}

	

