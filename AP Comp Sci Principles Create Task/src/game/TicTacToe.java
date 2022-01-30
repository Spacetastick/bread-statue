package game;

//This class contains the code that draws and manages the game board, as well as checking for wins and playing turns.
public class TicTacToe {

	//Here are all my variables for this file:
	protected String[][] board = new String[3][3];
	//I used a 2D array for the list requirement ^,
	//This 2D array holds all of the values for the 3x3 game board (blank areas, X's and O's)
	private int turn, row, column;
	private String rowString, columnString;
	
	//This creates a TicTacToe object which fills the board 2D array with dashes to indicate blank spaces, and sets turn to 0
	public TicTacToe() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				board[i][j] = "-";
		}
		turn = 0;
	}
	
	//This function prints the board 2D array to the console in a way that displays it as a 3x3 grid,
	//and also adds numbers to the top and left side for the rows and columns 
	public void printBoard() {
		System.out.println("  0 1 2");
		for (int i = 0; i < 3; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < 3; j++)
				System.out.print(board[i][j] + " ");
			System.out.println();
		}
	}
	
	//This function returns the current value of row
	public int getRow() {
		return row;
	}
	
	//This function returns the current value of column
	public int getColumn() {
		return column;
	}
	
	//This function returns the current value of turn
	public int getTurn() {
		return turn;
	}
	
	//This function determines which player is currently playing (either X's or O's) depending on the value of turn,
	//and returns the appropriate letter
	public String getPlayer() {
		if (turn % 2 == 0)
			return "X";
		else
			return "O";
	}
	
	//This function takes the row and column inputs from the player and assigns those values to rowString and columnString, respectively 
	public void getInput(String row, String column) {
		rowString = row;
		columnString = column;
	}
	
	//This function makes sure that the player's row and column inputs are a valid move, returning true if the
	//space they selected is empty, and false otherwise.
	public boolean checkInput() {
		if (rowString.matches("0|1|2") && columnString.matches("0|1|2")) {
			row = Integer.parseInt(rowString);
			column = Integer.parseInt(columnString);
			if (board[row][column].equals("-"))
				return true;
		}
		return false;
	}
	
	//This function assigns a letter value to a spot on the board (2D array), and adds one to turn
	public void takeTurn() {
		board[row][column] = this.getPlayer();
		turn++;
	}
	
	//adds a turn
	public void addTurn() {
		turn++;
	}
	
	//This functions checks if there is a win in a row (3 in a row)
	public boolean winRow() {
		for (int row = 0; row < 3; row++) {
			if (!board[row][0].equals("-") && (board[row][0].equals(board[row][1]) && board[row][1].equals(board[row][2])))
				return true;
		}
		return false;
	}
	
	//This function checks if there is a win in a column (3 in a column)
	public boolean winColumn() {
		for (int column = 0; column < 3; column++) {
			if (!board[0][column].equals("-") && (board[0][column].equals(board[1][column]) && board[1][column].equals(board[2][column])))
				return true;
		}
		return false;
	}
	
	//This function checks if there is a win on either of the two diagonals
	public boolean winDiagonal() {
		if (!board[0][0].equals("-") && (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])))
			return true;
		else if (!board[0][2].equals("-") && (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])))
			return true;
		return false;
	}
	
	//This function checks to see if there is a win, or if the game has tied, and returns true or false accordingly (as well as a prompt)
	public boolean checkWin() {
		if (turn > 3) {
			if (winRow() || winColumn() || winDiagonal()) {
				turn--;
				System.out.println(this.getPlayer() + "'s win!");
				return true;
			}
			else if (turn > 8) {
				System.out.println("The game is a tie!");
				return true;
			}
		}
		return false;
	}
}