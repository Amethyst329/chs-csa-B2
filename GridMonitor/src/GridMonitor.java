import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class GridMonitor implements GridMonitorInterface{
	Scanner file;
	public double[][] grid;
	public double[][] sumGrid;
	public double[][] avgGrid;
	public double[][] deltaGrid;
	public boolean[][] dangerGrid;
	public int x;
	public int y;
	public GridMonitor(String filename) throws FileNotFoundException {
		Scanner file2 = new Scanner( new File(filename));
		file = file2;
		x = file.nextInt();
		y = file.nextInt();
		int xIndex = 0;
		int yIndex = 0;
		grid = new double [x] [y];

		
		while(xIndex < x) {
			while(yIndex < y) {
				grid[xIndex][yIndex] = file.nextDouble();
				yIndex++;
				
			}
			yIndex = 0;
			xIndex++;
		}
	}

	public double[][] getBaseGrid() {
		double[][] gridCopy = new double[grid.length][grid[0].length];
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				gridCopy[i][j] = grid[i][j];
			}
		}
		return (gridCopy);
	}

	public double[][] getSurroundingSumGrid() {
		//this.getBaseGrid();
		int xIndex = 0;
		int yIndex = 0;
		double sumBox = 0;
		sumGrid = new double[x][y];
		
		while(xIndex < x) {
			while(yIndex < y) {
				if (xIndex == 0) {
					sumBox += grid[xIndex][yIndex];
				}
				else {
					sumBox += grid[xIndex-1][yIndex];
				}
				if (yIndex == 0) {
					sumBox += grid[xIndex][yIndex];
				}
				else {
					sumBox += grid[xIndex][yIndex-1];
				}
				if (xIndex == x-1) {
					sumBox += grid[xIndex][yIndex];
				}
				else {
					sumBox += grid[xIndex+1][yIndex];
				}
				if (yIndex == y-1) {
					sumBox += grid[xIndex][yIndex];
				}
				else {
					sumBox += grid[xIndex][yIndex+1];
				}
				sumGrid[xIndex][yIndex] = sumBox;
				sumBox = 0;
				yIndex++;
			}
			yIndex = 0;
			xIndex++;
		}

		return (sumGrid);
	}

	public double[][] getSurroundingAvgGrid() {
		this.getSurroundingSumGrid();
		int xIndex = 0;
		int yIndex = 0;
		avgGrid = new double[x][y];
		while(xIndex < x) {
			while(yIndex < y) {
				avgGrid[xIndex][yIndex] = sumGrid[xIndex][yIndex] / 4;
				yIndex++;
			}
			yIndex = 0;
			xIndex++;
		}
		return (avgGrid);
	}

	public double[][] getDeltaGrid() {
		this.getSurroundingAvgGrid();
		int xIndex = 0;
		int yIndex = 0;
		deltaGrid = new double[x][y];
		while(xIndex < x) {
			while(yIndex < y) {
				deltaGrid[xIndex][yIndex] = avgGrid[xIndex][yIndex] / 2;
				if (deltaGrid[xIndex][yIndex] < 0) {
					deltaGrid[xIndex][yIndex] = deltaGrid[xIndex][yIndex] * -1;
				}
				yIndex++;
			}
			yIndex = 0;
			xIndex++;
		}
		return (deltaGrid);
	}

	public boolean[][] getDangerGrid() {
		this.getDeltaGrid();
		int xIndex = 0;
		int yIndex = 0;
		dangerGrid = new boolean[x][y];
		while(xIndex < x) {
			while(yIndex < y) {
				if (grid[xIndex][yIndex] > avgGrid[xIndex][yIndex] - deltaGrid[xIndex][yIndex] && grid[xIndex][yIndex] < avgGrid[xIndex][yIndex] + deltaGrid[xIndex][yIndex]) {
					dangerGrid[xIndex][yIndex] = false;
				}
				else {
					dangerGrid[xIndex][yIndex] = true;
				}
				yIndex++;
			}
			yIndex = 0;
			xIndex++;
		}
		return dangerGrid;
	}
	public String toString() {
		return("This is pointless.");
	}
}
