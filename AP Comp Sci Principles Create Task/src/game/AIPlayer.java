package game;

//This class contains the code for the AI Player, which plays random valid moves
public class AIPlayer {

	//variables for this code file
	private int row, column;
	private TicTacToe game;
	
	//initializes a new AI player for the current game
	public AIPlayer(TicTacToe game) {
		this.game = game;
	}
	
	//returns the value of row
	public int getRow() {
		return row;
	}
	
	//returns the value of column
	public int getColumn() {
		return column;
	}
	
	//This function finds a random empty spot to play, and assigns the coordinates for that spot to row and column
	public void findSpot() {
		row = (int)(Math.random() * 3);
		column = (int)(Math.random() * 3);
		while (!game.board[row][column].equals("-")) {
			row = (int)(Math.random() * 3);
			column = (int)(Math.random() * 3);
		}
	}
	
	//This function takes the spot that the findSpot() function found and plays on it.
	public void takeTurn() {
		game.board[row][column] = "O";
		game.addTurn();
	}
	
}