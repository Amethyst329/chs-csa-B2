import java.io.FileNotFoundException;

public class hangman {

	public static void main(String[] args) throws FileNotFoundException {
		String secretWord = "";
		System.out.println("Welcome to Hangman!");
		
		//Create a dictionary of words
		//Read the words from the file
		dictionary Words = new dictionary();
	//	Words.randomWord();
		secretWord = Words.randomWord();
	//	System.out.println(secretWord);
		System.out.println("The secret word has " + secretWord.length() + " letters");
		
		// 
		int gameEnd = 0;
		int counter;
		int numLetters;
		int ltrPos;
		int wrongGuessNum = 0;
		int correctGuessNum = 0;
		String guesses = "";
		char guessedLetter;
		//Create a guess object & call the ask for letter method
		Guess aGuess = new Guess();
		String fillWord = aGuess.setWord(secretWord.length());
		System.out.println(fillWord);
		while (gameEnd == 0) {
			guessedLetter = aGuess.askForLetter();
		
	//	System.out.println(guessedLetter);
	//	System.out.println(secretWord.indexOf(guessedLetter));
		
		//Evaluate if the guessed letter is in the secret word
			if (guesses.indexOf(guessedLetter) != -1) {
				System.out.println("You have already guessed " + "'"+ guessedLetter + "'");
			}
			else if(secretWord.indexOf(guessedLetter) != -1) {
				System.out.println("That is Correct!");
				//What letter is it?
				counter = 0;
				numLetters = 0;
				ltrPos = secretWord.indexOf(guessedLetter, counter);
				// LOOP while there are guessed letters in the secret word
				
				while (ltrPos != -1) {
					
				/*	if (counter != 0) {
						System.out.print(", and it is also ");
					}
					else {
						System.out.print("It is ");
					}
					
					System.out.print("at position: " + ltrPos);
					*/
					fillWord = aGuess.setLetter(fillWord, guessedLetter, ltrPos);
					
					counter = 1 + secretWord.indexOf(guessedLetter, counter);
					ltrPos = secretWord.indexOf(guessedLetter, counter);
					numLetters += 1;
					
					correctGuessNum += 1;
				}
				
					//Give the position of the letter
					// Get the next position
				if (numLetters > 1) {
					System.out.println("There are " + numLetters + " '" + guessedLetter + "'s.");
				}
				else {
					System.out.println("There is " + numLetters + " '" + guessedLetter + "'.");
				}
				numLetters = 0;
				guesses += guessedLetter;
				System.out.println(fillWord);
				if (correctGuessNum >= secretWord.length()) {
					gameEnd = 1;
				}
			}

			//Else
			else {
				//Wrong guess!
				guesses += guessedLetter;
				wrongGuessNum += 1;
				System.out.println("There is no '" + guessedLetter + "'. " + wrongGuessNum + " wrong guesses.");
				if (wrongGuessNum >= 6) {
					gameEnd = 2;
				}
				
			}
			
			
		
		}
		if (gameEnd == 1) {
			System.out.println("You Win!");
		}
		if (gameEnd == 2) {
			System.out.println("Sorry. The word was '" + secretWord + "'. Better luck next time.");
		}
			
	}

}
