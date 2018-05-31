
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MathPad extends JPanel{
	private String [] keyLabels = {"/", "*", "-", "+", "Rm", "m+", "^", "="};
	Screen theScreen;
	String accumOp = "";
	double tempSave = 0;
	double accumReg = 0;
	boolean equals = false;
	
	public MathPad(Screen display) {
		super(new GridBagLayout());
		GridBagConstraints grid = new GridBagConstraints();
		MathPadKeyPressListener listener = new MathPadKeyPressListener();
		int count = 0;
		//Create a button at X, Y
		for (int x=0; x<2; x++) {
		
		for(int y=0; y<4; y++) {
			JButton button = new JButton(keyLabels[count]);
			button.addActionListener(listener);
			grid.gridx = x;
			grid.gridy = y;
			super.add(button, grid);
			count+=1;
		}
		}
		theScreen = display;
	}
	
	public double getAccumReg() {
		return(accumReg);
	}
	
	public void setAccumReg(double newAR) {
		accumReg = newAR;
	}
	
	private void processMathOp(String mathOpPressed) {
	/*	if (mathOpPressed == "=") {
			
			theScreen.equals();
			System.out.println(accumReg);
			if (accumOp == "+") {
				theScreen.postValue(accumReg + theScreen.getVal());
			}
			if (accumOp == "-") {
				theScreen.postValue(accumReg - theScreen.getVal());
			}
			if (accumOp == "/") {
				theScreen.postValue(accumReg / theScreen.getVal());
			}
			if (accumOp == "*") {
				theScreen.postValue(accumReg * theScreen.getVal());
			}
			if (accumOp == "^") {
				theScreen.postValue(Math.pow(accumReg, theScreen.getVal()));
			}
			accumReg = 0;

			System.out.println(accumReg);
		}
		else {
		
		
		
	*/	if (accumOp != "") {	
			if (equals = true) {
				accumReg = theScreen.getVal();
				equals = false;
			}
			switch(accumOp) {
				case "+":
					System.out.println("+");
					accumReg = accumReg + theScreen.getVal();
					System.out.println("accumVal");
					break;
				case "-":
					System.out.println("-");
					accumReg = accumReg - theScreen.getVal();
					System.out.println("accumVal");
					break;
				case "*":
					System.out.println("*");
					accumReg = accumReg * theScreen.getVal();
					System.out.println("accumVal");
					break;
				case "/":
					System.out.println("/");
					accumReg = accumReg / theScreen.getVal();
					System.out.println("accumVal");
					break;
				case "^":
					System.out.println("^");
					accumReg = Math.pow(accumReg, theScreen.getVal());
					System.out.println("accumVal");
					break;
				case "=":
					System.out.println("=");
					accumOp = "";
					equals = true;
					System.out.println("accumVal");
					break;
				default:
					System.out.println("invalid press");
					break;
				}
				if (equals == false) {
					theScreen.postValue(accumReg);
				}
				
				accumOp = mathOpPressed;
			}
		else {
				accumReg = theScreen.getVal();
				accumOp = mathOpPressed;
			
			}
			theScreen.startFresh();
		}
//	}
	
	class MathPadKeyPressListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton keyPressed = (JButton)event.getSource();
			
			processMathOp(keyPressed.getText());
		}
	}
}
