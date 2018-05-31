package picross;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Board gameBoard = new Board();
		System.out.println("Welcome to Picross");
		try {
			gameBoard.generate("pokeball.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Did not work");
			e.printStackTrace();
		}
		
		
	}

}

class Board {
	Scanner file;
	public int x;
	public int y;
	private Scanner keyboard = new Scanner(System.in);
	Board() {
		// Nothing for now.
	}
	
	public char generate(String filename) throws FileNotFoundException{
		
		Scanner file2 = new Scanner( new File(filename));
		file = file2;
		x = file.nextInt();
		y = file.nextInt();
		System.out.println("Success" + x + y);
		
		return(' ');
	}
}

