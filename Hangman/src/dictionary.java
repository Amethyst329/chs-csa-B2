import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class dictionary {
	private int MaxWords = 300;
	private String filename = "/home/student/hangman.txt";
	private String[] dictionary = new String[MaxWords];
	int dictSize = 0;
	//THE CONSTRUCTOR
	public dictionary() throws FileNotFoundException {
		// Open the dictionary file
		File dictFile = new File(filename);
		Scanner dictScan = new Scanner(dictFile);
		
		int index = 0;
		while (dictScan.hasNextLine() == true) {
			//Read in the line
			dictionary[index] = dictScan.nextLine();
			index = index + 1;
			dictSize += 1;
		}
		
		
	}
	
	public String randomWord() {
		Random rand = new Random();
		
		int randomWord = rand.nextInt(dictSize);
		System.out.println(randomWord);
		return(dictionary[randomWord]);
	}
}
