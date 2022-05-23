/*
 * Class: CMSC 201
 * Project 1
 * Noah Cil
 * 2/1/22, Eclipse
 * Instructor: Professor Tanveer
 * Description: This program takes a temperature between -58°F and 41°F and a wind speed of at least 2 mph as input, and uses the wind-chill temperature formula to output the wind chill temperature.
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
 */

package project1;

import java.util.Scanner;

public class WindChillTemperature {

	static Scanner scanner = new Scanner(System.in);
	
	//constants of the wind chill formula defined here
	static final double FIRST_COEFFICIENT = 35.74;
	static final double SECOND_COEFFICIENT = 0.6215;
	static final double THIRD_COEFFICIENT = 35.75;
	static final double FOURTH_COEFFICIENT = 0.4275;
	static final double EXPONENT = 0.16;
	
	public static void main(String[] args) {
		//asking user for input and storing it in new variables
		System.out.println("Enter the temperature in Fahrenheit between -58°F and 41°F: ");
		double temperature = scanner.nextDouble();
		System.out.println("Enter the wind speed (>= 2) in miles per hour: ");
		double windSpeed = scanner.nextDouble();
		
		//the math done in the windChill variable assignment is just the wind chill formula using the constants and inputs
		double windChill = FIRST_COEFFICIENT + (SECOND_COEFFICIENT * temperature) - (THIRD_COEFFICIENT * Math.pow(windSpeed, EXPONENT)) + (FOURTH_COEFFICIENT * temperature * Math.pow(windSpeed, EXPONENT));
		System.out.println("The wind chill index is " + windChill);
	}
	
}
