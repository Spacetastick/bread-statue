package chapter6;

import java.util.Scanner;

public class Exercise06_23 {
	
	public static int count(String str, char a) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == a)
				count++;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String str = input.nextLine();
		System.out.println("Enter a character: ");
		char a = input.next().charAt(0);
		System.out.println("The number of occurrences of " + a + " in " + str + " is " + count(str, a));
	}
	
}
