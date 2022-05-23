/*
 * Class: CMSC 201
 * Project 1
 * Noah Cil
 * 2/1/22, Eclipse
 * Instructor: Professor Tanveer
 * Description: This program finds the total cost of gas for a road trip using the distance, miles per gallon, and the price per gallon of gas as inputs.
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
 */

package project1;

import java.util.Scanner;

public class CostOfDriving {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		//asking user for input and storing it in new variables
		System.out.println("Enter the driving distance: ");
		double distance = scanner.nextDouble();
		System.out.println("Enter miles per gallon: ");
		double mpg = scanner.nextDouble();
		System.out.println("Enter price per gallon: ");
		double price = scanner.nextDouble();
		
		//value assigned to cost is the math for the cost of the trip, calculated using the previously collected inputs
		double cost = (distance / mpg) * price;
		System.out.println("The cost of driving is $" + cost);
	}
	
}
