import java.awt.Rectangle;

public class GameObject {
int x;
int y;
int width;
int height;
int speed;
boolean isActive;
Rectangle collisionBox;
GameObject(int x, int y, int height, int width){
	this.x = x;
	this.y = y;
	this.height = height;
	this.width = width;
	isActive = true;
	collisionBox = new Rectangle();
	collisionBox.setBounds(x,y,width,height);
}
void update() {
	collisionBox.setBounds(x,y,width,height);
}
}
