import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
	Player p;
	ArrayList<Platform> platforms = new ArrayList<Platform>();
	Random rand;
	ObjectManager(Player p){
		this.p = p;
	}
	void addPlatform(){
		platforms.add(new Platform(rand.nextInt(MarioDupe.HEIGHT),0,100,25));
	}
	void update() {
		for(Platform p: platforms) {
			p.update();
			if(p.x <= MarioDupe.WIDTH) {
				p.isActive = false;
			}
		}
	}
	void draw(Graphics g) {
		p.draw(g);
		for(Platform p:platforms) {
			p.draw(g);
		}
	}
	void purgeObjects() {
		for(int i = 0; i < platforms.size(); i++) {
			if(!platforms.get(i).isActive) {
				platforms.remove(i);
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addPlatform();
	}

}
