package note09Arrays;

public class ArrayFun {

	public static void main(String[] args) {
		int val = 12;
		String [] arrayFun = new String[val];
		
		arrayFun[0] = "Essential Rules for Arrays";
		arrayFun[1] = "1. Arrays have a fixed length!!" + "At the time they are declared.";
		arrayFun[2] = "2. Two methods to set array size:";
		arrayFun[3] = " a. set the size with [ size ]";
		arrayFun[4] = " b. set the size using initial data { item1, item2, item3 }";
		arrayFun[5] = "3. YOU CANNOT CHANGE THE SIZE OF ARRAYS AFTER CREATION!";
		arrayFun[6] = " JJ Frustrated";
		arrayFun[7] = "4. Number 3, does not mean you can't change VALUES of arrays items";
		arrayFun[11] = "THE END!";
		// arrayFun[12] = "Produces a run time error!";
		
		// Print each of the strings in the array.
		// Try to use a loop! Don't cut and paste!
		int counter = 1;
		while (counter <= val) {
			System.out.println(arrayFun[counter - 1]);
			counter += 1;
		}
		
		FibArray myFib = new FibArray();
		myFib.printIt();
	}

}

//The fib array class will declare an array of integers.
//The array will have ten items.
//The array items will contain the fibanocci series.

class FibArray {
	private int[] arrayFib = new int[10];
	public FibArray() {
		arrayFib[0] = 1;
		arrayFib[1] = 1;
		
		for(int i=2; i<10; i++) {
			arrayFib[i] = arrayFib[i-1] + arrayFib[i-2];
		}
	}
	public void printIt() {
		int count = 0;
		while(count < 10) {
			System.out.println(arrayFib[count]);
			count += 1;
		}
		
		
	}
	
}