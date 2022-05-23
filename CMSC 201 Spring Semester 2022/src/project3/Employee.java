/*
 * Class: CMSC 201
 * Project 3
 * Noah Cil
 * 4/11/22, Eclipse
 * Instructor: Professor Tanveer
 * Description: employee class that provides the shared structure for the faculty and staff classes, inherting from person
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
 */

package project3;

public class Employee extends Person {

	private int officeNumber;
	private int salary;
	private MyDate dateHired;
	
	public Employee(String name, String address, String phoneNumber, String emailAddress, int officeNumber, int salary, MyDate dateHired) {
		super(name, address, phoneNumber, emailAddress);
		this.salary = salary;
		this.officeNumber = officeNumber;
		this.dateHired = dateHired;
	}
	
	public int getOfficeNumber() {
		return officeNumber;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public String getDateHired() {
		return dateHired.getDate();
	}
	
}
