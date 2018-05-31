import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Board gameBoard = new Board();
		System.out.println("Welcome to Tic-Tac-Toe!");
		gameBoard.status();
		
		
	}

}

class Board {
	char [][] gameArray = new char [3][3];
	private Scanner keyboard = new Scanner(System.in);
	Board() {
		// Nothing for now.
		gameArray[0][0] = ' ';
		gameArray[1][0] = ' ';
		gameArray[2][0] = ' ';
		gameArray[0][1] = ' ';
		gameArray[1][1] = ' ';
		gameArray[2][1] = ' ';
		gameArray[0][2] = ' ';
		gameArray[1][2] = ' ';
		gameArray[2][2] = ' ';
		
	}
	
	void display() {
		//This method will display the current board.
		System.out.println("     0   1   2 ");
		System.out.println("A    "+gameArray[0][0]+" | "+gameArray[0][1]+" | "+gameArray[0][2]+" ");
		System.out.println("    -----------");
		System.out.println("B    "+gameArray[1][0]+" | "+gameArray[1][1]+" | "+gameArray[1][2]+" ");
		System.out.println("    -----------");
		System.out.println("C    "+gameArray[2][0]+" | "+gameArray[2][1]+" | "+gameArray[2][2]+" ");
		
		
	}
	
	public char status() {
		int gameTurn = -1;
		boolean end = false;
		while (end == false) {
			
			gameTurn += 1;
			
		//	System.out.println(gameTurn);
			
			if (gameTurn == 0) {
				this.display();
			}
		
			if (gameTurn % 2 == 0) {
				this.turn('X');
			}
			else {
				this.turn('O');
			}
			
			this.display();
			int row = 0;
			int col = 0;
			for (row=0; row<3; row++) {
				
				if (gameArray[row][col] == gameArray[row][col + 1] && gameArray[row][col] == gameArray[row][col + 2] && !(gameArray[row][col] == ' ')) {
					System.out.println(gameArray[row][col] + " wins!");
					end = true;
					//System.out.println("colWin");
					break;
					
				}
			}
			row = 0;
			col = 0;
			for (col=0; col<3; col++) {
				
				if (gameArray[row][col] == gameArray[row + 1][col] && gameArray[row][col] == gameArray[row + 2][col] && !(gameArray[row][col] == ' ')) {
					System.out.println(gameArray[row][col] + " wins!");
					//System.out.println("rowWin");
					end = true;
					break;
				}
			}
			row = 0;
			col = 0;
			if (gameArray[row][col] == gameArray[row + 1][col + 1] && gameArray[row][col] == gameArray[row + 2][col + 2] && !(gameArray[row][col] == ' ')) {
				System.out.println(gameArray[row][col] + " wins!");
				//System.out.println("negDiagonalWin");
				end = true;
				break;
			}
			if (gameArray[row][col + 2] == gameArray[row + 1][col + 1] && gameArray[row][col + 2] == gameArray[row + 2][col] && !(gameArray[row][col + 2] == ' ')) {
				System.out.println(gameArray[row][col + 2] + " wins!");
				//System.out.println("posDiagonalWin");
				end = true;
				break;
			}
			
			if (gameTurn == 8 && end == false) {
				System.out.println("It's a tie! Oh well.");
				end = true;
			}
		//	gameTurn += 1;
			
		}
		return(' ');
	}
	char turn(char currentPlayer) {
		
		 
		
		String P1Row = "";
		String P1Col = "";

		boolean turn = false;
		while (turn == false) {
			boolean P1RowAns = false;
			while (P1RowAns == false) {
				System.out.println("Player " + currentPlayer + " Enter Row:");
				P1Row = keyboard.nextLine();
				P1Row.toLowerCase();
				if (P1Row.equals("a")  || P1Row.equals("b") || P1Row.equals("c")) {
				P1RowAns = true;
				}
				else {
				System.out.println("Please print a valid input. of a, b, or c.");
				}
			}
			
			boolean P1ColAns = false;
			
			while (P1ColAns == false) {
				System.out.println("Player " + currentPlayer + " Enter Col:");
				P1Col = keyboard.nextLine();
				if (P1Col.equals("0") || P1Col.equals("1") || P1Col.equals("2")) {
				P1ColAns = true;
				}
				else {
				System.out.println("Please print a valid input. of 0, 1, or 2.");
				}
			}
		
	//		System.out.println("Player 1 Enter Col:");
	//		P1Col = keyboard.nextLine();
			
			if (P1Row.equals("a")) {
				P1Row = "0";
			}
			else if (P1Row.equals("b")) {
				P1Row = "1";
			}
			else {
				P1Row = "2";
			}
			
			if (gameArray[Integer.parseInt(P1Row)][Integer.parseInt(P1Col)] == ' '  ) {
				if (currentPlayer == 'X') {
					gameArray[Integer.parseInt(P1Row)][Integer.parseInt(P1Col)] = 'X';
					turn = true;
					
				}
				else {
					gameArray[Integer.parseInt(P1Row)][Integer.parseInt(P1Col)] = 'O';
					turn = true;
				}
			}
			else {
				System.out.println("This spot is already taken. please use a diferent input");
				P1Row = " ";
				P1Col = " ";
			}
		}
		return(' ');
	}
}

