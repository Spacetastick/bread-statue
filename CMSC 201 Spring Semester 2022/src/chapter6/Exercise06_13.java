package chapter6;

public class Exercise06_13 {

	static void sumSeries(double num) {
		double sum = 0;
		
		System.out.println("i     m(i)");
		for (double i = 1; i <= num; i++) {
			sum += i/(i+1);
			System.out.println(i + "     " + sum);
		}
	}
	
	public static void main(String[] args) {
		sumSeries(20);
	}
	
}
