package note14Recursion;

public class Recursion {
	
	public static void main(String[] args) {
		System.out.println(factoral(4));
		System.out.println(alphabet((int)('n')));
		System.out.println(bitCount(1023));
		
	}
	public static int factoral(int number) {
		System.out.println("Process Factor" + number);
		int result = 0;
		if (number == 1) {
			result = 1;
		}
		else {
			System.out.println("  Recurse: " + (number -1));
			result = number * factoral(number -1);
		}
		System.out.println("Returning: " + result);
		return(result);
	}
	
	public static String alphabet(int code) {
		String result;
		if (code == 'z') {
			result = "z";
		}
		else {
			result = (char)(code) + alphabet(code+1);
		}
		return(result);
	}
	
	public static int bitCount(int number) {
		System.out.println("Process Factor " + number);
		int storageNum = 0;
		if (number <= 1) {
			storageNum = 1;
		}
		else {
			System.out.println("  Recurse: " + (number -1));
			storageNum = 1 + bitCount(number / 2);
		}
		
		System.out.println("Returning: " + storageNum);
		return(storageNum);
	}
	
}

