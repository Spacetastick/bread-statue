/*
 * Class: CMSC 201
 * Project 3
 * Noah Cil
 * 4/11/22, Eclipse
 * Instructor: Professor Tanveer
 * Description: person class that provides the shared structure for the student and employee classes
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
 */

package project3;

public class Person {

	private String name;
	private String address;
	private String phoneNumber;
	private String emailAddress;
	
	public Person(String name, String address, String phoneNumber, String emailAddress) {
		this.name = name;
		this.address= address;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return emailAddress;
	}
	
}
