package chapter8;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise08_13 {

	public static int[] locateLargest(double[][] a) {
		double largest = -Double.MAX_VALUE;
		int largestRow = 0;
		int largestColumn = 0;
		
		for (int row = 0; row < a.length; row++) {
			for (int column = 0; column < a[row].length; column++) {
				if (a[row][column] > largest) {
					largest = a[row][column];
					largestRow = row;
					largestColumn = column;
				}
			}
		}
		
		return new int[] {largestRow, largestColumn};
		
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number of rows and columns of the array: ");
		double[][] arr = new double[input.nextInt()][input.nextInt()];
		System.out.println("Enter the array: ");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = input.nextDouble();
			}
		}
		
		System.out.println("The location of the largest element is at " + Arrays.toString(locateLargest(arr)));

	}

}
