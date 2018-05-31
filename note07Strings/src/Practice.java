
public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Matching similarTest = new Matching();
		System.out.println(similarTest.similarities("",""));
	}

}

class Matching{
	Matching(){
		
	}
	String similarities(String str1, String str2) {
		String newString = "";
		if (!(str1.length() == str2.length()) || str1.length() == 0) {
			return("Strings cannot be used");
		}
		int counter = 0;
		while(counter < str1.length()) {
			if(str1.charAt(counter) == str2.charAt(counter)) {
				newString = newString + str1.charAt(counter);
			}
			else {
				newString = newString + '?';
			}
			counter += 1;
		}
		
		return(newString);
	}
}
