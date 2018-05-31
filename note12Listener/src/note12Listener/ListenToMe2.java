package note12Listener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ListenToMe {
	public static void main(String[] args) {
		Frame mainFrame = new Frame();	
		PushCounterPanel pushPanel = new PushCounterPanel();
		mainFrame.add(pushPanel, BorderLayout.NORTH);
		
		// Add your Punch Panel!
		Punch punchPanel = new Punch();
		mainFrame.add(punchPanel, BorderLayout.CENTER);
		mainFrame.showIt();
	}
}

class Frame extends JFrame {
	public Frame() {
		// Configure the JFrame!
		super.setTitle("Listeners");
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setBackground(Color.CYAN);
		super.setSize(200, 200);
	}
	public void showIt() {
		super.setVisible(true);
	}
}

class PushCounterPanel extends JPanel {
	private int count = 0;
	private JLabel label;
	private JButton button;
	
	public PushCounterPanel() {
		label = new JLabel("Pushes: 0");
		button = new JButton("Push Me!");
		button.addActionListener(new ButtonListener());
		super.add(button, BorderLayout.NORTH);
		super.add(label, BorderLayout.SOUTH);
	}
	
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			// System.out.println("I'm here!");
			count = count + 1;
			label.setText("Pushes: " + count);
		}
	}
}

// Add a class called "Punch"
// In constructor, create 2 buttons, "left" and "right"
//                 create 1 label "Update me"
//                 setPreferredSize to 150, 70 for the JPanel
//                 add buttons and label to the panel
class Punch extends JPanel {
	private JButton left, right;
	private JLabel label;
	private JPanel panel;
	
	public Punch() {
		left = new JButton("Left");
		right = new JButton("Right");
		label = new JLabel("Update Me");
		label.setHorizontalAlignment(JLabel.CENTER);
		super.setLayout(new BorderLayout());
		super.setPreferredSize(new Dimension(150,70));
		super.add(left, BorderLayout.WEST);
		super.add(right, BorderLayout.EAST);
		super.add(label, BorderLayout.NORTH);
	}
}

