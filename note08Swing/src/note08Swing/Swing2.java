package note08Swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class Swing2 extends JFrame{
	public Swing2() {
	
		super("My Window tile");
		this.setSize(800, 600);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setVisible(true);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.BLUE);
		super.add(panel1, BorderLayout.NORTH);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.RED);
		super.add(panel2,  BorderLayout.SOUTH);
		
		JPanel centerPanel = new JPanel(new GridBagLayout());
		centerPanel.setBackground(Color.YELLOW);
		super.add(centerPanel, BorderLayout.CENTER);
		
		JPanel panel3 = new JPanel(new GridBagLayout());
		panel3.setBackground(Color.GREEN);
		super.add(panel3, BorderLayout.WEST);
		
		JPanel panel4 = new JPanel(new GridBagLayout()                    );
		panel4.setBackground(Color.MAGENTA);
		super.add(panel4, BorderLayout.EAST);
		
		JButton button1 = new JButton("button 1");
		button1.setBackground(Color.RED);
		panel1.add(button1);
		
		JButton button2 = new JButton("button 2");
		button2.setBackground(Color.GREEN);
		panel1.add(button2);
		
		JCheckBox cbox1 = new JCheckBox("Pizza");
		cbox1.setBackground(Color.CYAN);
		JCheckBox cbox2 = new JCheckBox("Chips");
		cbox2.setBackground(Color.CYAN);
		JCheckBox cbox3 = new JCheckBox("Drinks");
		cbox3.setBackground(Color.CYAN);
		JCheckBox cbox4 = new JCheckBox("Candy");
		cbox4.setBackground(Color.CYAN);
		
		panel2.add(cbox1);
		panel2.add(cbox2);
		panel2.add(cbox3);
		panel2.add(cbox4);
		
		JLabel labelA = new JLabel("Boring Label");
		JLabel labelB = new JLabel("Exciting Label");
		JLabel labelC = new JLabel("Cha Cha Cha");
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(20,10,40,30);
		gbc.gridx = 0;
		gbc.gridy = 0;
		centerPanel.add(labelA, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		centerPanel.add(labelB, gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		centerPanel.add(labelC, gbc);
		
		JButton[] buts = new JButton[10];
		String title = "Button Label: ";
		for (int i=0; i<10; i++) {
			buts[i] = new JButton(title + title.charAt(i));
		}
		

		int counter = 0;
		for (int y=1; y<3; y++) {
			gbc.gridy = y;
			for (int x=0; x<3 ; x++) {
			gbc.gridx = x;
			centerPanel.add(buts[counter], gbc);
			counter += 1;
			}
		}

		JButton[] buts2 = new JButton[4];
		
		String title2 = "ABCD";
		for (int j=0; j<4; j++) {
			buts2[j] = new JButton("" + title2.charAt(j));
			gbc.gridx = 0;
			gbc.gridy = j;
			panel3.add(buts2[j], gbc);
		}
		
		JButton[] buts3 = new JButton[2];
		String title3 = "LR";
		for (int k=0; k<2; k++) {
			buts3[k] = new JButton("" + title3.charAt(k));
		}
	/*	
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel3.add(buts2[0], gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel3.add(buts2[1], gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel3.add(buts2[2], gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel3.add(buts2[3], gbc);
		*/
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel4.add(buts3[0], gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel4.add(buts3[1], gbc);
		
		setVisible(true);
	}
}
