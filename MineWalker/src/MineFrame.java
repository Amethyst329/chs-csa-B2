import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MineFrame extends JFrame{
	public MineFrame() {
		super("My Window tile");
		this.setSize(900, 700);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		colorBoard panel1 = new colorBoard();
		super.add(panel1, BorderLayout.WEST);
		
		scoreBoard panel2 = new scoreBoard();
		super.add(panel2, BorderLayout.EAST);
		
		buttonBoard panel3 = new buttonBoard();
		super.add(panel3, BorderLayout.SOUTH);
		
		fieldBoard panel4 = new fieldBoard();
		super.add(panel4, BorderLayout.CENTER);
		
		super.setVisible(true);
		panel3.variables(panel4);
		System.out.println(panel4.getWidth());
		System.out.println(panel4.getHeight());
	}
	
}
