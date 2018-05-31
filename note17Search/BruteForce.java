
public class BruteForce {
	public static void main(String[] args) {
		int[] sample = {5,33,77,12,0,-4,16};
		int key = 12;
		for (int value : sample) {
			if (value == key ) {
				System.out.println("Found the Key!");
			}
			System.out.println(value);
		}
		
		Practice practice = new Practice();
		practice.gridSort(sample);
		// Search using binary style
		int lowIndex = 0;
		int highIndex = sample.length;
		while (lowIndex <= highIndex) {
			
		}
	}
}

class Practice {
	public Practice() {
			
		
	}
	public void gridSort(double[] grid) {
		double[] sortGrid = grid;
		int i = 0;
		int j = sortGrid.length - 1;
		double comp;
		while(i < j) {
			if(sortGrid[i] > sortGrid[i + 1]) {
				comp = sortGrid[i];
				sortGrid[i] = sortGrid[i+1];
				sortGrid[i+1] = comp;
				System.out.println("At i:     " + sortGrid[i] +" " + (i));
				System.out.println("At i + 1: " + sortGrid[i + 1] +" " + (i+1));
				
			}
			if(i == j-1 && !(j==1)) {
				i = -1;
				j = j-1;
			}
			i++;
		}
		int k = 0;
		while(k < sortGrid.length) {
			System.out.println(sortGrid[k]);
			k++;
		}
	}
}