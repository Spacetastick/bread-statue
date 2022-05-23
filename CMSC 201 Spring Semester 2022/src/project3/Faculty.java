/*
 * Class: CMSC 201
 * Project 3
 * Noah Cil
 * 4/11/22, Eclipse
 * Instructor: Professor Tanveer
 * Description: creates a faculty object that stores the below information, which can be printed out
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
 */

package project3;

public class Faculty extends Employee {

	private String officeHours;
	private String rank;
	
	public Faculty(String name, String address, String phoneNumber, String emailAddress, int officeNumber, int salary, MyDate dateHired, String officeHours, String rank) {
		super(name, address, phoneNumber, emailAddress, officeNumber, salary, dateHired);
		this.officeHours = officeHours;
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		return "Faculty: " + getName() + '\n' + "Rank: " + rank + '\n' + "Salary: $" 
				+ getSalary() + '\n' + "Date Hired: " + getDateHired() + '\n' 
				+ "Office Hours: " + officeHours + '\n' + "Office: " + getOfficeNumber() 
				+ '\n' + "Address: " + getAddress() + '\n' + "Phone Number: " 
				+ getPhoneNumber() + '\n' + "Email Address: " + getEmail();
	}
	
}
