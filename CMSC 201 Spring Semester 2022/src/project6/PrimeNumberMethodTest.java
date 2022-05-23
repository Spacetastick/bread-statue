/*
 * Class: CMSC 201
 * Project 6
 * Noah Cil
 * 5/15/22, Eclipse
 * Instructor: Professor Tanveer
 * Description: Program that tests the isPrime method of the PrimeNumberMethod class
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
 */

package project6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/** This class tests the isPrime method of the PrimeNumberMethod class
 *  @author Noah Cil
 *  @version 1.0
 */
class PrimeNumberMethodTest {

	/** Test four instances of the isPrime method */
	@Test
	void test() {
		assertEquals(false, PrimeNumberMethod.isPrime(4));
		assertEquals(true, PrimeNumberMethod.isPrime(97));
		assertEquals(false, PrimeNumberMethod.isPrime(12));
		assertEquals(true, PrimeNumberMethod.isPrime(229));
	}
	

}
