
public class Loops {
	public static void main(String[] args) {
		Loops Quiz = new Loops();
		System.out.println(Quiz.powerOfTwo(1));
		System.out.println(Quiz.sumNums(3, 5));
		System.out.println(Quiz.avgNums(0,4));

	}

	public Loops() {
		// Nothing to do
		
	}
	
	public int powerOfTwo(int power) {
		// This is question 1 of the quiz.
		int value = 2;
		int counter = 0; 
		
		do {
			value = value*value;
			counter = counter + 1;
		} while(counter != power); 
		
		return(value);
		
	}
	
	public int sumNums(int start, int stop) {
		//This is question 2 of the quiz.
		int counter = 0;
		int sum;
		
		
		for (sum = start; sum < stop; sum++) {
			counter = sum + counter;
		}
		return(counter);
	}
	
	public float avgNums(int start, int stop) {
		// This is question 3 of the quiz.
		int counter = start;
		float average = 0;
		
		while (counter < stop) {
			average = average + counter;
			counter = counter + 1;
		}
		
		average = average/2;
		
		return(average);
		
	}
}
