package unitConversion;

import java.util.Scanner;

public class UnitConversionTester {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("(fl. oz, gal, lb, in, ft, mi)\nWhat unit do you want to convert from?");
		String unitFrom = input.nextLine();
		System.out.println("(ml, l, g, kg, mm, cm, m, km)\nWhat unit do you want to convert to?");
		String unitTo = input.nextLine();
		System.out.println("What is the amount of " + unitFrom + "?");
		double fromAmount = input.nextDouble();
		double toAmount;
		
		//if (UnitConversion.validConversion(unitFrom, unitTo)) {
		//	UnitConversion.convert(fromAmount);
		//}
		
		//System.out.println(fromAmount + " " + unitFrom + " = " + toAmount + " " + unitTo);
	}

}