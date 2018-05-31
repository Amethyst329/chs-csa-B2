
public class practice {
	public static void main(String[] args) {
		Practice practice = new Practice();
		double[] grid1 = new double[8];
		grid1[0] = 7;
		grid1[1] = 0;
		grid1[2] = 3;
		grid1[3] = 10;
		grid1[4] = -1;
		grid1[5] = 100;
		grid1[6] = 9;
		grid1[7] = 3;
		practice.gridSort(grid1);
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