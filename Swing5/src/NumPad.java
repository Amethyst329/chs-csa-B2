
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumPad extends JPanel{
	private String [] keyLabels = {"7","8","9","4","5","6","1","2","3","0",".","C"};
	private Screen theDisplay;
	public NumPad(Screen display){
		
		super(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		NumPadKeyPressListener listener = new NumPadKeyPressListener();
		int labelIndex=0;
		for (int y=0; y<4; y++) {
			for(int x =0; x<3; x++) {
				JButton button = new JButton(keyLabels[labelIndex]);
				button.addActionListener(listener);
				
				labelIndex++;
				gbc.gridx = x;
				gbc.gridy = y;
				super.add(button, gbc);
			}
		}
		
		//Save display to access it from the listener
		theDisplay = display;
	}
	
	class NumPadKeyPressListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			JButton keyPressed = (JButton) event.getSource();
			System.out.println("The button " + keyPressed.getText() + " was pressed.");
			
				// Show the digit on the display
			
				theDisplay.postDigit(keyPressed.getText());
			
		}
	}
}
