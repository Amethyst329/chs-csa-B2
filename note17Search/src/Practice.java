
public class Practice {

	public static double[] gridSort(double[] sample) {
			double[] sortGrid = sample;
			int i = 0;
			int j = sortGrid.length - 1;
			double comp;
			while(i < j) {
				if(sortGrid[i] > sortGrid[i + 1]) {
					comp = sortGrid[i];
					sortGrid[i] = sortGrid[i+1];
					sortGrid[i+1] = comp;		
				}
				if(i == j-1 && !(j==1)) {
					i = -1;
					j = j-1;
				}
				i++;
			}
			int k = 0;
			while(k < sortGrid.length) {
				k++;
			}
		
		
		
		return(sortGrid);
		
	}

}
