package chapter6;

import java.util.Scanner;

public class Exercise06_37 {

	public static String format(int number, int width) {
		int numLength = String.valueOf(number).length();
		if (numLength >= width)
			return ((Integer)number).toString();
		
		String output = "";
		for (int i = 0; i < width-numLength; i++)
			output += "0";
		return output + number;
		
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter an Integer: ");
		int num = input.nextInt();
		System.out.print("Enter the width: ");
		int width = input.nextInt();
		System.out.println("The formatted number is " + format(num, width));
	}
	
}
