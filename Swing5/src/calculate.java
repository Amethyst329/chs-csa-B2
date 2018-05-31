
import javax.swing.JFrame;
import java.awt.BorderLayout;


public class calculate {
	
	private JFrame frame;
	
	public static void main(String[] args) {
		calculate calc = new calculate();
		Screen mainScreen = new Screen();	

	}
	
	public calculate() {
		frame = new JFrame();
		Screen screen = new Screen();
		NumPad numPad = new NumPad(screen);
		MathPad mathPad = new MathPad(screen);
		
		frame.add(screen, BorderLayout.NORTH);
		frame.add(numPad,  BorderLayout.WEST);
		frame.add(mathPad);
		frame.pack();
		frame.setVisible(true);
		
//		screen.postDigit("8");
		screen.postDigit("0");
//		screen.postValue(0);
		System.out.println(screen.getVal());
	}
	
}