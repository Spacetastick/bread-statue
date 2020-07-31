package miscellaneous;

public class Payroll {

	private static int[] itemsSold = {48, 50, 37, 62, 38, 70, 55, 37, 64, 60};
	private static int employees = itemsSold.length;
	private static double[] wages = new double[employees];
	static double fixedWage = 10.0;
	static double perItemWage = 1.5;
	
	public static double computeBonusThreshold() {
		int lowest = itemsSold[0];
		int highest = itemsSold [0];
		double avg = 0;
		
		for (int items : itemsSold) {
			if (items > highest) {
				highest = items;
			}
			else if (items < lowest) {
				lowest = items;
			}
			avg += items;
		}
		
		avg -= highest;
		avg -= lowest;
		avg /= (employees - 2);
		
		return avg;
	}
	
	public static void computeWages(double fixedWage, double perItemWage) {
		double threshold = computeBonusThreshold();
		for (int i = 0; i < wages.length; i++) {
			wages[i] = fixedWage + (perItemWage * itemsSold[i]);
			if (itemsSold[i] > threshold) 
				wages[i] *= 1.1;
		}
		
		
	}
	
	public static void main(String[] args) {
		computeWages(fixedWage, perItemWage);
		for (double wage : wages) {
			System.out.println(wage);
		}
	}
	
}
