/*
 * Class: CMSC 201
 * Project 3
 * Noah Cil
 * 4/11/22, Eclipse
 * Instructor: Professor Tanveer
 * Description: creates a staff object that stores the below information, which can be printed out
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
 */

package project3;

public class Staff extends Employee {

	private String title;
	
	public Staff(String name, String address, String phoneNumber, String emailAddress, int officeNumber, int salary, MyDate dateHired, String title) {
		super(name, address, phoneNumber, emailAddress, officeNumber, salary, dateHired);
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "Staff: " + getName() + '\n' + "Title: " + title + '\n' + "Salary: $" 
				+ getSalary() + '\n' + "Date Hired: " + getDateHired() + '\n' + "Office: " 
				+ getOfficeNumber() + '\n' + "Address: " + getAddress() + '\n' 
				+ "Phone Number: " + getPhoneNumber() + '\n' + "Email Address: " 
				+ getEmail();
	}
	
}
