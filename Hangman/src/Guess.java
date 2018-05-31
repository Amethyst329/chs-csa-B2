import java.util.Scanner;

public class Guess {
	private Scanner keyboard = new Scanner(System.in);
	public Guess() {
		// Do nothing for now
	}
	
	// getWord() - returned currently guessed word.
	public void getWord() {
		
	}
	
	// setWord(size)
	public String setWord(int size) {
		//System.out.println(size);
		int counter = 0;
		String blankWord = "";
		while (counter < size) {
			blankWord = blankWord + "-";
			counter += 1;
		}
		return(blankWord);
		
	}
	
	// setLetter(character, position)
	public String setLetter(String currentWord, char character, int position) {
		String newWord = "";
		int counter = 0;
		while (counter < currentWord.length()) {
			if (counter == position) {
				newWord = newWord + character;
			}
			else {
				newWord = newWord + currentWord.charAt(counter);
			}
			counter += 1;
		}
		return(newWord);
		
	}
	
	public char askForLetter() {
		// Ask the user for a letter
		char guessLetter;
		boolean validInput = false;
		while (validInput == false) {
			System.out.println("Enter a letter: ");
			String guessLine = keyboard.nextLine();
			if (guessLine.length() == 0 || guessLine.length() >= 2) {
				System.out.println("Please insert a valid input");
				System.out.println("");
			}
			else {
				guessLine = guessLine.toLowerCase();
				guessLetter = guessLine.charAt(0);
				if(guessLetter >= 'a' && guessLetter <= 'z') {
					System.out.println("You entered: " + guessLetter);
					validInput = true;
					return(guessLetter);
				}
				else {
					System.out.println("Please insert a valid input");
					System.out.println("");
				}
				
			}
		}
		
		return(' ');
		
		
	}
}
