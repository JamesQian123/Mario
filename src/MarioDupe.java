import java.awt.Dimension;

import javax.swing.JFrame;

public class MarioDupe {
	JFrame frame;
	GamePanel panel;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 500;
	MarioDupe(){
		frame = new JFrame();
		panel = new GamePanel();
	}
	void setup() {
		frame.add(panel);
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(panel);
	}

}
