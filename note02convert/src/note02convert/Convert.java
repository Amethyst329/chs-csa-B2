package note02convert;

import java.util.Scanner;

public class Convert {

	public static void main(String[] args) {
		// Ask the user for their year of birth.
		Format example1 = new Format();
		example1.out1();
		
		System.exit(0);
		
		System.out.println("What year were you born?");
		// Create a scanner object to get input from the user.
		Scanner keyboard = new Scanner(System.in);
		// Go get the birth year from the user.
		int birthYear = keyboard.nextInt();
		// Calculate the approximate age
		
		System.out.println("What year was your last birthday?");
		
		int lastBirthYear = keyboard.nextInt();
		
		int age = lastBirthYear - birthYear;
		// Print the approximate age
		System.out.println("You are " + age + " years old");
		
		//Ask the user for the last year they had a birthday

	}

}
