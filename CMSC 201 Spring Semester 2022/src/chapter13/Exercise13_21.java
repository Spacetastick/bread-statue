package chapter13;

import java.util.Scanner;

public class Exercise13_21 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Enter a, b, c: ");
		int a = console.nextInt();
		int b = console.nextInt();
		int c = console.nextInt();
		console.close();
		
		Rational h = new Rational(b * -1, a * 2);
		double k = a * Math.pow(h.doubleValue(), 2) + b * h.doubleValue() + c;
		
		String[] parts = Double.toString(k).split("\\.");
		Rational kFrac1 = new Rational(Integer.parseInt(parts[0]), 1);
		Rational kFrac2 = new Rational(Integer.parseInt(parts[1]), (int)Math.pow(10, parts[1].length()));
		
		
		System.out.print("h is " + h + " k is ");
		System.out.print(parts[0].charAt(0) == '-' ? kFrac1.subtract(kFrac2) : kFrac1.add(kFrac2));
	}
	
}
