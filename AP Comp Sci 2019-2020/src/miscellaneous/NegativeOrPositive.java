//Write a program that reads an integer and prints whether it is negative, zero, or positive
//Noah Cil, period 1, 10/11/19, to determine if an integer is negative, zero, or positive.
package miscellaneous;
import java.util.Scanner;

public class NegativeOrPositive {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter an integer:");
		int integer = keyboard.nextInt();
		keyboard.close();
		
		if (integer > 0)
			System.out.println("The integer is positive");
		else if (integer < 0)
			System.out.println("The integer is negative");
		else
			System.out.println("The integer is zero");
	}
}
