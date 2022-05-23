/*
 * Class: CMSC 201
 * Project 2
 * Noah Cil
 * 2/20/22, Eclipse
 * Instructor: Professor Tanveer
 * Description: This program takes a sample of 10 numbers as the input and prints out the mean and standard deviation of those numbers
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
 */

package project2;

import java.util.Scanner;

public class Statistics {

	//declaration of global variables for use in the four methods
	static Scanner input = new Scanner(System.in);
	static double[] nums = new double[10];
	static double sum = 0;
	static double mean, standardDeviation;
	
	//first method, displays the title of the program and takes 10 inputs from the user.
	//calculates the sum of the inputs as they are obtained.
	static void initialization() {
		//title
		System.out.println("********************************************************************");
		System.out.println("    Project 2: Statistics - compute mean and standard deviation    ");
		System.out.println("********************************************************************");
		
		//prompt and collection of inputs, calculation of sum
		System.out.print("Enter numbers: ");
		for (int i = 0; i < 10; i++) {
			nums[i] = input.nextDouble();
			sum += nums[i];
		}
	}
	
	//second method, calculates the mean using the sum global variable (which will be calculated before this method is called)
	static void calculateMean() {
		mean = sum / 10;
	}
	
	//third method, calculates the standard deviation using the mean (which will be calculated beforehand) and array of inputs
	static void calculateStandardDeviation() {
		//first finds the sum of the distances of each input from the mean, squared.
		double sumDistanceFromMean = 0;
		for (int i = 0; i < 10; i++)
			sumDistanceFromMean += Math.pow(nums[i] - mean, 2);
		
		//then square roots that sum over 9 (the total number of inputs -1 since this is a sample)
		standardDeviation = Math.sqrt(sumDistanceFromMean / 9);
	}
	
	//fourth method, displays the mean, standard deviation, my name and the date.
	static void displayCalculations() {
		//first, both of these methods are declared to initialize the values of mean and standardDeviation
		calculateMean();
		calculateStandardDeviation();
		//printing of mean and standard deviation
		System.out.println("The mean is " + mean);
		//this print statement has formatting to only print the standard deviation up to 5 decimal places
		System.out.printf("The standard deviation is %.5f %n", standardDeviation);
		
		//printing of my name and the date
		System.out.println("********************************************************************");
		System.out.println("Student: Noah Cil");
		System.out.println("Date: 02/20/2022");
		System.out.println("********************************************************************");
	}
	
	//main method where the necessary calls are made to execute the program.
	public static void main(String[] args) {
		initialization();
		displayCalculations();
	}
	
}
