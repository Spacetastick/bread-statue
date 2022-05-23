package chapter8;

import java.util.Scanner;

public class Exercise08_01 {

	public static double sumColumn(double[][] m, int columnIndex) {
		double sum = 0;
		for (double[] row : m) {
			sum += row[columnIndex];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a 3-by-4 matrix row by row: ");
		
		double[][] arr = new double[3][4];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++)
				arr[i][j] = input.nextDouble();
		}
		
		for (int i = 0; i < 4; i++) {
			System.out.println("Sum of the elements at column " + i + " is " + sumColumn(arr, i));
		}

	}

}
