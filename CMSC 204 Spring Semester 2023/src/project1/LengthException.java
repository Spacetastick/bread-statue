package project1;

public class LengthException extends Exception {	
	public LengthException() {
		super("The password must be at least 6 characters long");
	}
}

class NoUpperAlphaException extends Exception {
	public NoUpperAlphaException() {
		super("The password must contain at least one uppercase alphabetic character");
	}
}

class NoLowerAlphaException extends Exception {
	public NoLowerAlphaException() {
		super("The password must contain at least one lowercase alphabetic character");
	}
}

class NoDigitException extends Exception {
	public NoDigitException() {
		super("The password must contain at least one digit");
	}
}

class NoSpecialCharacterException extends Exception {
	public NoSpecialCharacterException() {
		super("The password must contain at least one special character");
	}
}

class InvalidSequenceException extends Exception {
	public InvalidSequenceException() {
		super("The password cannot contain more than two of the same character in sequence");
	}
}

class WeakPasswordException extends Exception {
	public WeakPasswordException() {
		super("The password is OK but weak - it contains fewer than 10 characters");
	}
}

//throw this exception from the GUI, not the utility class
class UnmatchedException extends Exception {
	public UnmatchedException() {
		super("Passwords do not match");
	}
}