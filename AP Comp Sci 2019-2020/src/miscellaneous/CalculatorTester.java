package miscellaneous;

import java.util.Scanner;

public class CalculatorTester {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("How many numbers are you adding?");
		int totalNumbers = input.nextInt();
		int sum = 0;
		
		while (totalNumbers > 0) {
			System.out.println("Enter a number to add:");
			sum += input.nextInt();
			totalNumbers--;
		}
		input.close();
		System.out.println(sum);
		
	}

}
