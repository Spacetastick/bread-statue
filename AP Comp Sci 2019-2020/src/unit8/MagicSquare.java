package unit8;

import java.util.Scanner;

public class MagicSquare {
	
	private static int[][] square = new int[4][4];
	
	private static boolean checkRows() {
		int rowSum = 0;
		int lastSum = 0;
		
		for (int row = 0; row < 4; row++) {
			for (int column = 0; column < 4; column++) {
				rowSum += square[row][column];
			}
			System.out.println("Sum of row " + row + " is: " + rowSum);
			if (row == 0) {
				lastSum = rowSum;
			}
			if (row != 0 && lastSum != rowSum) {
				return false;
			} else {
				rowSum = 0;
			}
		}
		return true;
	}
	
	private static boolean checkColumns() {
		int columnSum = 0;
		int lastSum = 0;
		
		for (int column = 0; column < 4; column++) {
			for (int row = 0; row < 4; row++) {
				columnSum += square[row][column];
			}
			System.out.println("Sum of column " + column + " is: " + columnSum);
			if (column == 0) {
				lastSum = columnSum;
			}
			if (column != 0 && lastSum != columnSum) {
				return false;
			} else {
				columnSum = 0;
			}
		}
		return true;
	}
	
	private static boolean checkDiagonals() {
		int diagonalSum1 = (square[0][0] + square[3][3]);
		int diagonalSum2 = (square[3][0] + square[0][3]);

		System.out.println("Sum of top left and bottom right diagonals is: " + diagonalSum1);
		System.out.println("SUm of bottom left and top right diagonals is: " + diagonalSum2);
		
		if (diagonalSum1 != diagonalSum2) {
			return false;
		}
		else {

			return true;
		}
	}
	
	private static void checkSquare() {
		boolean sumRows = checkRows();
		boolean sumColumns = checkColumns();
		boolean sumDiagonals = checkDiagonals();
		
		if (sumRows && sumColumns && sumDiagonals) {
			System.out.println("Your square is a Magic Square!");
		} else {
			System.out.println("Your sqare is not Magic.");
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to Magic Square!");
		System.out.println("Please enter the 16 values that will make up your square: ");
		
		for (int row = 0; row < 4; row++) {
			for (int column = 0; column < 4; column++) {
				square[row][column] = input.nextInt();
			}
		}
		
		input.close();
		
		System.out.println("This is your square: ");
		
		for (int row = 0; row < 4; row++) {
			for (int column = 0; column < 4; column++) {
				if (square[row][column] > 9) {
					System.out.print(square[row][column] + " ");
				} else {
					System.out.print(square[row][column] + "  ");
				}
				
			}
			System.out.println();
		}
		
		System.out.println("Checking if square is Magic. . .");
		
		checkSquare();
	}
	
}
