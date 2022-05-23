package chapter6;

import java.util.Scanner;

public class Exercise06_25 {

	public static String convertMillis(long millis) {
		long hours = millis/3600000;
		millis %= 3600000;
		long minutes = millis/60000;
		millis %= 60000;
		long seconds = millis/1000;
		
		return hours + ":" + minutes + ":" + seconds;
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a time in milliseconds: ");
		long time = input.nextLong();
		System.out.println(convertMillis(time));
	}
	
}
