import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
	Player p;

	ArrayList<Platform> platforms = new ArrayList<Platform>();
	Random rand = new Random();
	ObjectManager(Player p){
		this.p = p;
	}

	void addPlatform() {
		platforms.add(new Platform(MarioDupe.WIDTH,rand.nextInt(150)+100,25,100));
	}
	void update() {
		
		for(Platform plat: platforms) {
			plat.update();
			if(plat.x <= -plat.width) { /// Fix this. 
				plat.isActive = false;
				if(!plat.landed) {
					p.isActive = false;
				}
			}
			
		}
		p.updatePos();
		checkCollisions();
	}
	void draw(Graphics g) {
		p.draw(g);
		for(Platform plat: platforms) {
			plat.draw(g);
		}
	}
	void purgeObjects() {
		for(int i  = 0; i < platforms.size(); i++) {
			if(!platforms.get(i).isActive) {
				platforms.remove(i);
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addPlatform();
		System.out.println(platforms.size());
		purgeObjects();
	}
	public void checkCollisions() {
		for(Platform plat: platforms) {
			if(p.collisionBox.intersects(plat.collisionBox) ) {
				handleCollisions(plat);
				return;
				
			}
			p.yLimit = 300;
		}
	}
	public void handleCollisions(Platform plat) {
		if(p.yVelocity >= 0 && p.y + p.height < plat.y + plat.height){
			p.yLimit=(plat.y - p.height);
			if(!p.firstPlatform) {
				p.firstPlatform = true;
			}
			plat.landed = true;
		}else{
			p.yLimit=(300);
		}
	
	}
	}

