import java.util.Scanner;

public class ConvertToSeconds {

	public static void main(String[] args) {
		
		System.out.println("How many seconds?");
		
		Scanner keyboard = new Scanner(System.in);
		// Go get the birth year from the user.
		int totalSeconds = keyboard.nextInt();
		
		int hours = totalSeconds / 3600;
		
		int minutes = (totalSeconds - (hours * 3600)) / 60;
		
		int seconds = (totalSeconds - (hours * 3600) - (minutes * 60));
		
		System.out.println("Hours: "  + hours);
		
		System.out.println("Minutes: " + minutes);

		System.out.println("Seconds: " + seconds);
	}

}
