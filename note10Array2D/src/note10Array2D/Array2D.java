package note10Array2D;

public class Array2D {

	public static void main(String[] args) {
		/*Notes on 2 dimensional arrays!*/
		
		// Create an array of 8 integers, and initialize them with something
		/*
		int [] array2D = new int[8];
		for (int i=0; i<8; i++) {
			array2D[i] = i+10;
		}
		
		int counter = 1;
		while (counter <= 8) {
			System.out.println(array2D[counter - 1]);
			counter += 1;
		}
		*/
		
		
		// Declare a 2 dimensional array!
		int [][] array2D = new int [4][5];
		// int [][] array2D = new int [5][4];
		array2D[3][4] = 10;
		array2D[1][2] = 50;
		System.out.println(array2D[3][4] + array2D[1][2]);
		
		//Declare a 2 dimension array!
				int [][] array2Dprime = {
						{10, 11, 12, 13 },
						{14, 15, 16, 17 },
						{18, 19, 20, 21 },
						{22, 23, 24, 25 },
						{26, 27, 28, 29 }
				};
		
		int count = 1;
		for (int x=0; x<4; x++) {
			for (int y = 0; y<5; y++) {
				array2D[x][y] = count;
				System.out.println("X = " + x + ", Y = " + y + ", Count = " + count + ".");
				
				count++;
			}
		}
		for (int x=0; x<5; x++) {
			for (int y=0; y<4; y++) {
				System.out.println(array2Dprime[x][y]);
			}
		}
	}

}
