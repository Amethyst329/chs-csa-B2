package note12Listener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenToMe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame mainFrame = new Frame();
		mainFrame.showIt();
		
		PushCounterPanel pushPanel = new PushCounterPanel(); 
		mainFrame.add(pushPanel);
		
	}

}

class Frame extends JFrame {
	public Frame(){
		// Configure JFrame!
		super.setTitle("Listeners!");
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setBackground(Color.CYAN);
		super.setSize(200,  200);
		
		// Move the set visible feature to a method called showIt()
		
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
		super.add(button);
		super.add(label);
	}
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			System.out.println("I'm Here!");
		}
	}
}