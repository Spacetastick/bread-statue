//Noah Cil, 10/23/19, Conversion calculator for imperial units to metric units

package unitConversion;

import java.util.Scanner;

public class UnitConversionTester {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("(fl. oz, gal, oz, lb, in, ft, mi)\nWhat unit do you want to convert from?");
		String unitFrom = keyboard.nextLine();
		System.out.println("(ml, l, g, kg, mm, cm, m, km)\nWhat unit do you want to convert to?");
		String unitTo = keyboard.nextLine();
		if (!(UnitConversion.validUnits(unitFrom, unitTo))) {
			System.out.println("These are not valid units!");
		}
		else if (!(UnitConversion.validConversion(unitFrom, unitTo))) {
			System.out.println("This is not a valid conversion!");
		}
		else {
			System.out.println("What is the amount of " + unitFrom + "?");
			if (!(keyboard.hasNextDouble())) {
				System.out.println("This is not a valid number!");
			}
			else {
				double fromAmount = keyboard.nextDouble();
				double toAmount;
				keyboard.close();
				
				if (UnitConversion.validUnits(unitFrom, unitTo)) {
					toAmount = UnitConversion.convert(unitFrom, unitTo, fromAmount);
					System.out.println(fromAmount + " " + unitFrom + " = " + toAmount + " " + unitTo);
				}
				else {
					System.out.println("Error!");
				}
			}
		}
	}

}