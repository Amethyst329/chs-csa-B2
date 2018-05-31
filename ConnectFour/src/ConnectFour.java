import java.util.Scanner;

public class ConnectFour {

	public static void main(String[] args) {
		Board gameBoard = new Board();
		System.out.println("Welcome to connect 4!");
		gameBoard.status();
	}

}

class Board {
	char[][] gameArray = new char [6][7];
	private Scanner keyboard = new Scanner(System.in);
	public Board() {
		for(int i=0; i< gameArray.length; i++) {
			for(int j=0; j<gameArray[0].length; j++) {
				gameArray[i][j] = '_';

			}
		}
	}
	
	public void display() {
		System.out.println("|0|1|2|3|4|5|6|");
		System.out.println("");
		for(int i=0; i< gameArray.length; i++) {
			
			for(int j=0; j<gameArray[0].length; j++) {
				System.out.print("|" + gameArray[i][j]);
			}
			System.out.println("|");
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
				this.turn('X');
			}
			else {
				this.turn('O');
			}
		
			this.display();
			int row = 0;
			int col = 0;
			//Check for horizontal win
			for (row=0; row<6; row++) {
				for (col=0; col<4; col++) {
					if(gameArray[row][col] == gameArray[row][col+1] && gameArray[row][col] == gameArray[row][col+2] && gameArray[row][col] == gameArray[row][col+3] && !(gameArray[row][col] == '_')) {
						end = true;
						if (gameTurn % 2 == 0) {
							winner = "X";
						}
						else {
							winner = "O";
						}
						System.out.println(winner + " is the winner!!!");
						break;
					}
				}
				
				
			}
			// Check for vertical win
			for (row=0; row<3; row++) {
				for (col=0; col<7; col++) {
					if(gameArray[row][col] == gameArray[row+1][col] && gameArray[row][col] == gameArray[row+2][col] && gameArray[row][col] == gameArray[row+3][col] && !(gameArray[row][col] == '_')) {
						end = true;
						if (gameTurn % 2 == 0) {
							winner = "X";
						}
						else {
							winner = "O";
						}
						System.out.println(winner + " is the winner!!!");
						break;
					}
				}
				
				
			}
			// Check for diagonal win, 
			for (row=0; row<3; row++) {
				for (col=0; col<4; col++) {
					if(gameArray[row][col] == gameArray[row+1][col+1] && gameArray[row][col] == gameArray[row+2][col+2] && gameArray[row][col] == gameArray[row+3][col+3] && !(gameArray[row][col] == '_')) {
						end = true;
						if (gameTurn % 2 == 0) {
							winner = "X";
						}
						else {
							winner = "O";
						}
						System.out.println(winner + " is the winner!!!");
						break;
					}
				}
			}
			for (row=3; row<6; row++) {
				for (col=0; col<4; col++) {
					if(gameArray[row][col] == gameArray[row-1][col+1] && gameArray[row][col] == gameArray[row-2][col+2] && gameArray[row][col] == gameArray[row-3][col+3] && !(gameArray[row][col] == '_')) {
						end = true;
						if (gameTurn % 2 == 0) {
							winner = "X";
						}
						else {
							winner = "O";
						}
						System.out.println(winner + " is the winner!!!");
						break;
					}
				}
			}
			if (gameTurn == 41 && end == false) {
				System.out.println("It's a tie! Oh well.");
				end = true;
			}
		}
		return(' ');
	}
	char turn(char currentPlayer) {

		
		 
		
		String P1Col = "";

		boolean turn = false;
		while (turn == false) {
			boolean P1ColAns = false;
			while (P1ColAns == false) {
				System.out.println("Player " + currentPlayer + " Enter Col:");
				P1Col = keyboard.nextLine();
				if (P1Col.equals("0") || P1Col.equals("1") || P1Col.equals("2") || P1Col.equals("3") || P1Col.equals("4") || P1Col.equals("5") || P1Col.equals("6")) {
				P1ColAns = true;
				}
				else {
				System.out.println("Please print a valid input of 0, 1, 2, 3, 4, 5, or 6");
				}
			}
			int counter = 5;
			while(counter >= 0 && turn == false) {
				if (gameArray[counter][Integer.parseInt(P1Col)] == '_'  ) {
					if (currentPlayer == 'X') {
						gameArray[counter][Integer.parseInt(P1Col)] = 'X';
						turn = true;
						
					}
					else {
						gameArray[counter][Integer.parseInt(P1Col)] = 'O';
						turn = true;
					}
				}
				counter--;
			}
			counter = 5;
			if (!(turn == true)) {
				System.out.println("This column is full. Select a different column");
				P1Col = " ";
			}
		}
		
		return(' ');
	}
}