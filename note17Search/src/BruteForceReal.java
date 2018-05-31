
public class BruteForceReal {

	public static void main(String[] args) {
		double[] sample = {5,33,77,12,0,-4,16};
		double key = 12;
		for (double value : sample) {
			if (value == key ) {
				System.out.println("Found the Key!");
				break;
			}
			System.out.println(value);
		}
		
		sample = Practice.gridSort(sample);
		// Search using binary style
		int lowIndex = 0;
		int highIndex = sample.length;
		while (lowIndex <= highIndex) {
			
		}

	}
}