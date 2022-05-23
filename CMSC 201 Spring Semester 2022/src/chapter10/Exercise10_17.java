package chapter10;

import java.math.BigDecimal;

public class Exercise10_17 {
	
	public static void main(String[] args) {
		
		System.out.println("The ten numbers are");
		//base is the square root of the max long value, which is used to find the first 10 squares greater than the max long value
		BigDecimal base = new BigDecimal((long)Math.sqrt(Long.MAX_VALUE));
		
		int count = 0;
		while (count < 10) {
			BigDecimal squared = base.multiply(base);
			
			if (squared.compareTo(new BigDecimal(Long.MAX_VALUE))  == 1) {
				count++;
				System.out.println(count + ". " + squared);
			}
			
			base = base.add(BigDecimal.ONE);
		}
		
		
	}
	
}
