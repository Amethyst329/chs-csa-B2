import javax.swing.JPanel;
import javax.swing.JLabel;

public class Screen extends JPanel {
	private JLabel display;
	private boolean startNewNumber = false;
	private boolean equals = false;
	public Screen() {
		
		System.out.println("Create Screen");
		display = new JLabel("0");
		super.add(display);
	}
	public void showIt() {
		super.setVisible(true);
	}
	public void postValue(double value) {
		display.setText(Double.toString(value));
	}
	public String getText() {
		return display.getText();
	}
	public void postDigit(String digit) {
		//What happens if 0 is on the screen
		String displayLine = display.getText();
		boolean decimal = false;
		String current = "";
		if (digit.equals("C")) {
			display.setText("0");
			decimal = false;
			
		}
		else {
			if (equals = true) {
				displayLine = "0";
				equals = false;
			}
			if (startNewNumber) {
				displayLine = "0";
				startNewNumber = false;
			}
			if (displayLine == "0") {
				display.setText(digit);
			}
			
			else {
				if (digit.equals(".")) {
					current = display.getText();
					if (current.indexOf(".") == -1) {
						display.setText(displayLine + digit);
					}
				}
				else {
					display.setText(displayLine + digit);
				}
			}
		}
	}
	
	public double getVal() {
		String displayLine = display.getText();
		double screenValue = Double.parseDouble(displayLine);
		return(screenValue);
		
	}
	
	public void startFresh() {
		startNewNumber = true;
		System.out.println("Start Fresh");
	}
}