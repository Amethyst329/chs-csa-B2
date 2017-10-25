package note08Ceasar;

public class Caesar {

	public static void main(String[] args) {
		// Create an instance class called Cipher
		Cipher myCipher = new Cipher();
		
		// Call the method "encode" on the cipher class
		// passing a string and a key to the encode method.
		myCipher.swap("dog", 1);
	}

}

class Cipher{
	public Cipher(){
		
	}
	String swap(String str, int num) {
		String encryptString = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
		String decryptString = "zyxwvutsrqpomnlkjihgfedcbazyxwvutsrqpomnlkjihgfedcba";
		String newString = "";
		int counter = 0;
		int change = num;
	/*  if(num == 0) {
			return(str);
		}
		if(str.length() == 0) {
			return("");
		}
		while(change >= 26) {
			change -= 26;
		}
		while(change <= -26) {
			change += 26;
		}
		*/
		while(counter < str.length()) {
			
			newString = newString + str.charAt(counter);
			
		//	newString = /*Add to the current string*/newString + /*Find the character of the value in the string*/encryptString.indexOf(/*Add to the change value*/change + /*Figure out what place the value is at*/encryptString.charAt(/*Find first value of the string value*/encryptString.indexOf(/*Get value of string at whatever counter is*/str.charAt(counter))));
			counter += 1;
		}
		return(newString);
	}
	
}
