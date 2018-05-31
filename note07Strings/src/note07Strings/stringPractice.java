package note07Strings;

public class stringPractice {

	public static void main(String[] args) {
		//Create our Case Switching Class
		Switch testSwitch = new Switch();
		DigitReplace testReplace = new DigitReplace();
		IndexTest dex1 = new IndexTest();
		System.out.println(testSwitch.switchCase("In Upper Case", true));
		System.out.println(testSwitch.switchCase("In Lower Case", false));
		System.out.println(testReplace.digitReplace("1dog2cat4pig"));
		System.out.println(testReplace.digitReplace("45"));
		System.out.println(testReplace.digitReplace(""));
		System.out.println(testReplace.digitReplace(""));
		dex1.runit();
		/*
		Substring ss1 = new Substring("What a wonderful world");
		ss1.runit();
		*/
		Social ssn1 = new Social();
		System.out.println(ssn1.check("abc-de-fghi"));
	}

}

class Social {
	Social() {
		
	}
	boolean check(String str) {
		if(str.length() == 11) {
			if(str.charAt(3) == '-' && str.charAt(6) == '-') {
				if(str.indexOf(0) >= 10 && str.indexOf(1) >= 10 && str.indexOf(2) >= 10 && str.indexOf(4) >= 10 && str.indexOf(5) >= 10 && str.indexOf(7) >= 10 && str.indexOf(8) >= 10 && str.charAt(9) >= 10 && str.charAt(10) >= 10) {
					return(true);
				}
				else {
					return(false);
				}
			}
			else {
			return(false);
			}
		}
		else {
			return(false);
		}
		
		
	}
}

class Switch {
	Switch() {
		
	}
	String switchCase(String str, boolean ucase) {
		// Check the boolean
		
		String returnString;
		// if ucase is true,
		if (ucase == true) {
			// Return the string in Upper case
			
			returnString = str.toUpperCase();
		}
		
		//else
		else {
			// Return the string as lower case
			returnString = str.toLowerCase();
		}
		return(returnString);
		
	}
}

class DigitReplace {
	DigitReplace() {
		//Do Nothing--for now
	}
	String digitReplace(String OrigStr) {
		String newString;
		if (OrigStr.length() == 0) {
			return("String Cannot Be Used");
		} else {
			newString = OrigStr.replace('0', '#');			
			newString = newString.replace('1', '#');
			newString = newString.replace('2', '#');
			newString = newString.replace('3', '#');
			newString = newString.replace('4', '#');
			newString = newString.replace('5', '#');
			newString = newString.replace('6', '#');
			newString = newString.replace('7', '#');
			newString = newString.replace('8', '#');
			newString = newString.replace('9', '#');
		}
		

		return(newString);
		
	}
	
}

class IndexTest {
	public IndexTest() {
		//Nothing for now
	}
	
	public void runit() {
		System.out.println("A simple test.".indexOf("simple"));
		System.out.println("A simple test.".indexOf("s", 6));
		System.out.println("A simple test.".lastIndexOf("s"));
		
		String str1 = new String("Another test of string methonds.");
		System.out.println(str1.indexOf('s'));
		
		
	}
}

class Substring {
	private String astring;
	public Substring(String strValue) {
		astring = strValue;
	}
	
	public void runit() {
		System.out.println("Vaule of calss variable: " + astring);
		System.out.println(astring.substring(5, 8));
		int start = 10;
		int end = astring.length();
		System.out.println(astring.substring(start, end));
	}
	

}
