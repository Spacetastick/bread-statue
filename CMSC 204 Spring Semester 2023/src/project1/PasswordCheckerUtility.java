package project1;

import java.util.ArrayList;
import java.util.regex.Pattern;


public class PasswordCheckerUtility {

	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		if (password.equals(passwordConfirm))
			return;
		throw new UnmatchedException();
	}

	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		if (password.equals(passwordConfirm))
			return true;
		return false;
	}

	private static boolean isValidLength(String password) throws LengthException {
		if (password.length() < 6)
			throw new LengthException();
		return true;
	}

	private static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		Pattern pattern = Pattern.compile(".*[A-Z].*");
		
		if (!pattern.matcher(password).matches())
			throw new NoUpperAlphaException();
		return true;
	}

	private static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		Pattern pattern = Pattern.compile(".*[a-z].*");
		
		if (!pattern.matcher(password).matches())
			throw new NoLowerAlphaException();
		return true;
	}

	private static boolean hasDigit(String password) throws NoDigitException {
		Pattern pattern = Pattern.compile(".*[0-9].*");
		
		if (!pattern.matcher(password).matches())
			throw new NoDigitException();
		return true;
	}

	private static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		//pattern is an instance that is NOT a lower or upper case alpha or a digit
		Pattern pattern = Pattern.compile(".*[^a-zA-Z0-9].*");
		
		if (!pattern.matcher(password).matches())
			throw new NoSpecialCharacterException();
		return true;
	}

	private static boolean noSameCharInSequence(String password) throws InvalidSequenceException {
			for (int i = 0; i < password.length(); i++) {
				String sequence = password.substring(i, i+1) + password.substring(i, i+1) + password.substring(i, i+1);
				if (password.contains(sequence))
					throw new InvalidSequenceException();
			}
			return true;
	}
	
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		if (isValidLength(password) && hasUpperAlpha(password) && hasLowerAlpha(password) 
				&& hasDigit(password) && hasSpecialChar(password) && noSameCharInSequence(password)) {
			return true;
		}
		
		return false;
	}
	
	private static boolean hasBetweenSixAndNineChars(String password) {
		if (password.length() >= 6 && password.length() <= 9)
			return true;
		return false;
	}
	
	public static boolean isWeakPassword(String password) throws WeakPasswordException {
		if (hasBetweenSixAndNineChars(password))
			throw new WeakPasswordException();
		return false;
	}
	
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		ArrayList<String> invalidPasswords = new ArrayList<>();
		
		for (String password : passwords) {
			try {
				isValidPassword(password);
			}
			catch (Exception bruh) {
				invalidPasswords.add(password + " " + bruh.getMessage());
			}
		}
		
		return invalidPasswords;
	}
	
}
