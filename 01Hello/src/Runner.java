
public class Runner {
	
	/*
	 * This is the main  entry point of our application
	 */
	public static void main(String[] myargs) {
		// Print the traditional first program
		System.out.println("Hello World!");
		quote();
		hashtag();
		// Lets create a quotes object.
		Quotes abeLincoln = new Quotes();
		abeLincoln.sayit();
	}
	/*
	 * This is a function to print a famous quote
	 */
	public static void quote() {
		System.out.println("Whatever you are, be a good one,");
	}
	
	public static void hashtag() {
		System.out.println("####");
		System.out.println("####");
		System.out.println("####");
		System.out.println("####");
	}
}
