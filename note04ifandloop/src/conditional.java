

public class conditional {
	public conditional(){
		System.out.println("This is called...");
	}
	void gpa() {
		
		if (true) {
			System.out.println("The expression is true");
		}
		else {
			System.out.println("The expression is false");
		}
		
		int a = 0;
		
		if (a > 0) {
			System.out.println("Positive");
		}
		else if (a < 0) {
			System.out.println("Negative");
		}
		else {
			System.out.println("Zero");
		}
		double GPA = 3.9;
	
		if (4 >= GPA && GPA >= 3.5) {
			System.out.println("Go to movie");
		}
		else if (GPA >= 3) {
			System.out.println("Study");
		}
		else {
			System.out.println("Drop out");
		}
	}
}
