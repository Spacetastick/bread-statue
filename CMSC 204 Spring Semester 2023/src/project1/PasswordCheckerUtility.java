package project1;

import java.util.ArrayList;
import java.util.regex.Pattern;


//make methods that dont need to be public into private methods
//how do I return false AND throw an exception?
//ask about compare password methods
//fix nosamechar if necessary
//does java end method execution when throw exception comes
public class PasswordCheckerUtility {
	
	/*
	 * compare equality of two passwords
	 * throws exception if they are not same
	 */
	//Do I just not throw the exception here?
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		
	}
	
	/*
	 * compare equality of two passwords
	 * return true if both same, false otherwise
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		
	}
	
	/*
	 * checks the password length requirement - the password must be at least 6 characters long
	 * return true if meets length requirement
	 * throw lengthexception if does not met minimum length requirement
	 */
	public static boolean isValidLength(String password) throws LengthException {
		if (password.length() < 6)
			throw new LengthException();
		return true;
	}
	
	/*
	 * checks the password alpha character requirement - password must contain an uppercase alpha character
	 * true if meet alpha character requirement
	 * throws exception if does not meet requirement
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		Pattern pattern = Pattern.compile(".*[A-Z].*");
		
		if (!pattern.matcher(password).matches())
			throw new NoUpperAlphaException();
		return true;
	}
	
	/*
	 * checks password lowercase requirement - password must contain at least one lowercase alpha character
	 * true if meets lowercase requirement
	 * throw exception if does not
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		Pattern pattern = Pattern.compile(".*[a-z].*");
		
		if (!pattern.matcher(password).matches())
			throw new NoLowerAlphaException();
		return true;
	}
	
	/*
	 * checks the password digit requirement - password must contain a numeric character
	 * true if meet digit requirement
	 * throws exception if does not meet digit requirement
	 */
	public static boolean hasDigit(String password) throws NoDigitException {
		Pattern pattern = Pattern.compile(".*[0-9].*");
		
		if (!pattern.matcher(password).matches())
			throw new NoDigitException();
		return true;
	}
	
	/*
	 * checks the password special character requirement - password must contain a special character
	 * return true if meets special character requirement
	 * throw exception if does not
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		//pattern is an instance that is NOT a lower or upper case alpha or a digit
		Pattern pattern = Pattern.compile(".*[^a-zA-Z0-9].*");
		
		if (!pattern.matcher(password).matches())
			throw new NoSpecialCharacterException();
		return true;
	}
	
	/*
	 * checks the password sequence requirement - password should not contain more than 2 of the same character in a sequence
	 * false if does not meet sequence requirement
	 * throw exception if meet sequence requirement
	 */
	//ok but why is it asking me to implement it like that it makes no sense
	public static boolean noSameCharInSequence(String password) throws InvalidSequenceException {
			for (int i = 0; i < password.length(); i++) {
				String sequence = password.substring(i, i+1) + password.substring(i, i+1) + password.substring(i, i+1);
				if (password.contains(sequence))
					throw new InvalidSequenceException();
			}
			return true;
	}
	
	/*
	 * return true if valid password (follows all the following rules), returns false if an invalid password.
	 * 1. at least 6 characters long
	 * 2. at least 1 numeric character
	 * 3. at least 1 uppercase alphabetic character
	 * 4. at least 1 lowercase alphabetic character
	 * 5. at least 1 special character
	 * 6. no more than 2 of the same character in a sequence
	 * 
	 * true if valid password, false if invalid password
	 * throw appropriate exception depending on what is violated
	 */
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		if (!isValidLength(password))
			throw new LengthException();
		if (!hasUpperAlpha(password))
			throw new NoUpperAlphaException();
		if (!hasLowerAlpha(password))
			throw new NoLowerAlphaException();
		if (!hasDigit(password))
			throw new NoDigitException();
		if (!hasSpecialChar(password))
			throw new NoSpecialCharacterException();
		if (!noSameCharInSequence(password))
			throw new InvalidSequenceException();
		
		return true;
	}
	
	/*
	 * chesk if the password contains 6 to 9 characters
	 * true if does, false otherwise
	 */
	public static boolean hasBetweenSixAndNineChars(String password) {
		if (password.length() >= 6 && password.length() <= 9)
			return true;
		return false;
	}
	
	/*
	 * checks if password is valid and the length is not between 6-9 characters
	 * false if the password is valid and the length of password is not between 6 and 9
	 * if length of password is between 6 and 9, although the password may be valid, throw exception
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException {
		if (isValidPassword(password) && password.length() <= 9)
			throw new WeakPasswordException();
		return false;
	}
	
	/*
	 * accepts an arraylist of passwords as the parameter and returns an arraylist with the satus of any invalid passwords (weak passwords are not considered invalid).
	 * the arraylist of invalid passwords will be of the following format: password BLANK mesage of the exception thrown
	 * returns arraylist of invalid passwords in the above format
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		
	}
	
}
