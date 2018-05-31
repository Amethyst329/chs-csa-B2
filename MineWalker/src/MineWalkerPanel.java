import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MineWalkerPanel extends JPanel{
	public MineWalkerPanel() {
		
	}
}
class scoreBoard extends JPanel{
	public static int totalLives;
	public static int totalScore;
	public static JLabel lives;
	public static JLabel score;
	public scoreBoard() {
		super(new GridBagLayout());
		GridBagConstraints grid = new GridBagConstraints();
		grid.gridx = 0;
		grid.gridy = 0;
		totalLives = 5;
		lives = new JLabel("Lives: " + totalLives);
		super.add(lives, grid);

		grid.gridy = 1;
		totalScore = 1000;
		score = new JLabel("Score: " + totalScore);
		super.add(score, grid);
	}
}

class colorBoard extends JPanel{
	public colorBoard() {
		super(new GridBagLayout());
	/*	String [] colorTable = new String[8];
		colorTable[0] = "0 Nearby Mines";
		colorTable[1] = "1 Nearby Mine";
		colorTable[2] = "2 Nearby Mines";
		colorTable[3] = "3 Nearby Mines";
		colorTable[4] = "Exploded Mines";
		
		colorTable[6] = "Start";
		colorTable[7] = "Destination";

		for (int i=0; i<7; i++) {
			JLabel colorBox = new JLabel(colorTable[i]);
			super.add(colorBox, BorderLayout.CENTER);
		}*/
		GridBagConstraints grid = new GridBagConstraints();
		JLabel [] colors = new JLabel[8];
		grid.gridx = 0;
		for(int i=0; i<8; i++) {
			colors[i] = new JLabel("");
			colors[i].setOpaque(true);
			colors[i].setPreferredSize(new Dimension(120,70));
			grid.gridy = i;
			super.add(colors[i], grid);
		}
		colors[0].setText("0 Nearby Mines");
		colors[0].setBackground(Color.GREEN);
		colors[1].setText("1 Nearby Mine");
		colors[1].setBackground(Color.YELLOW);
		colors[2].setText("2 Nearby Mines");
		colors[2].setBackground(Color.ORANGE);
		colors[3].setText("3 Nearby Mines");
		colors[3].setBackground(Color.RED);
		colors[4].setText("Exploded Mine");
		colors[4].setBackground(Color.BLACK);
		colors[4].setForeground(Color.WHITE);
		colors[5].setText("");
		colors[6].setText("Start");
		colors[6].setBackground(Color.CYAN);
		colors[7].setText("Destination");
		colors[7].setBackground(Color.MAGENTA);
		
	}
}

class buttonBoard extends JPanel{
	JTextField enterSquare;
	fieldBoard fB;
	static JButton showPath = new JButton("Show Path");
	static JButton newGame = new JButton("Reset game");
	static JButton showMines = new JButton("Show Mines");
	public buttonBoard() {
		super(new GridBagLayout());
		EnterListener listener = new EnterListener();
		GridBagConstraints grid = new GridBagConstraints();
		grid.gridx = 0;
		grid.gridy = 0;

		showMines.addActionListener(new showMinesListener());
		super.add(showMines, grid);
		
		grid.gridx = 1;
		showPath.addActionListener(new showPathListener());
		super.add(showPath, grid);
		
		grid.gridx = 2;
		newGame.addActionListener(new newGameListener());
		super.add(newGame, grid);
		
		grid.gridx = 3;
		enterSquare = new JTextField("10");
		enterSquare.addActionListener(listener);
		enterSquare.setPreferredSize(new Dimension(50, 30));
		super.add(enterSquare, grid);
		
	}
	class newGameListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JOptionPane.showMessageDialog(null, "A New game has been generated.");
			fB.refresh(Integer.toString(fB.size));
		}
	}
	class EnterListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			boolean passFail = false;
			try {
				Integer.parseInt(enterSquare.getText());
				passFail = true;
			}catch(java.lang.NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, enterSquare.getText() + " is invalid. Please enter a size of 5 or more.");
			}
			if (passFail == true) {
				if (Integer.parseInt(enterSquare.getText()) > 1) {
				
					fB.refresh(enterSquare.getText());
					JOptionPane.showMessageDialog(null, "New game has been made! Press the blue square to start.");
				}
				else {
					JOptionPane.showMessageDialog(null, enterSquare.getText() + " is invalid. Please enter a size of 5 or more.");
				}
			}
		}
	}
	class showPathListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			boolean getOrSet = false;
			if (buttonBoard.showPath.getText() == "Show Path") {
				buttonBoard.showPath.setText("Hide Path");
			}
			else {
				buttonBoard.showPath.setText("Show Path");
			}
			for (int i=0; i<fB.size; i++) {
				for (int j=0; j<fB.size; j++) {
					System.out.println(fB.buttonBoard[i][j].getBackground());
					System.out.println(Color.WHITE + "white");

					if(fB.buttonBoard[i][j].getBackground() != Color.BLUE) {
						System.out.println("I got run");
						if (getOrSet == false) {
							getOrSet = true;
						}
						if (fB.buttonBoard[i][j].typeButton == 3 || fB.buttonBoard[i][j].typeButton == 4 || fB.buttonBoard[i][j].typeButton == 5) {
							System.out.println(1010);
							fB.buttonBoard[i][j].setBackground(Color.BLUE);
						}
					}
					else {
						if (getOrSet == false) {
							getOrSet = true;
							
						}
						if (fB.buttonBoard[i][j].typeButton == 3) {
							System.out.println(1010);
							if (fB.buttonBoard[i][j].clickedYet == true) {
								switch(fB.buttonBoard[i][j].valueMines) {
									case 0 :
										fB.buttonBoard[i][j].setBackground(Color.GREEN);
										break;
									case 1 :
										fB.buttonBoard[i][j].setBackground(Color.YELLOW);
										break; // optional
									case 2 :
										fB.buttonBoard[i][j].setBackground(Color.ORANGE);
										break; // optional
									case 3 :
										fB.buttonBoard[i][j].setBackground(Color.RED);
										break;
									default : // Optional
										System.out.println("Invalid!");
										break;
								}
							}
							else {
								fB.buttonBoard[i][j].setBackground(Color.WHITE);
							}
						}
						if (fB.buttonBoard[i][j].typeButton == 4) {
							System.out.println(1010);
							fB.buttonBoard[i][j].setBackground(Color.CYAN);
						}
						if (fB.buttonBoard[i][j].typeButton == 5) {
							System.out.println(1010);
							fB.buttonBoard[i][j].setBackground(Color.MAGENTA);
						}
					}
				}
			}
			
			
		}
	}
	class showMinesListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			boolean getOrSet = false;
			if (buttonBoard.showMines.getText() == "Show Mines") {
				buttonBoard.showMines.setText("Hide Mines");
			}
			else {
				buttonBoard.showMines.setText("Show Mines");
			}
			for (int i=0; i<fB.size; i++) {
				for (int j=0; j<fB.size; j++) {
					if(fB.buttonBoard[i][j].getBackground() == Color.WHITE) {
						System.out.println("I got run");
						if (getOrSet == false) {
							getOrSet = true;
						}
						if (fB.buttonBoard[i][j].typeButton == 2) {
							System.out.println(1010);
							fB.buttonBoard[i][j].setBackground(Color.BLACK);
						}
					}
					else {
						if (getOrSet == false) {
							getOrSet = true;
							
						}
						if (fB.buttonBoard[i][j].typeButton == 2) {
							if (fB.buttonBoard[i][j].clickedYet == false) {
								fB.buttonBoard[i][j].setBackground(Color.WHITE);
							}
						}
					}
				}
			}
		}
	}
	public void variables(fieldBoard variable) {
		fB = variable;
	}
}