package chapter12;

import java.util.Scanner;

public class Exercise12_07 {

	public static void bin2Dec(String binaryString) throws NumberFormatException {
		System.out.print(Integer.parseInt(binaryString, 2));
	}
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		System.out.print("Enter a binary number: ");
		String input = console.nextLine();
		console.close();
		
		try {
			bin2Dec(input);
		}
		catch(NumberFormatException e) {
			System.out.print("Not a binary number: " + input);
		}
	}
	
}
