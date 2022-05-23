package chapter13;

import java.util.Scanner;

public class Exercise13_19 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Enter a decimal number: ");
		String[] inputs = console.next().split("\\.");
		console.close();
		

		
		Rational intFrac = new Rational(Integer.parseInt(inputs[0]), 1);
		Rational decFrac = new Rational(Integer.parseInt(inputs[1]), (int)Math.pow(10, inputs[1].length()));
		
		System.out.print("The fraction number is " + inputs[0].charAt(0) == "-" ? 
				intFrac.subtract(decFrac) : intFrac.add(decFrac));
	
	}
	
}
