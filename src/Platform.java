import java.awt.Color;
import java.awt.Graphics;

public class Platform extends GameObject {
	int speed;
	Platform(int x, int y, int height, int width) {
		super(x, y, height, width);
		// TODO Auto-generated constructor stub
		speed = 1;
	}
	void update() {
		x -= speed;
	}
	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(400,450,100,25);
	}

}

	

