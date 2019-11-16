//Noah Cil, 10/23/19, Conversion calculator for imperial units to metric units

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
			return true;
		}
	}
	
	public static double convert(String from, String to, double amount) {
		unitFrom = from;
		unitTo = to;
		fromAmount = amount;
		
		if (unitFrom.equals("fl. oz")) {
			if (unitTo.equals("ml")) {
				fromAmount*=29.574;
			}
			else if (unitTo.equals("l")) {
				fromAmount/=33.814;
			}
		}
		else if (unitFrom.equals("gal")) {
			if (unitTo.equals("ml")) {
				fromAmount*=3785.412;
			}
			else if (unitTo.equals("l")) {
				fromAmount*=3.785;
			}
		}
		else if (unitFrom.equals("oz")) {
			if (unitTo.equals("g")) {
				fromAmount*=28.35;
			}
			else if (unitTo.equals("kg")) {
				fromAmount/=35.274;
			}
		}
		else if (unitFrom.equals("lb")) {
			if (unitTo.equals("g")) {
				fromAmount*=453.592;
			}
			else if (unitTo.equals("kg")) {
				fromAmount/=2.205;
			}
		}
		else if (unitFrom.equals("in")) {
			if (unitTo.equals("mm")) {
				fromAmount*=25.4;
			}
			else if (unitTo.equals("cm")) {
				fromAmount*=2.54;
			}
			else if (unitTo.equals("m")) {
				fromAmount/=39.37;
			}
			else if (unitTo.equals("km")) {
				fromAmount/=39370.079;
			}
		}
		else if (unitFrom.equals("ft")) {
			if (unitTo.equals("mm")) {
				fromAmount*=304.8;
			}
			else if (unitTo.equals("cm")) {
				fromAmount*=30.48;
			}
			else if (unitTo.equals("m")) {
				fromAmount/=3.281;
			}
			else if (unitTo.equals("km")) {
				fromAmount/=3280.84;
			}
		}
		else if (unitFrom.equals("mi")) {
			if (unitTo.equals("mm")) {
				fromAmount*=1609344;
			}
			else if (unitTo.equals("cm")) {
				fromAmount*=160934.4;
			}
			else if (unitTo.equals("m")) {
				fromAmount*=1609.344;
			}
			else if (unitTo.equals("km")) {
				fromAmount*=1.609;
			}
		}
		return fromAmount;
	}
}