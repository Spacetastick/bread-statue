/*
 * Class: CMSC 201
 * Project 6
 * Noah Cil
 * 5/15/22, Eclipse
 * Instructor: Professor Tanveer
 * Description: Program that tests the length, charAt, substring, and indexOf 
 *              methods of the String class
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
 */

package project6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/** This class tests methods of the String class
 *  @author Noah Cil
 *  @version 1.0
 */
class StringTest {

	/** Data field: test string */
	private String testString = "This is a test String";
	
	/** Test the length method */
	@Test
	void testLength() {
		assertEquals(21, testString.length());
	}
	
	/** Test the char at method */
	@Test
	void testCharAt() {
		assertEquals('a', testString.charAt(8));
	}
	
	/** Test the substring method */
	@Test
	void testSubstring() {
		assertEquals("test", testString.substring(10, 14));
	}
	
	/** Test the index of method */
	@Test
	void testIndexOf() {
		assertEquals(0, testString.indexOf("This"));
	}

}
