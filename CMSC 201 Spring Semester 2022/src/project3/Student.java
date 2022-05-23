/*
 * Class: CMSC 201
 * Project 3
 * Noah Cil
 * 4/11/22, Eclipse
 * Instructor: Professor Tanveer
 * Description: creates a student object that stores the below information, which can be printed out
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
 */

package project3;

public class Student extends Person {

	private final String classStatus;
	
	public Student(String name, String address, String phoneNumber, String emailAddress, String classStatus) {
		super(name, address, phoneNumber, emailAddress);
		this.classStatus = classStatus;
	}

	@Override
	public String toString() {
		return "Student: " + getName() + '\n' + "Status: " + classStatus + '\n' 
				+ "Address: " + getAddress() + '\n' + "Phone Number: " + getPhoneNumber() 
				+ '\n' + "Email Address: " + getEmail();
	}
	
}
