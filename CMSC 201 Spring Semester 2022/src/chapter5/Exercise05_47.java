package chapter5;

import java.util.Scanner;

public class Exercise05_47 {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Enter the first 12 digits of an ISBN-13 as a string: ");
		String numbers = input.nextLine();
		int[] numbersArray = new int[12];
		
		if (numbers.length() < 12) {
			System.out.println(numbers + " is an invalid input");
			return;
		}
		else {
			for (int i = 0; i < 12; i++) {
				numbersArray[i] = Integer.parseInt(String.valueOf(numbers.charAt(i)));
			}
			
			int checksum = 10 - (numbersArray[0] + (3 * numbersArray[1]) + numbersArray[2] + (numbersArray[3] * 3) + numbersArray[4] + 
					(3 * numbersArray[5]) + numbersArray[6] + (3 * numbersArray[7]) + numbersArray[8] + 
					(3 * numbersArray[9]) + numbersArray[10] + (3 * numbersArray[11])) % 10;
			
			if (checksum == 10)
				checksum = 0;
			numbers += checksum;
			
			System.out.println("The ISBN-13 number is " + numbers);
			
		}
		
		
	}
	
}
