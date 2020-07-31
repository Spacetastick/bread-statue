package miscellaneous;

import java.util.Scanner;

public class RockPaperScissors
{
    private static final String USER_PLAYER = "User wins!";
    private static final String COMPUTER_PLAYER = "Computer wins!";
    private static final String TIE = "Tie";
    
    private static String getWinner(String user, String computer)
    {
        
        if (user.equals("rock")) {
            if (computer.equals("rock")) {
                return TIE;
            }
            else if (computer.equals("paper")) {
                return COMPUTER_PLAYER;
            }
            else {
                return USER_PLAYER;
            }
        }
        else if (user.equals("paper")) {
            if (computer.equals("rock")) {
                return USER_PLAYER;
            }
            else if (computer.equals("paper")) {
                return TIE;
            }
            else {
                return COMPUTER_PLAYER;
            }
        }
        else if (user.equals("scissors")) {
            if (computer.equals("rock")) {
                return COMPUTER_PLAYER;
            }
            else if (computer.equals("paper")) {
                return USER_PLAYER;
            }
            else {
                return TIE;
            }
        }
        else {
            return "Error!";
        }
        
    }
    
    public static void main(String[] args)
    {
    	Scanner input = new Scanner(System.in);
        boolean play = true;
        
        while (play == true) {
        System.out.print("Enter your choice (rock, paper, or scissors): ");
        String user = input.next();
        
        System.out.println("User: " + user);
        
        int min = 1;
        int max = 3;
        String computer;
        
        if (Randomizer.nextInt(min, max) == 1) {
            computer = "rock";
        }
        else if (Randomizer.nextInt(min, max) == 2) {
            computer = "paper";
        }
        else {
            computer = "scissors";
        }
        System.out.println("Computer: " + computer);
        
        System.out.println(getWinner(user, computer));
        
        System.out.println("Do you want to play again? [Y]es or [N]o");
        boolean answered = false;
        while (answered == false) {
        	String ans = input.next();
        	if (ans.matches("Y|N|y|n")) {
        		answered = true;
        		if (ans.matches("N|n"))
        			play = false;
        	}
        	else {
        		System.out.println("Invalid Input!");
        		System.out.println("Do you want to play again? [Y]es or [N]o");
        	}
        }
    }
        System.out.println("Goodbye!");
        input.close();
    }
}

/*Enter your choice (rock, paper, or scissors): rock
User: rock
Computer: (either rock, paper, or scissors)
(Either Tie, User wins!, or Computer wins!)
Enter your choice (rock, paper, or scissors): rock
if(scan.hasNextLine()){
 String story = scan.nextLine();
}*/

