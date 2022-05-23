package chapter9;

import java.util.Scanner;

public class Exercise09_13 {

	 static class Location {
		 //I have no idea why it wants me to make these public it makes no sense
		 public static int row, column;
		 public static double maxValue;
		 
		 public static Location locateLargest(double[][] a) {
			 row = 0;
			 column = 1;
			 maxValue = a[0][0];
			
			 for (int i = 0; i < a.length; i++) {
				 for (int j = 0; j < a[i].length; j++) {
					 if (a[i][j] > maxValue) {
						 maxValue = a[i][j];
						 row = i;
						 column = j;
					 }
				 }
			 }
			 //bruh why do i do this if the data fields are public bruh
			 return new Location();
		 }
	 }
		 
			 
			 
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number of rows and columns in the array: ");
		double[][] array = new double[input.nextInt()][input.nextInt()];
		System.out.println("Enter the array:");
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = input.nextDouble();
			}
		}
		
		//bruh
		//Location max = Location.locateLargest(array);
		Location.locateLargest(array);
		System.out.println("The largest element is " + Location.maxValue + ", located at " + "(" + Location.row + ", " + Location.column + ")");
	}
	
}
