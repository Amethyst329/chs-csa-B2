package note08Swing;

import javax.swing.JFrame;

public class Swing1 extends JFrame{
	public Swing1() {
		
			super("My Window tile");
			this.setSize(800, 600);
			super.setDefaultCloseOperation(EXIT_ON_CLOSE);
			super.setVisible(true);
			
		
	}
	
	public void setSize(int w, int h) {
		System.out.println("Wrong function");
	}
}
