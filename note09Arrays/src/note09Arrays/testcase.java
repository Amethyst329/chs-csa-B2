package note09Arrays;

public class testcase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int [5];
		arr[0] = 1;
		arr[1] = 3;
		arr[2] = 2;
		arr[3] = 7;
		arr[4] = 3;
		System.out.println(arraySum(arr));
		
		int[][] arr2d = new int [4][5];
		
		arr2d[0][0] = 1;
		arr2d[0][1] = 3;
		arr2d[0][2] = 2;
		arr2d[0][3] = 7;
		arr2d[0][4] = 3;
		arr2d[1][0] = 10;
		arr2d[1][1] = 10;
		arr2d[1][2] = 4;
		arr2d[1][3] = 6;
		arr2d[1][4] = 2;
		arr2d[2][0] = 5;
		arr2d[2][1] = 3;
		arr2d[2][2] = 5;
		arr2d[2][3] = 9;
		arr2d[2][4] = 6;
		arr2d[3][0] = 7;
		arr2d[3][1] = 6;
		arr2d[3][2] = 4;
		arr2d[3][3] = 2;
		arr2d[3][4] = 1;
		
		System.out.println("");
		System.out.println(rowSums(arr2d)[0]);
		System.out.println(rowSums(arr2d)[1]);
		System.out.println(rowSums(arr2d)[2]);
		System.out.println(rowSums(arr2d)[3]);
		
		System.out.println("");
		System.out.println(isDiverse(arr2d));
	}
	public static int arraySum(int[] arr) {
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		
		return(sum);
	}
	public static int[] rowSums(int[][] arr2d) {
		int[] sumArray = new int [arr2d[0].length - 1];
		
		for(int i = 0; i < arr2d.length; i ++) {
			sumArray[i] = arraySum(arr2d[i]);
		}
		return(sumArray);
	}
	public static boolean isDiverse(int[][] arr2d) {
		int[] sumArray = new int [arr2d.length];
		
		for(int i = 0; i < arr2d.length; i ++) {
			sumArray[i] = arraySum(arr2d[i]);
			
		}
		for(int j = 0; j < arr2d.length; j ++) {
			for(int k = j + 1; k < arr2d.length; k ++) {
				if (sumArray[j] == sumArray[k]) {
					return(false);
				}
			}
			
		}
		return(true);
	}
}
