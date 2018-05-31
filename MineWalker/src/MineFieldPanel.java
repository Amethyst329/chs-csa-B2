import java.awt.Color;

import java.util.concurrent.ThreadLocalRandom;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MineFieldPanel extends JPanel{
	public MineFieldPanel() {
		
	}

}
class fieldBoard extends JPanel{
	public ArrayList<Point> path = new ArrayList<Point>();
	static MineFieldButton [][] buttonBoard = new MineFieldButton [10] [10];
	static int size = 10;
	static public int numOfMines = size*size /5;
	
	static RandomWalk rw = new RandomWalk(10);
	
	public fieldBoard() {
		super(new GridBagLayout());
		newGame();
	}
	public void newGame() {
		
		GridBagConstraints grid = new GridBagConstraints();
		grid.gridx = 0;
		grid.gridy = 0;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size;j++) {
				buttonBoard[i][j] = new MineFieldButton();
				buttonBoard[i][j].setOpaque(true);
				buttonBoard[i][j].setBackground(Color.WHITE);
				
				buttonBoard[i][j].addActionListener(new pushButtonListener());
				
				buttonBoard[i][j].typeButton = 0;
				buttonBoard[i][j].onSquare = false;
				buttonBoard[i][j].clickedYet = false;
				buttonBoard[i][j].xCoo = i;
				buttonBoard[i][j].yCoo = j;
				
				
				if (i == size - 1 && j == 0) {
					buttonBoard[i][j].typeButton = 5;
					buttonBoard[i][j].setBackground(Color.MAGENTA);

				}
				if (j == size - 1 && i == 0) {
					buttonBoard[i][j].typeButton = 4;
					buttonBoard[i][j].setBackground(Color.CYAN);
					buttonBoard[i][j].onSquare = true;
				}
				if (super.getHeight() != 0) {
					if (super.getHeight() > super.getWidth()) {
						buttonBoard[i][j].setPreferredSize(new Dimension(Math.round(super.getWidth() / size), super.getWidth() / size));
						
					}
					if (super.getHeight() <= super.getWidth()) {
						buttonBoard[i][j].setPreferredSize(new Dimension(Math.round(super.getHeight() / size), super.getHeight() / size));
					}
					
				}
				else {
					buttonBoard[i][j].setPreferredSize(new Dimension(67 , 67));
				}
				if(i == 0 || j == 0) {
					rw.createWalk();
					path = rw.getPath();
				}
				if (path.indexOf(new Point(j,i)) != -1 && buttonBoard[i][j].typeButton == 0) {
					buttonBoard[i][j].typeButton = 3;
				}
				
				
				
				
				super.add(buttonBoard[i][j], grid);
				grid.gridy++;
			}
			grid.gridx++;
			grid.gridy = 0;
		}
		boolean setTrue = false;
		int xrand = 0;
		int yrand = 0;
		for(int k = 0;k < numOfMines;k++ ) {
			setTrue = false;
			while(setTrue == false) {
				xrand = ThreadLocalRandom.current().nextInt(0, size);
				yrand = ThreadLocalRandom.current().nextInt(0, size);
				if(buttonBoard[xrand][yrand].typeButton == 0) {
					buttonBoard[xrand][yrand].typeButton = 2;
					setTrue = true;
					
				}
			}
		}
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size;j++) {
				if(buttonBoard[i][j].typeButton == 0) {
					buttonBoard[i][j].typeButton = 1;
					buttonBoard[i][j].valueMines = 0;
				}
			}
		}
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size;j++) {
				if(i != size-1) {
					if(buttonBoard[i+1][j].typeButton == 2) {
						buttonBoard[i][j].valueMines = buttonBoard[i][j].valueMines + 1;
					}
				}
				if(i != 0) {
					if(buttonBoard[i-1][j].typeButton == 2) {
						buttonBoard[i][j].valueMines = buttonBoard[i][j].valueMines + 1;
					}
				}
				if(j != size-1) {
					if(buttonBoard[i][j+1].typeButton == 2) {
						buttonBoard[i][j].valueMines = buttonBoard[i][j].valueMines + 1;
					}
				}
				if(j != 0) {
					if(buttonBoard[i][j-1].typeButton == 2) {
						buttonBoard[i][j].valueMines = buttonBoard[i][j].valueMines + 1;
					}
				}
				
			}
		}
		super.setVisible(true);
	}
	public void refresh(String text) {
		size = Integer.parseInt(text);
		buttonBoard = new MineFieldButton [size][size];
		rw = new RandomWalk(size);
		numOfMines = size*size /5;
		super.setVisible(false);
		super.removeAll();
		newGame();
		gameRunning = true;
		scoreBoard.totalLives = 5;
		scoreBoard.totalScore = 1000;
		scoreBoard.lives.setText("Lives: " + scoreBoard.totalLives);
		scoreBoard.score.setText("Score: " + scoreBoard.totalScore);
		
		
	}
	boolean gameRunning = true;
	class pushButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			MineFieldButton mfb = (MineFieldButton) event.getSource();
			
			
			
			if (gameRunning == true){
				if(buttonBoard[mfb.xCoo][mfb.yCoo].onSquare == true && buttonBoard[mfb.xCoo][mfb.yCoo].clickedYet == false) {
					scoreBoard.totalScore = scoreBoard.totalScore - 10;
					scoreBoard.score.setText("Score: " + scoreBoard.totalScore);
					switch(buttonBoard[mfb.xCoo][mfb.yCoo].valueMines) {
						case 0 :
							buttonBoard[mfb.xCoo][mfb.yCoo].setBackground(Color.GREEN);
							break;
						case 1 :
							buttonBoard[mfb.xCoo][mfb.yCoo].setBackground(Color.YELLOW);
							break; 
						case 2 :
							buttonBoard[mfb.xCoo][mfb.yCoo].setBackground(Color.ORANGE);
							break; 
						case 3 :
							buttonBoard[mfb.xCoo][mfb.yCoo].setBackground(Color.RED);
							break;
						default : 
							System.out.println("Invalid!");
							break;
					}
				}
				if (mfb.xCoo != 0) {
					
					if(buttonBoard[mfb.xCoo - 1][mfb.yCoo].onSquare == true) {
					
						if(buttonBoard[mfb.xCoo][mfb.yCoo].typeButton != 2 /*&& buttonBoard[mfb.xCoo][mfb.yCoo].typeButton != 4*/ && buttonBoard[mfb.xCoo][mfb.yCoo].typeButton != 5) {
					
							buttonBoard[mfb.xCoo - 1][mfb.yCoo].onSquare = false;
							buttonBoard[mfb.xCoo][mfb.yCoo].onSquare = true;
							if (buttonBoard[mfb.xCoo][mfb.yCoo].clickedYet == false) {
								scoreBoard.totalScore = scoreBoard.totalScore - 10;
								scoreBoard.score.setText("Score: " + scoreBoard.totalScore);
							}
							switch(buttonBoard[mfb.xCoo][mfb.yCoo].valueMines) {
								case 0 :
									buttonBoard[mfb.xCoo][mfb.yCoo].setBackground(Color.GREEN);
									break;
								case 1 :
									buttonBoard[mfb.xCoo][mfb.yCoo].setBackground(Color.YELLOW);
									break; 
								case 2 :
									buttonBoard[mfb.xCoo][mfb.yCoo].setBackground(Color.ORANGE);
									break; 
								case 3 :
									buttonBoard[mfb.xCoo][mfb.yCoo].setBackground(Color.RED);
									break;
								default : 
									System.out.println("Invalid!");
									break;
							}
						}
						else if (buttonBoard[mfb.xCoo][mfb.yCoo].typeButton == 5 ) {
							JOptionPane.showMessageDialog(null, "Yay! You won. Press 'New Game' to play again.");
							gameRunning = false;
						}
						else if (buttonBoard[mfb.xCoo][mfb.yCoo].typeButton == 2 ) {
							buttonBoard[mfb.xCoo][mfb.yCoo].setBackground(Color.BLACK);
							if (buttonBoard[mfb.xCoo][mfb.yCoo].clickedYet == false) {
								scoreBoard.totalLives = scoreBoard.totalLives - 1;
								scoreBoard.totalScore = scoreBoard.totalScore - 100;
								scoreBoard.lives.setText("Lives: " + scoreBoard.totalLives);
								scoreBoard.score.setText("Score: " + scoreBoard.totalScore);
							}
						
							if (scoreBoard.totalLives == 0) {
								JOptionPane.showMessageDialog(null, "Whelp, you lost. Better luck next time!");
								gameRunning = false;
							
							}
						}
					}
				}
				if (mfb.xCoo != size - 1) {
					if(buttonBoard[mfb.xCoo + 1][mfb.yCoo].onSquare == true) {
						if(buttonBoard[mfb.xCoo][mfb.yCoo].typeButton != 2 /*&& buttonBoard[mfb.xCoo][mfb.yCoo].typeButton != 4*/ && buttonBoard[mfb.xCoo][mfb.yCoo].typeButton != 5) {
							buttonBoard[mfb.xCoo + 1][mfb.yCoo].onSquare = false;
							buttonBoard[mfb.xCoo][mfb.yCoo].onSquare = true;
							if (buttonBoard[mfb.xCoo][mfb.yCoo].clickedYet == false) {
								scoreBoard.totalScore = scoreBoard.totalScore - 10;
								scoreBoard.score.setText("Score: " + scoreBoard.totalScore);
							}
							switch(buttonBoard[mfb.xCoo][mfb.yCoo].valueMines) {
							case 0 :
								buttonBoard[mfb.xCoo][mfb.yCoo].setBackground(Color.GREEN);
								break;
							case 1 :
								buttonBoard[mfb.xCoo][mfb.yCoo].setBackground(Color.YELLOW);
								break; // optional
							case 2 :
								buttonBoard[mfb.xCoo][mfb.yCoo].setBackground(Color.ORANGE);
								break; // optional
							case 3 :
								buttonBoard[mfb.xCoo][mfb.yCoo].setBackground(Color.RED);
								break;
							default : // Optional
								System.out.println("Invalid!");
								break;
							}
						}
						else if (buttonBoard[mfb.xCoo][mfb.yCoo].typeButton == 5 ) {
							JOptionPane.showMessageDialog(null, "Yay! You won. Close to play again.");
							gameRunning = false;
						}
						else if (buttonBoard[mfb.xCoo][mfb.yCoo].typeButton == 2 ) {
							buttonBoard[mfb.xCoo][mfb.yCoo].setBackground(Color.BLACK);
							if (buttonBoard[mfb.xCoo][mfb.yCoo].clickedYet == false) {
								scoreBoard.totalLives = scoreBoard.totalLives - 1;
								scoreBoard.totalScore = scoreBoard.totalScore - 100;
								scoreBoard.lives.setText("Lives: " + scoreBoard.totalLives);
								scoreBoard.score.setText("Score: " + scoreBoard.totalScore);
							}
						
							if (scoreBoard.totalLives == 0) {
								JOptionPane.showMessageDialog(null, "Whelp, you lost. Better luck next time!");
								gameRunning = false;
							}
						}
					}
				}
				if (mfb.yCoo != 0) {
					if(buttonBoard[mfb.xCoo][mfb.yCoo - 1].onSquare == true) {
						if(buttonBoard[mfb.xCoo][mfb.yCoo].typeButton != 2 /*&& buttonBoard[mfb.xCoo][mfb.yCoo].typeButton != 4*/ && buttonBoard[mfb.xCoo][mfb.yCoo].typeButton != 5) {
							buttonBoard[mfb.xCoo][mfb.yCoo - 1].onSquare = false;
							buttonBoard[mfb.xCoo][mfb.yCoo].onSquare = true;
							if (buttonBoard[mfb.xCoo][mfb.yCoo].clickedYet == false) {
								scoreBoard.totalScore = scoreBoard.totalScore - 10;
								scoreBoard.score.setText("Score: " + scoreBoard.totalScore);
							}
							switch(buttonBoard[mfb.xCoo][mfb.yCoo].valueMines) {
							case 0 :
								buttonBoard[mfb.xCoo][mfb.yCoo].setBackground(Color.GREEN);
								break;
							case 1 :
								buttonBoard[mfb.xCoo][mfb.yCoo].setBackground(Color.YELLOW);
								break; // optional
							case 2 :
								buttonBoard[mfb.xCoo][mfb.yCoo].setBackground(Color.ORANGE);
								break; // optional
							case 3 :
								buttonBoard[mfb.xCoo][mfb.yCoo].setBackground(Color.RED);
								break;
							default : // Optional
								System.out.println("Invalid!");
								break;
							}
						}
						else if (buttonBoard[mfb.xCoo][mfb.yCoo].typeButton == 5 ) {
							JOptionPane.showMessageDialog(null, "Yay! You won. Press 'New Game' to play again.");
							gameRunning = false;
						}
						else if (buttonBoard[mfb.xCoo][mfb.yCoo].typeButton == 2 ) {
							buttonBoard[mfb.xCoo][mfb.yCoo].setBackground(Color.BLACK);
							if (buttonBoard[mfb.xCoo][mfb.yCoo].clickedYet == false) {
								scoreBoard.totalLives = scoreBoard.totalLives - 1;
								scoreBoard.totalScore = scoreBoard.totalScore - 100;
								scoreBoard.lives.setText("Lives: " + scoreBoard.totalLives);
								scoreBoard.score.setText("Score: " + scoreBoard.totalScore);
							}
							if (scoreBoard.totalLives == 0) {
								JOptionPane.showMessageDialog(null, "Whelp, you lost. Better luck next time!");
								gameRunning = false;
							}
						}
					}
				}
				if (mfb.yCoo != size - 1) {
					if(buttonBoard[mfb.xCoo][mfb.yCoo + 1].onSquare == true) {
						if(buttonBoard[mfb.xCoo][mfb.yCoo].typeButton != 2 /*&& buttonBoard[mfb.xCoo][mfb.yCoo].typeButton != 4*/ && buttonBoard[mfb.xCoo][mfb.yCoo].typeButton != 5) {
							buttonBoard[mfb.xCoo][mfb.yCoo + 1].onSquare = false;
							buttonBoard[mfb.xCoo][mfb.yCoo].onSquare = true;
							if (buttonBoard[mfb.xCoo][mfb.yCoo].clickedYet == false) {
								scoreBoard.totalScore = scoreBoard.totalScore - 10;
								scoreBoard.score.setText("Score: " + scoreBoard.totalScore);
							}
							switch(buttonBoard[mfb.xCoo][mfb.yCoo].valueMines) {
							case 0 :
								buttonBoard[mfb.xCoo][mfb.yCoo].setBackground(Color.GREEN);
								break;
							case 1 :
								buttonBoard[mfb.xCoo][mfb.yCoo].setBackground(Color.YELLOW);
								break; // optional
							case 2 :
								buttonBoard[mfb.xCoo][mfb.yCoo].setBackground(Color.ORANGE);
								break; // optional
							case 3 :
								buttonBoard[mfb.xCoo][mfb.yCoo].setBackground(Color.RED);
								break;
							default : // Optional
								System.out.println("Invalid!");
								break;
							}
						}
						else if (buttonBoard[mfb.xCoo][mfb.yCoo].typeButton == 5 ) {
							JOptionPane.showMessageDialog(null, "Yay! You won. Press 'New Game' to play again.");
							gameRunning = false;
						}
						else if (buttonBoard[mfb.xCoo][mfb.yCoo].typeButton == 2 ) {
							buttonBoard[mfb.xCoo][mfb.yCoo].setBackground(Color.BLACK);
							if (buttonBoard[mfb.xCoo][mfb.yCoo].clickedYet == false) {
								scoreBoard.totalLives = scoreBoard.totalLives - 1;
								scoreBoard.totalScore = scoreBoard.totalScore - 100;
								scoreBoard.lives.setText("Lives: " + scoreBoard.totalLives);
								scoreBoard.score.setText("Score: " + scoreBoard.totalScore);
							}
							if (scoreBoard.totalLives == 0) {
								JOptionPane.showMessageDialog(null, "Whelp, you lost. Better luck next time!");
								gameRunning = false;
							}
						}
					}
				}
			}
			buttonBoard[mfb.xCoo][mfb.yCoo].clickedYet = true;
		}
	}
}