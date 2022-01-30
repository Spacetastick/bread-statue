package play;

import java.util.Scanner;
import game.AIPlayer;
import game.TicTacToe;

//This class uses the functions in the other two classes to play the game
public class Play {
	
	public static void playGame(String gameMode, TicTacToe game, Scanner input, AIPlayer bot) {
		while (!game.checkWin()) {
			//player code
			if (gameMode.equals("2") || game.getTurn() % 2 == 0) {
				System.out.println("Where would you like to place an " + game.getPlayer() + "? Input the row and column: row column.");
				game.getInput(input.next(), input.next());
				while (!game.checkInput()) {
					System.out.println("That is not a valid input, please try again: ");
					game.getInput(input.next(), input.next());
				}
				
				if (game.getPlayer().equals("X"))
					System.out.print("Player 1 is placing an X ");
				else
					System.out.print("Player 2 is placing an O ");
				System.out.println("at row " + game.getRow() + ", column " + game.getColumn());
				game.takeTurn();
			}
			//AI player code
			else {
				bot.findSpot();
				System.out.println("Bot is placing an O at row " + bot.getRow() + ", column " + bot.getColumn());
				bot.takeTurn();
			}
			game.printBoard();
		}
	}
	
	public static void main(String[] args) {
		//variables needed to play the game
		//scanner for player input
		Scanner input = new Scanner(System.in);
		//new board initialized
		TicTacToe game = new TicTacToe();
		//new AI player initialized on the board
		AIPlayer bot = new AIPlayer(game);
		//variable that holds player input for the game mode
		String playerGame;
		
		System.out.println("Welcome to Tic-Tac-Toe!");
		
		//This code takes player input to determine whether to play a game with an AI player, or have two players take turns
		System.out.println("Would you like to play a one (1) player or two (2) player game? Enter 1 or 2");
		playerGame = input.next();
		while (!playerGame.matches("1|2")) {
			System.out.println("That is not a valid input, please try again: ");
			playerGame = input.next();
		}
		
		if (playerGame.equals("1"))
			System.out.println("Playing with an AI player. . .");
		else
			System.out.println("Playing with two players. . .");
		
		//These three commands play the  whole game
		game.printBoard();
		playGame(playerGame, game, input, bot);
		input.close();
	}
}