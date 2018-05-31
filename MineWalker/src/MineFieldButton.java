import javax.swing.JButton;

public class MineFieldButton extends JButton{
	// 0 - unset, 1 - normal ,2 - bomb, 3 - path except for start and finish, 4 - start, 5 - finish
	int typeButton;
	// the value is based on how many mines surround it. Mine, start, and end values are never shown.
	int valueMines;
	// if on square is true, is is the current square.
	boolean onSquare;
	
	int xCoo;
	
	int yCoo;
	
	boolean clickedYet;
	
}
