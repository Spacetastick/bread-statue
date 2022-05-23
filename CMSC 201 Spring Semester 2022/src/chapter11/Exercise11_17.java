package chapter11;

import java.util.Scanner;

public class Exercise11_17 {

	private static int m;
	private static int n = 1;
	
	public static void perfectSquare() {
		boolean foundPerfectSquare = false;
		
		while (!foundPerfectSquare) {
			if (Math.sqrt(m * n) % 1 == 0)
				foundPerfectSquare = true;
			else
				n++;
		}
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter an integer m: ");
		m = input.nextInt();
		
		perfectSquare();
		System.out.println("The smallest number n for m * n to be a perfect square is " + n);
		System.out.println("m  * n is " + m * n);
	}
	
}
