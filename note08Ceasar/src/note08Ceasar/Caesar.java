package note08Ceasar;

import javax.swing.JOptionPane;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Caesar {

	public static void main(String[] args) throws FileNotFoundException {
	/*	
		String filename = JOptionPane.showInputDialog("Enter the file name");
		//JOptionPane.showMassageDialog(null, filename);
		
		Scanner file = new Scanner(new File("/home/student/" + filename));
		String aLine = file.nextLine();
		System.out.println(aLine);
		
		aLine = file.nextLine();
		System.out.println(aLine);
		
		*/
		// Create an instance class called Cipher
		Cipher myCipher = new Cipher("abcdefghijklmnopqrstuvwxyz.!,$?");
		
		// Call the method "encode" on the cipher class
		// passing a string and a key to the encode method.
	//	myCipher.swap("uif rvjdl$ cspxo gpy kvnqt pwfs uif mb.z eph!", -1);
	//	myCipher.swap("pet check", -2);
		
		
		
			/*
		//Hello World
		JOptionPane.showMessageDialog(null, "Hello, world!");
		
		//Get input from the user in a text dialog
		String answer = JOptionPane.showInputDialog("Enter Your Name");
		System.out.println(answer);
		JOptionPane.showMessageDialog(null, "The user entered " + answer);
		
		//Get input from user in a drop-down selection menu
		Object [] options = {"option 1", "option 2", "option 3" };
		Object optionPicked = JOptionPane.showInputDialog(null, "Pick an option", "Option menu",
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		
		JOptionPane.showMessageDialog(null, "The option picked: " + optionPicked);
		 */
		
			
		Object [] menu = {"Encode", "Decode", "Crack", "Exit"};
		Object optionPicked = JOptionPane.showInputDialog(null, "Pick an option", "Option menu",
				JOptionPane.PLAIN_MESSAGE, null, menu, menu[0]);
		Object [] inputValOptions = {1, 2, 3, 4, 5};
		
		Object inputValObject;
		
		int inputVal;
		String inputStr;
		
		while (optionPicked != "Exit") {
			if (optionPicked == "Encode") {
				
				inputStr = JOptionPane.showInputDialog("Enter the text you want to Encode");
			
				inputValObject = JOptionPane.showInputDialog(null, "Pick a key", "option menu",
						JOptionPane.PLAIN_MESSAGE, null, inputValOptions, inputValOptions[0]);
				
				inputVal = (Integer) inputValObject;
				
				JOptionPane.showMessageDialog(null, myCipher.swap(inputStr, inputVal));
				
				optionPicked = JOptionPane.showInputDialog(null, "Pick an option", "Option menu",
						JOptionPane.PLAIN_MESSAGE, null, menu, menu[0]);
			}
			if (optionPicked == "Decode") {
			
				inputStr = JOptionPane.showInputDialog("Enter the text you want to Decode");
			
				inputValObject = JOptionPane.showInputDialog(null, "Pick a key", "option menu",
						JOptionPane.PLAIN_MESSAGE, null, inputValOptions, inputValOptions[0]);
				
				inputVal = (Integer) inputValObject;
				
				inputVal = 0 - inputVal;
			
				JOptionPane.showMessageDialog(null, myCipher.swap(inputStr, inputVal));
				
				optionPicked = JOptionPane.showInputDialog(null, "Pick an option", "Option menu",
						JOptionPane.PLAIN_MESSAGE, null, menu, menu[0]);
			}
			if (optionPicked == "Crack") {
				JOptionPane.showMessageDialog(null, "Unavailable");
				
				optionPicked = JOptionPane.showInputDialog(null, "Pick an option", "Option menu",
						JOptionPane.PLAIN_MESSAGE, null, menu, menu[0]);
			}
		}
			 
		
	}


}


class Cipher{
	private String encryptString;
	
	public Cipher(String newAlphabet){
		setAlpha(newAlphabet);
	}
	private void setAlpha(String beta) {
		this.encryptString = beta + beta;
	}
	String swap(String str, int num) {
	//	String encryptString = alphabet + alphabet;
	//	String encryptString = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
		String newString = "";
		int alphabetLn = encryptString.length() / 2;
		int change = num;
		char letter;
		int alphIndex;
		int alphChange;
		
//		System.out.println("Plain Text = " + str);
//		System.out.println("Alphabet = " + encryptString.substring(0, alphabetLn));
		
	    if(num == 0) {
			return(str);
		}
		if(str.length() == 0) {
			return("");
		}
		while(change >= alphabetLn) {
			change -= alphabetLn;
		}
		while(change <= 0 - alphabetLn) {
			change += alphabetLn;
		}
		
		for(int counter = 0; counter < str.length(); counter++) {
		
	//	while(counter < str.length()) {
			
			if (change > 0) {
				if(str.charAt(counter) == ' ') {
					newString = newString + ' ';
				}
				else {
					//Looks for the first value of the string
					letter = str.charAt(counter);
					//Searches for the first instance of the letter provided by the string and gets the place value
					alphIndex = encryptString.indexOf(Character.toLowerCase(letter));
					//adds the place value to the wanted change and finds the character at the string
					alphChange = change + alphIndex;
					//adds the new character to the string
					if (Character.isUpperCase(str.charAt(counter)) == true) {
						newString = newString + Character.toUpperCase(encryptString.charAt(alphChange));
					}
					else {
						newString = newString + encryptString.charAt(alphChange);
					}
				}
			}
			else {
				if(str.charAt(counter) == ' ') {
					newString = newString + ' ';
				}
				else {
					//Looks for the first value of the string
					letter = str.charAt(counter);
					//Searches for the first instance of the letter provided by the string and gets the place value
					alphIndex = encryptString.lastIndexOf(Character.toLowerCase(letter));
					//adds the place value to the wanted change and finds the character at the string
					alphChange = change + alphIndex;
					//adds the new character to the string
					if (Character.isUpperCase(str.charAt(counter)) == true) {
						newString = newString + Character.toUpperCase(encryptString.charAt(alphChange));
					}
					else {
						newString = newString + encryptString.charAt(alphChange);
					}
					
				}
			}
			

		}
	//	System.out.println("New Text = " + newString);
	//	return("");
		return("New Text = " + newString);
	}
	
}
