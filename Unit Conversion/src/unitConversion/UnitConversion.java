package unitConversion;

public class UnitConversion {

	private static String unitFrom;
	private static String unitTo;
	private static double fromAmount;
	
	//code below is wrong, write a class that checks if inputted units are valid, and then a class that compares the units to see if its a valid conversion. then write conversion class
	
	public static boolean validConversion(String from, String to) {
		unitFrom = from;
		unitTo = to;
		
		if ((unitFrom.equals("fl. oz") || unitFrom.equals("gal")) && (!(unitTo.equals("gal")) || !(unitTo.equals("fl. oz")))) {
			return false;
		} 
		else if ((unitFrom.equals("oz") || unitFrom.equals("lb")) && (!(unitTo.equals("oz")) || !(unitTo.equals("lb")))) {
			return false;
		}
		else if ((unitFrom.equals("in") || unitFrom.equals("ft") || unitFrom.equals("mi")) && (!(unitTo.equals("in")) || !(unitTo.equals("ft")) || !(unitTo.equals("mi")))) {
			return false;
		}
		else {
			return true;
		}
		
	}
	
	public static double convert(double amount) {
		fromAmount = amount;
		
		if (unitFrom.equals("fl. oz")) {
			if (unitTo.equals("fl. oz")) {
				return amount;
			}
			else {
				return amount/128; //1 fluid ounce is 1/128 gallons
			}
		}
		
		if (unitFrom.equals("gal")) {
			if (unitTo.equals("gal")) {
				return amount;
			}
			else {
				return amount * 128;
			}
		}
		
		if (unitFrom.equals("oz")) {
			if (unitTo.equals("oz")) {
				return amount;
			}
			else {
				return amount/16; //16 ounces in one pound
			}
		}
		
		if (unitFrom.equals("lb")) {
			if (unitTo.equals("lb")) {
				return amount;
			}
			else {
				return amount * 16;
			}
		}
		
		if (unitFrom.equals("in")) {
			if (unitTo.equals("in")) {
				return amount;
			}
			else if (unitTo.equals("ft")) {
				return amount/12; //12 inches in 1 foot
			}
			else {
				return amount/63360; //63360 inches in 1 mile
			}
		}
		
		if (unitFrom.equals("ft")) {
			if (unitTo.equals("ft")) {
				return amount;
			}
			else if (unitTo.equals("in")) {
				return amount*12;
			}
			else {
				return amount/5280; //5280 feet in 1 mile
			}
		}
		
		if (unitFrom.equals("mi")) {
			if (unitTo.equals("mi")) {
				return amount;
			}
			else if (unitTo.equals("in")) {
				return amount*63360;
			}
			else {
				return amount*5280; 
			}
		}
	}
}




/* 
5.4.  Unit conversion. Write a unit conversion program that asks the users from which unit they want to convert (fl. oz, gal, oz, lb, in, ft, mi) and to which unit they want to 
convert (ml, l, g, kg, mm, cm, m, km). Reject incompatible conversions (such as gal → km). Ask for the value to be converted, then display the result:

Convert from? gal
Convert to? ml
Value? 2.5
2.5 gal = 9462.5 ml
*/