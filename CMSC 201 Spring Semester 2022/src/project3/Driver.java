/*
 * Class: CMSC 201
 * Project 3
 * Noah Cil
 * 4/11/22, Eclipse
 * Instructor: Professor Tanveer
 * Description: Program that tests the other classes to make sure they perform their intended functions
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
 */

package project3;

import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Driver {

	private static Scanner console = new Scanner(System.in);
	
	private static String name;
	private static String address;
	private static String phoneNumber;
	private static String emailAddress;
	private static int officeNumber;
	private static int salary;
	private static MyDate dateHired;
	
	//this method checks that the input for an int variable is a (valid) positive integer, 
	//and prevents the program from crashing by asking for new input if it is not.
	private static int processInput(Integer... validInputs) {
		String input;
		int result = -1;
		
		while (result < 0) {
			input = console.nextLine();
			try {
				result = Integer.parseInt(input);
				if (validInputs.length != 0) {
					if (Arrays.asList(validInputs).contains(result)) {
						break;
					}
					else {
						System.out.print("Incorrect input, please enter ");
						for (int i = 0; i < validInputs.length-2; i++)
							System.out.print(validInputs[i] + ", ");
						System.out.print(validInputs[validInputs.length-2] + " or " + validInputs[validInputs.length-1] + ":");
						result = -1; //to continue looping
					}
				}
				else if (result < 0)
					System.out.print("Incorrect input, please enter a non-negative integer: ");
				else
					break;
				
			}
			catch (InputMismatchException | NumberFormatException e) {
				if (validInputs.length != 0) {
					System.out.print("Incorrect input, please enter ");
					for (int i = 0; i < validInputs.length-1; i++)
						System.out.print(validInputs[i] + ", ");
					System.out.print("or " + validInputs[validInputs.length-1] + ":");
				}
				else
					System.out.print("Incorrect input, please enter a non-negative integer: ");
			}
		}
		
		return result;
	}
	
	//this method collects the inputs that all three object types use
	private static void personQuestions() {
		System.out.print("Enter a name: ");
		name = console.nextLine();
		//the difference between the blocks in this if/else statement has to do 
		//with punctuation rules, which is just an uneccesary detail I added
		if (name.substring(name.length()-1).equals("s")) {
			System.out.print("Enter " + name + "' address: ");
			address = console.nextLine();
			System.out.print("Enter " + name + "' phone number: ");
			phoneNumber = console.nextLine();
			System.out.print("Enter " + name + "' email: ");
			emailAddress = console.nextLine();
		}
		else {
			System.out.print("Enter " + name + "'s address: ");
			address = console.nextLine();
			System.out.print("Enter " + name + "'s phone number: ");
			phoneNumber = console.nextLine();
			System.out.print("Enter " + name + "'s email: ");
			emailAddress = console.nextLine();
		}
		
	}
	
	//collects inputs for both employee types
	private static void employeeQuestions() {
		System.out.print("Enter an office number: ");
		officeNumber = processInput();
		System.out.print("Enter a salary: $");
		salary = processInput();
		System.out.print("Enter a hire date (mm/dd/yyyy): ");
		dateHired = new MyDate(console.nextLine());
	}
	
	public static void main(String[] args) {
		System.out.println("1) to create a student");
		System.out.println("2) to create an employee");
		System.out.print("Choice: ");
		int choice = processInput(1, 2);

		
		personQuestions();
		if (choice == 1) {
			if (name.substring(name.length()-1).equals("s"))
				System.out.print("Enter " + name + "' class status: ");
			else
				System.out.print("Enter " + name + "'s class status: ");
			String classStatus = console.nextLine();
			System.out.println("--------------------------");
			System.out.print(new Student(name, address, phoneNumber, emailAddress, classStatus).toString());
		}
		else if (choice == 2){
			System.out.println("1) to create a faculty member");
			System.out.println("2) to create a staff member");
			System.out.print("Choice: ");
			choice = processInput(1, 2);
			
			employeeQuestions();
			if (choice == 1) {
				System.out.print("Enter office hours: ");
				String officeHours = console.nextLine();
				System.out.print("Enter a rank: ");
				String rank = console.nextLine();
				System.out.println("--------------------------");
				System.out.print(new Faculty(name, address, phoneNumber, emailAddress, officeNumber, salary, dateHired, officeHours, rank).toString());
			}
			else if (choice == 2){
				System.out.print("Enter a title: ");
				String title = console.nextLine();
				System.out.println("--------------------------");
				System.out.print(new Staff(name, address, phoneNumber, emailAddress, officeNumber, salary, dateHired, title).toString());
			}
		}
		
	}
	
}
