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
import javax.swing.JTextField;

public class ListenToMe {
	public static void main(String[] args) {
		Frame mainFrame = new Frame();	
		PushCounterPanel pushPanel = new PushCounterPanel();
		mainFrame.add(pushPanel, BorderLayout.NORTH);
		
		// Add your Punch Panel!
		Punch punchPanel = new Punch();
		mainFrame.add(punchPanel, BorderLayout.CENTER);
		mainFrame.showIt();
		
		Convert convertIt = new Convert();
		mainFrame.add(convertIt, BorderLayout.SOUTH);
		mainFrame.showIt();
	}
}

class Frame extends JFrame {
	public Frame() {
		// Configure the JFrame!
		super.setTitle("Listeners");
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setBackground(Color.CYAN);
		super.setSize(300, 200);
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
		left.addActionListener(new ButtonLeft());
		right = new JButton("Right");
		right.addActionListener(new ButtonRight());
		label = new JLabel("Update Me");
		label.setHorizontalAlignment(JLabel.CENTER);
		super.setLayout(new BorderLayout());
		super.setPreferredSize(new Dimension(150,70));
		super.add(left, BorderLayout.WEST);
		super.add(right, BorderLayout.EAST);
		super.add(label, BorderLayout.NORTH);
	}
	
	private class ButtonLeft implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			label.setText("Button Left Clicked");
		}
		
	}
	
	private class ButtonRight implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			label.setText("Button Right Clicked");
		}
		
	}
}

class Convert extends JPanel {
	private JLabel fLabel, CLabel;
	private JTextField value;
	
	public Convert() {
		fLabel = new JLabel("Enter Temp (F)");
		value = new JTextField(5);
		value.addActionListener(new FtoC());
		CLabel = new JLabel("Temp in Celsius");
		super.setLayout(new BorderLayout());
		super.add(fLabel, BorderLayout.WEST);
		super.add(value, BorderLayout.CENTER);
		super.add(CLabel, BorderLayout.EAST);
		
	}
	
	private class FtoC implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			int fahrenheitTemp, celsiusTemp;
			
			String text = value.getText();

		      fahrenheitTemp = Integer.parseInt(text);
		      celsiusTemp = (fahrenheitTemp - 32) * 5 / 9;

		      CLabel.setText("Temp in Celsius:"+ celsiusTemp);
		}
	}
}
