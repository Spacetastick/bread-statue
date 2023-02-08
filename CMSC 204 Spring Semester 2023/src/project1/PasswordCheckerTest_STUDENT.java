package project1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Noah Cil
 */
public class PasswordCheckerTest_STUDENT {

	ArrayList<String> passwords;
	
	@Before
	public void setUp() throws Exception {
		String[] p = {"778899CD#", "geoffrey9III$", "42bn*", "berthA22!", "february29"};
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(p));
		
		
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("abcAB4$"));
			assertTrue("Did not throw a lengthException", true);
		}
		catch(LengthException e) {
			assertTrue("Threw a lengthExcepetion", false);
		}
		catch(Exception e) {
			assertTrue("Threw some other exception besides lengthException", false);
		}
		
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("abcAB"));
			assertTrue("Did not throw a lengthException", false);
		}
		catch(LengthException e) {
			assertTrue("Successfully threw a lengthExcepetion", true);
		}
		 
		catch(Exception e) {
			assertTrue("Threw some other exception besides lengthException", false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("654321Aa%"));
			assertTrue("Did not throw a NoUpperAlphaException", true);
		}
		catch(NoUpperAlphaException e) {
			assertTrue("Threw a NoUpperAlphaExcepetion", false);
		}
		catch(Exception e) {
			assertTrue("Threw some other exception besides NoUpperAlphaException", false);
		}
		
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("654321"));
			assertTrue("Did not throw a NoUpperAlphaException", false);
		}
		catch(NoUpperAlphaException e) {
			assertTrue("Successfully threw a NoUpperAlphaExcepetion", true);
		}
		catch(Exception e) {
			assertTrue("Threw some other exception besides NoUpperAlphaException", false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("123456Az!"));
			assertTrue("Did not throw a NoLowerAlphaException", true);
		}
		catch(NoLowerAlphaException e) {
			assertTrue("Threw a NoLowerAlphaExcepetion", false);
		}
		catch(Exception e) {
			assertTrue("Threw some other exception besides NoLowerAlphaException", false);
		}
		
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("123456A"));
			assertTrue("Did not throw a NoLowerAlphaException", false);
		}
		catch(NoLowerAlphaException e) {
			assertTrue("Successfully threw a NoLowerAlphaExcepetion", true);
		}
		catch(Exception e) {
			assertTrue("Threw some other exception besides NoLowerAlphaException", false);
		}
	}
	
	/**
	 * Test if the password is weak
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			 
			PasswordCheckerUtility.isWeakPassword("berthA122!");
			assertTrue("Did not throw a WeakPassword Exception", true);
		}
		catch(WeakPasswordException e) {
			assertTrue("Threw a WeakPassword Exception", false);
		}
		catch(Exception e) {
			assertTrue("Threw some other exception besides WeakPasswordException", false);
		}
		
		try {
			PasswordCheckerUtility.isWeakPassword("berthA22!");
			assertTrue("Did not throw a WeakPasswordException", false);
		}
		catch(WeakPasswordException e) {
			assertTrue("Successfully threw a WeakPasswordException", true);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides WeakPasswordException", false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			assertEquals(true, PasswordCheckerUtility.isValidPassword("539$4aaBB"));
		 	assertTrue("Did not throw an InvalidSequenceException", true);
		}
		catch(InvalidSequenceException e) {
			assertTrue("Threw an InvalidSequenceExcepetion", false);
		}
		catch(Exception e) {
			assertTrue("Threw some other exception besides InvalidSequenceException", false);
		}
		
		try {
			assertEquals(true, PasswordCheckerUtility.isValidPassword("539$4aaBBBB"));
		 	assertTrue("Did not throw an InvalidSequenceException", false);
		}
		catch(InvalidSequenceException e) {
			assertTrue("Successfully threw an InvalidSequenceExcepetion", true);
		}
		catch(Exception e) {
			assertTrue("Threw some other exception besides InvalidSequenceException", false);
		}
		
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertEquals(true, PasswordCheckerUtility.isValidPassword("123456Aa^"));
			assertTrue("Did not throw a NoDigitException", true);
		}
		catch (NoDigitException e) {
			assertTrue("Threw a NoDigitException", false);
		}
		catch (Exception e) {
			assertTrue("Threw some other exception besides NoDigitException", false);
		}
		
		try {
			assertEquals(true, PasswordCheckerUtility.isValidPassword(("abCdef!")));
			assertTrue("Did not throw a NoDigitException", false);
		}
		catch (NoDigitException e) {
			assertTrue("Successfully threw a NoDigitException", true);
		}
		catch (Exception e) {
			assertTrue("Threw some other exception besides NoDigitException", false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			PasswordCheckerUtility.isValidPassword("123aA!");
			PasswordCheckerUtility.isValidPassword("berthA22!");
		}
		catch (Exception e) {
			assertTrue("An exception was thrown", false);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> output = PasswordCheckerUtility.getInvalidPasswords(passwords);
		
		String[] p = {"778899CD# The password must contain at least one lowercase alphabetic character", 
				"geoffrey9III$ The password cannot contain more than two of the same character in sequence", 
				"42bn* The password must be at least 6 characters long", "february29 The password must contain at least one uppercase alphabetic character"};
		ArrayList<String> invalidPasswords = new ArrayList<>();
		invalidPasswords.addAll(Arrays.asList(p));
		
		assertTrue(output.equals(invalidPasswords));
	}
	
}
