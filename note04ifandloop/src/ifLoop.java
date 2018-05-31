

public class ifLoop {
	
	public static void main(String[] args) {
		//The basic If structure
		conditional class1 = new conditional(); 
		class1.gpa();
		
		System.out.println(" ");
		
		System.out.println(" ");
		
		for (int i=1; i<11; i++ ) {
			System.out.print(i + " ");
		}
		
		System.out.println(" ");
		
		System.out.println(" ");
		
		int fibPrint = 1;
		
		int fibA = 0;
		
		int fibB = 0;
		
		while (fibPrint < 100000) {
			
			System.out.println(fibPrint);
			
			if (fibA >= fibB) {
				fibB = fibPrint;
			}
			else {
				fibA = fibPrint;
			}
			
			fibPrint = fibA + fibB;
		}
		
		fibPrint = 1;
		
		fibA = 0;
		
		fibB = 0;
		
		
		do {
			System.out.println(fibPrint + "");
			
			if (fibA >= fibB) {
				fibB = fibPrint;
			}
			else {
				fibA = fibPrint;
			}
			
			fibPrint = fibA + fibB;
			
		} while (fibPrint < 100000);
			
	
	}
}
