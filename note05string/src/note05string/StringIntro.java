package note05string;

public class StringIntro {
	
	public static void main(String[] args) {
		System.out.println("Starting String Practice...");
		Integer numClass = new Integer(105);
		int numNative = 5;
		StringTest test = new StringTest();
		StringTest2 testtwo = new StringTest2();
		StringTest3 testthree = new StringTest3();
		StringTest4 testfour = new StringTest4();
		StringTest5 testfive = new StringTest5();
		

		// Change the value of the native type
			numNative = numNative + 32;
		// Change the value of the class type
			numClass = numClass + 72;
		System.out.println(numClass);
		System.out.println(numNative);
		
		// Declare a string
		String MyString1 = new String("Aiai");
		System.out.println(MyString1);
		if (MyString1.length() <= 1) {
			System.out.println("String cannot be used");
		} else {
			System.out.println(MyString1.charAt(0));
		}
		System.out.println(MyString1.length());
//		System.out.println(MyString1.charAt(-6));
		
		int counter = 0;
		
		while (counter < MyString1.length()) {
			System.out.println(MyString1.charAt(counter));
			counter = counter + 1;
		}
		
		
		
		System.out.println(test.vow(MyString1));
		System.out.println(testtwo.vow(MyString1));
		System.out.println(testthree.vow(MyString1));
		System.out.println(testfour.vow("norma","hard"));
		

		
	}
	
}

class StringTest {
	public String vow(String str) {
		// Write a class method that accepts a string parameter. Return "yes" if the first or last letter is a vowel. Otherwise, return no.
		if (str.length() <= 0) {
			return("String cannot be used");
		}
		if (str.charAt(0) == 'a' || str.charAt(0) == 'e' || str.charAt(0) == 'i' || str.charAt(0) == 'o' || str.charAt(0) == 'u' || str.charAt(0) == 'A' || str.charAt(0) == 'E' || str.charAt(0) == 'I' || str.charAt(0) == 'O' || str.charAt(0) == 'U') {
			return("Yes");
		} else 	if (str.charAt(str.length() - 1) == 'a' || str.charAt(str.length() - 1) == 'e' || str.charAt(str.length() - 1) == 'i' || str.charAt(str.length() - 1) == 'o' || str.charAt(str.length() - 1) == 'u' || str.charAt(str.length() - 1) == 'A' || str.charAt(str.length() - 1) == 'E' || str.charAt(str.length() - 1) == 'I' || str.charAt(str.length() - 1) == 'O' || str.charAt(str.length() - 1) == 'U')
 {
			return("Yes");
		} else {
		return("No");
		}
	}
}

class StringTest2 {
	public String vow(String str) {
		if (str.length() <= 0) {
			return("String cannot be used");
		}
		int Length = str.length() - 1;
		boolean check = false;
		for (int counter = 0; counter <= Length; counter += 1) {
			if (str.charAt(counter) == 'a' || str.charAt(counter) == 'e' || str.charAt(counter) == 'i' || str.charAt(counter) == 'o' || str.charAt(counter) == 'u' || str.charAt(counter) == 'A' || str.charAt(counter) == 'E' || str.charAt(counter) == 'I' || str.charAt(counter) == 'O' || str.charAt(counter) == 'U') {
				check = true;
			}
			
		}
		if (check == true) {
			return("Yes");
		} else {
			return("No");
		}
	}
}

class StringTest3 {
	public String vow(String str) {
		if (str.length() <= 0) {
			return("String cannot be used");
		}
		int Length = str.length() - 1;
		String check =  new String("No");
		char first = str.toLowerCase().charAt(0);
		for (int counter = 1; counter <= Length; counter += 1) {
			if (str.charAt(counter) == first) {
				check = ("Yes");
			}
			
		}
			return(check);
	}
}

class StringTest4 {
	public double vow(String stringA, String stringB) {
		double avg = stringA.length() + stringB.length();
		avg = avg/2;
		return(avg);
	}
}

class StringTest5 {
	public String strChange (String str, boolean boo) {
		String newString;
		if (str.length() <= 0) {
			return("Invalid String");
		}
		if (boo == true) {
			newString = str.toUpperCase();
		}
		else {
			newString = str.toLowerCase();
		}
		return(newString);
	}
}

