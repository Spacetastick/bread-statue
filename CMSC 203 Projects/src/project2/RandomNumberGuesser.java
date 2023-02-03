//not sure if this needed exception checking or not

package project2;

import java.util.Scanner;

@SuppressWarnings("static-access") //🥹
public class RandomNumberGuesser {
	
	public static void main(String[] args) {
		System.out.println("This program will generate a secret random number between 1 and 100. "
				+ "Attempt to guess that number in as few guesses as you can.");
		
		Scanner input = new Scanner(System.in);
		boolean playing = true;
		while(playing) {
			RNG bruh = new RNG(); //bruh why
			
			int generatedNumber = RNG.rand();
			//System.out.println("(test) generated number is " + generatedNumber);
			System.out.println("Enter your first guess");
			int currentGuess = input.nextInt();
			int lowGuess = 1;
			int highGuess = 100;
			
			while (currentGuess != generatedNumber) {
				//why are the methods static this makes no sense
				System.out.println("Number of guesses is " + bruh.getCount());
				
				if (RNG.inputValidation(currentGuess, lowGuess, highGuess)) {
					if (currentGuess > generatedNumber) {
						System.out.println("Your guess is too high");
						highGuess = currentGuess;
					}
					else {
						System.out.println("Your guess is too low");
						lowGuess = currentGuess;
					}
				}
				System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
				currentGuess = input.nextInt();
			}
			System.out.println("Number of guesses is " + bruh.getCount() //🥴 
					+ "\nCongratulations, you guessed correctly"
					+ "\nTry again? (yes or no)");
			if (input.next().equals("no"))
				playing = false;
			else
				bruh.resetCount(); //agony
			
		}
		
		System.out.println("Thanks for playing...");
		input.close();
	}
	
}
