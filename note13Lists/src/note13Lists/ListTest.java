package note13Lists;

import java.util.ArrayList;

public class ListTest {

	public static void main(String[] args) {
		// Call the welcome function
		welcome();
		
		// ArrayList
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(10);
		numbers.add(15);
		numbers.add(13);
		numbers.add(1,12);
		numbers.set(1,13);
		//System.out.println(numbers);
		Integer testThis = 15;
		numbers.remove(testThis);
		//System.out.println(numbers);
		// Get values from the list
		Integer first = numbers.get(0);
		Integer second = numbers.get(1);
		//System.out.println(first);
		//System.out.println(second);
		// Loop through a list
		for (int dex=0; dex<numbers.size(); dex++) {
			//System.out.println(numbers.get(dex));
		}
		//Loop through a list revisited
		for (Integer numb : numbers) {
			//System.out.println(numb);
		}
		//System.out.println(numbers);
		System.out.println(average(numbers));
		System.out.println(smallest(numbers));
		System.out.println(areDups(numbers));
	}

	// Create a private static function that prints a "Welcome" message.
	// Call it welcome(), takes no parameters, returns void
	private static void welcome() {
		System.out.println("Greetings Nerd! These are notes about ArrayLists");
	}
	
	// Create a private static function that takes a ArrayList<Integer> list
	// as a parameter and it returns the "double" average of all integers in the list
	private static double average(ArrayList<Integer> theList) {
		double average = 0;
		for (int dex=0; dex<theList.size(); dex++) {
			//System.out.println(theList.get(dex));
			average = average + theList.get(dex);
		}
		average = average / theList.size();
		return(average);
	}
	
	// Create a private static function that takes an ArrayList<Integer> list
	// as a parameter and it returns the smallest value in the list.
	private static Integer smallest(ArrayList<Integer> theList) {
		int smallest = theList.get(0);
		for (int dex=0; dex<theList.size(); dex++) {
			//System.out.println(theList.get(dex));
			if(theList.get(dex) < smallest) {
				smallest = theList.get(dex);
			}
		}
		return(smallest);
	}
	
	// Create a private static function that takes an ArrayList<Integer> list
	// as a parameter and it returns TRUE if the list contains duplicate numbers
	// FALSE if all values are unique or the list is empty.
	private static boolean areDups(ArrayList<Integer> theList ) {
		
		if (theList.size() <= 1) {
		return(false);
		}
		for (int dex=0; dex<theList.size(); dex++) {
			for (int dex2= dex + 1; dex2<theList.size(); dex2++) {
				//System.out.println(dex2);
				if (theList.get(dex) == theList.get(dex2)) {
					return(true);
				}
			}
		}
		return(false);
	}
}
	