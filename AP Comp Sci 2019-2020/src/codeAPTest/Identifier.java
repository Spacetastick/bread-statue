package codeAPTest;

public class Identifier {
	
	public static int encodeToNumber(String str) {
		//implementation not shown
		return -1; //put here to get rid of error message
	}
	
	//ANSWER FOR A
	public static String generateID(String input) {
		if (input.length()%4 != 0) {
			return "error";
		}
		
		int sum = 0;
		for (int i = 0; i < input.length(); i+=4) {
			sum += encodeToNumber(input.substring(i, i+4));
		}
		
		if (sum > 100) {
			return input + "3";
		}
		else {
			return input + "X";
		}
	}
	
	//ANSWER FOR B
	/*
		In order to track how many times a call to generateID returns "error" without
		overloading or changing the signature of the methods, you could just create
		a new private int variable that will hold this number. An example implementation of
		this might be: private static int errorReturns = 0;
		This new variable would be added above the methods like normal class variables,
		and would need to be declared static in order to refer to it without attaching it
		to an object. It would also need to be initialized with the value of 0 so that
		the count can be modified.
		
		After implementing this new variable in the Identifier class, all you would need
		to do is add one line of code under the if statement in generateID that checks
		if the length of the input string is divisible by 4. This line of code should come
		before the return statement so that it will not be skipped by the program, and might
		look something like: errorReturns++;
	 */
}