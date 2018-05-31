package note02convert;

import java.text.DecimalFormat;
import java.math.RoundingMode;

public class Format {
	
	public Format() {
		System.out.println("A new format object! Yeah!");
	}
	
	public void out1() {
		double value = 1234.567;
		DecimalFormat myFormat;
		
		myFormat = new DecimalFormat("0.###");
		System.out.println("Value 1: " + myFormat.format(value));
		
		myFormat = new DecimalFormat("000000000.##");
		System.out.println("Value 1: " + myFormat.format(value));
		
		myFormat = new DecimalFormat("#,##,###.##");
		System.out.println("Value 1: " + myFormat.format(value));
		
		myFormat = new DecimalFormat("0.#");
		myFormat.setRoundingMode(RoundingMode.CEILING);
		System.out.println("Value 1: " + myFormat.format(value));
	}
}
