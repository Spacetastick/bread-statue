package unitConversion;

public class UnitConversion {

	private static String unitFrom;
	private static String unitTo;
	private static double fromAmount;
	
	public static boolean validUnits(String from, String to) {
		unitFrom = from;
		unitTo = to;
		
		if (!(unitFrom.matches("fl. oz|gal|oz|lb|in|ft|mi"))) {
			return false;
		}
		else if (!(unitTo.matches("ml|l|g|kg|mm|cm|m|km"))) {
			return false;
		}
		else {
			validConversion(unitFrom, unitTo);
			return true;
		}	
		
	}
	
	public static boolean validConversion(String from, String to) {
		unitFrom = from;
		unitTo = to;
		
		if (unitFrom.matches("fl. oz|gal") && (!(unitTo.matches("ml|l")))) {
			return false;
		}
		else if (unitFrom.matches("oz|lb") && (!(unitTo.matches("g|kg")))) {
			return false;
		}
		else if (unitFrom.matches("in|ft|mi") && (!(unitTo.matches("mm|cm|m|km")))) {
			return false;
		}
		else {
			convert(unitFrom, unitTo, fromAmount); //find a way to set fromAmount
			return true;
		}
	}
	
	public static double convert(String from, String to, double amount) { //do i need strings here?
		unitFrom = from;
		unitTo = to;
		fromAmount = amount;
		
		
		
	}
}
/* 
5.4.  Unit conversion. Write a unit conversion program that asks the users from which 
unit they want to convert (fl. oz, gal, oz, lb, in, ft, mi) and to which unit they want 
to 
convert (ml, l, g, kg, mm, cm, m, km). Reject incompatible conversions (such as gal → km).
Ask for the value to be converted, then display the result:

Convert from? gal
Convert to? ml
Value? 2.5
2.5 gal = 9462.5 ml
*/