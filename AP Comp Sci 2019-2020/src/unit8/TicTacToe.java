package unit8;

import java.util.Scanner;

public class TicTacToe {

	private static String[][] board = new String[3][3];
	
	private static void resetBoard() {
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 3; column++) {
				board[row][column] = "-";
			}
		}
	}
	
	private static void printBoard() {
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 3; column++) {
				System.out.print(board[row][column] + " ");
			}
			System.out.println();
		}
	}
	
	private static void gameLoop() {
		Scanner input = new Scanner(System.in);
		boolean gameOver = false;
		int row;
		int column;
		int count = 0;
		
		while (!gameOver) {
			boolean player1Turn = true;
			boolean player2Turn = false;
			
			while (player1Turn) {
				if (!gameOver) {
					System.out.println("Player 1, input index row and column");
					row = input.nextInt();
					column = input.nextInt();
					if (row > 2 || column > 2) {
						System.out.println("This is not a valid position!");
					} else if (board[row][column] == "-") {
						board[row][column] = "O";
						count++;
						printBoard();
						player1Turn = false;
						player2Turn = true;
					} else {
						System.out.println("This is not a valid position!");
					}
					
					if (count >= 5 && count < 9) {
						if (checkWin(true)) {
							System.out.println("Player 1 has won!");
							gameOver = true;
						}
					} else if (count >= 9){
						System.out.println("The game is a tie!");
						gameOver = true;
					}
				}
			}
			
			while (player2Turn) {
				if (!gameOver) {
					System.out.println("Player 2, input index row and column");
					row = input.nextInt();
					column = input.nextInt();
					if (row > 2 || column > 2) {
						System.out.println("This is not a valid position!");
					} else if (board[row][column] == "-") {
						board[row][column] = "X";
						count++;
						printBoard();
						player1Turn = true;
						player2Turn = false;
					} else {
						System.out.println("This is not a valid position!");
					}
					
					if (count >= 5 && count < 9) { 
						if (checkWin(false)) {
							System.out.println("Player 2 has won!");
							gameOver = true;
						}
					} else if (count >= 9){
						System.out.println("The game is a tie!");
						gameOver = true;
					}
				}
			}
			
		}
		input.close();
	}
	
	private static boolean checkWin(boolean player1) {
		//make more efficient so its not brute forced like this and maybe make play again
		if (player1) {
			if (board[0][0] == "O" && board[0][1] == "O" && board[0][2] == "O") {
				return true;
			} else if (board[1][0] == "O" && board[1][1] == "O" && board[1][2] == "O") {
				return true;
			} else if (board[2][0] == "O" && board[2][1] == "O" && board[2][2] == "O") {
				return true;
			} else if (board[0][0] == "O" && board[1][0] == "O" && board[2][0] == "O") {
				return true;
			} else if (board[0][1] == "O" && board[1][1] == "O" && board[2][1] == "O") {
				return true;
			} else if (board[0][2] == "O" && board[1][2] == "O" && board[2][2] == "O") {
				return true;
			} else if (board[0][0] == "O" && board[1][1] == "O" && board[2][2] == "O") {
				return true;
			} else if (board[0][2] == "O" && board[1][1] == "O" && board[2][0] == "O") {
				return true;
			} else {
				return false;
			}
		}
		else {
			if (board[0][0] == "X" && board[0][1] == "X" && board[0][2] == "X") {
				return true;
			} else if (board[1][0] == "X" && board[1][1] == "X" && board[1][2] == "X") {
				return true;
			} else if (board[2][0] == "X" && board[2][1] == "X" && board[2][2] == "X") {
				return true;
			} else if (board[0][0] == "X" && board[1][0] == "X" && board[2][0] == "X") {
				return true;
			} else if (board[0][1] == "X" && board[1][1] == "X" && board[2][1] == "X") {
				return true;
			} else if (board[0][2] == "X" && board[1][2] == "X" && board[2][2] == "X") {
				return true;
			} else if (board[0][0] == "X" && board[1][1] == "X" && board[2][2] == "X") {
				return true;
			} else if (board[0][2] == "X" && board[1][1] == "X" && board[2][0] == "X") {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to Tic-Tac-Toe!");
		System.out.println("Player 1 is O's, Player 2 is X's");
		resetBoard();
		printBoard();
		gameLoop();
	}
	
}
