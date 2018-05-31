
import java.util.Random;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		//Construct a match and play the game
			Match game1 = new Match();
	}

}

class Match {
	
	Match() {
		System.out.println("Create a match.");
		Secret sec = new Secret();
		Guess gues = new Guess();

		boolean Win = false;
		
		while (gues.getRound() != 10 && Win == false) {
			// Get a guess from the user
			gues.getGuess();
			// Get the actual number that was guessed.
//			System.out.println("The guessed number is: " + gues.getNumber());
		
//			System.out.println("The secret number is: " + sec.getSecretNum());
			
			System.out.println("win = " + Win);
		
			if (gues.getNumber() > sec.getSecretNum()) {
				System.out.println("Your guess is too high.");
			}
			else if (gues.getNumber() < sec.getSecretNum()) {
				System.out.println("Your guess is too low.");
			}
			else if (gues.getNumber() == sec.getSecretNum()) {
				System.out.println("Correct!");
				Win = true;
			}
			else {
				System.out.println("Your guess is invalid.");
			}	
		} //while ((sec.getSecretNum() != gues.getNumber()) && (gues.roundsRemaining()) );
	if (Win == true) {
			System.out.println("Congratulations! You are winner! :-)");
		}
		else {
			System.out.println("Game over. you ran out of rounds. :-(");
		} 
		
	}
}

/*
 * This is the class that keeps the secret number!
 */
class Secret {
	private int number = 0;
	
	Secret(){
//		System.out.println("Create a secret number.");
		//New up a random generator class
		Random rand = new Random();
		//Think of a number between 1 and 99 (inclusive)
		this.number = rand.nextInt(99) + 1;
//		System.out.println("The secret is " + this.number);
		
	}
	
	int getSecretNum() {
		return(this.number);
	}
	
}

/*
 * This is the class that gets guesses and tracks the attempts.
 */
class Guess {
	private int number = 0;
	private int round = 0;
	Scanner keybd;
	
	Guess(){
//		System.out.println("Create a new guess class");
		keybd = new Scanner(System.in);
		
	}
	
	//Accessor function to the user's guess.
	int getNumber() {
		return(this.number);
	}
	
	// This method is to ask the user for a guess
	void getGuess() {
		System.out.println("Please enter a number: ");
		this.number = keybd.nextInt();
		System.out.println("The number entered is: " + this.number);
		round = round +  1;
	}
	
	boolean roundsRemaining() {
		System.out.println("Attempts left is:" + this.round);
		return(this.round < 10);
	}
	
	int getRound() {
		return(this.round);
	}

}