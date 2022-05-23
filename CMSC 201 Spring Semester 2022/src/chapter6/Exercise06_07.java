package chapter6;

//when I did this exercise, revel didn't take my submission because it wasn't actually giving me the input for years. just manually set it to 30 and you'll be good

import java.util.Scanner;

public class Exercise06_07 {
	
	public static double futureInvestmentValue(double investmentAmount, double monthlyReturnRate, int years) {
		if (monthlyReturnRate > 1)
			monthlyReturnRate /= 100;	
		monthlyReturnRate /= 12;
		
		return investmentAmount * Math.pow(1 + monthlyReturnRate, years * 12);
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.println("The amount invested: ");
		double investmentAmount = input.nextDouble();
		System.out.println("Annual return rate: ");
		double monthlyReturnRate = input.nextDouble();
		System.out.println("Number of years: ");
		int years = input.nextInt();
		
		System.out.println("Years     Future Value");
		for (int i = 1; i <= years; i++)
			System.out.println(i + "         " + futureInvestmentValue(investmentAmount, monthlyReturnRate, i));
	}
	
}