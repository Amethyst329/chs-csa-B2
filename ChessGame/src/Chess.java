import java.util.Scanner;

public class Chess {

	public static void main(String[] args) {
		Board gameBoard = new Board();
		System.out.println("Welcome to Chess!");
		gameBoard.status();
	}

}

class Board {
	char[][] gameArray = new char [8][8];
	private Scanner keyboard = new Scanner(System.in);
	private char[] white = new char [8];
	private char[] black = new char [8];
	public Board() {
		white[0] = 'r';
		white[1] = 'n';
		white[2] = 'b';
		white[3] = 'q';
		white[4] = 'k';
		white[5] = 'b';
		white[6] = 'n';
		white[7] = 'r';
		
		black[0] = 'R';
		black[1] = 'N';
		black[2] = 'B';
		black[3] = 'Q';
		black[4] = 'K';
		black[5] = 'B';
		black[6] = 'N';
		black[7] = 'R';
		
		int val = 0;
		
		for(int i=0; i< gameArray.length; i++) {
			for(int j=0; j<gameArray[0].length; j++) {
				if (i == 0) {
					gameArray[i][j] = black[val];
				}
				else if (i == 1) {
					gameArray[i][j] = 'P';
				}
				else if (i == 6) {
					gameArray[i][j] = 'p';
				}
				else if (i == 7) {
					gameArray[i][j] = white[val];
				}
				else {
					gameArray[i][j] = '_';
				}
				val++;
			}
			val = 0;
		}
	}
	public char status() {
		int gameTurn = -1;
		boolean end = false;
		String winner = "";
		while (end == false) {
			
			gameTurn += 1;
			
		if (gameTurn == 0) {
				this.display();
			}
			
			if (gameTurn % 2 == 0) {
				this.turn('W');
			}
			else {
				this.turn('b');
			}
		
			this.display();
			end = true;
		}
		return(' ');
	}
	public void display() {
		System.out.println("|0|1|2|3|4|5|6|7|");
		System.out.println("");
		char[] rows = new char [8];
		rows[0] = 'a';
		rows[1] = 'b';
		rows[2] = 'c';
		rows[3] = 'd';
		rows[4] = 'e';
		rows[5] = 'f';
		rows[6] = 'g';
		rows[7] = 'h';
		int val = 0;
		for(int i=0; i< gameArray.length; i++) {
			
			for(int j=0; j<gameArray[0].length; j++) {
				System.out.print("|" + gameArray[i][j]);
				
			}
			System.out.println("| " + rows[val]);
			val++;
		}
		
	}
	char turn(char currentPlayer) {
		
		return(' ');
	}
}
