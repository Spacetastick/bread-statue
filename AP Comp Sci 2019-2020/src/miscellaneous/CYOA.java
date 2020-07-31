package miscellaneous;

import java.util.Scanner;

public class CYOA
{
    public static void main(String[] args)
    {
        Scanner player = new Scanner(System.in);
        boolean playAgain = true;
        
        while (playAgain == true) {
        //Intro
        System.out.println("You have been working hard at school for the past week and feel \nburnt out. You wish you could stay home and take a day off, but \nyou might miss some important work!");
        //First choice: School or Home
        System.out.println("Do you want to go to [S]chool, or stay [H]ome?");
        String userChoice = "";
            //User Chooses School
            while (!(userChoice.matches("S|H|s|h"))) {
                userChoice = player.nextLine();
                
                if (userChoice.toUpperCase().substring(0,1).matches("S|s")) {
                    System.out.println("You are going to School!");
                }
                else if (userChoice.toUpperCase().substring(0,1).matches("H|h")) {
                    System.out.println("You are staying Home!");
                }
                else {
                    System.out.println("Incorrect input, try again.");
                }
            }
                //School Description
                if (userChoice.matches("S|s")) {
                    //Second choice: Math or Computer Science class
                    System.out.println("You are at school now, but you only have enough energy to go to \none class. Do you go to [M]ath class or [C]omputer Science class?");
                    
                    while (!(userChoice.matches("M|C|m|c"))) {
                        userChoice = player.nextLine();
                        
                        //User Chooses Math class
                        if (userChoice.toUpperCase().matches("M|m")) {
                            //Math class Description
                            System.out.println("You decide to go to Math class since you can't afford to miss it.");
                                //User gets bored in Math and falls asleep!
                                System.out.println("You tried to stay awake and do the work in Math class, but you \nfell asleep while the teacher was talking!");
                        }
                            
                        //User Chooses Computer Science class
                        else if (userChoice.toUpperCase().matches("C|c")) {
                            //Computer Science class Description
                            System.out.println("You decide to go to Computer Science class since you like coding.");
                                //User makes an epic program and doesn't fall asleep!
                                System.out.println("You make an epic program and impress your teacher!");
                        }
                        else {
                            System.out.println("Incorrect input, try again.");
                        }
                    }
                        
                }
            //User Chooses Home
            
                //Home Description
                if (userChoice.matches("H|h")) {
                    //Second choice: Computer Games or Sleep
                    System.out.println("You decide to stay Home, and now need to chose how you will spend \nyour day off. Do you want to play [C]omputer Games or [S]leep \nmore?");
                    
                    while (!(userChoice.matches("C|S|c|s"))) {
                        userChoice = player.nextLine();
                        
                        //User Chooses Computer Games
                        if (userChoice.toUpperCase().matches("C|c")) {
                            //Computer Games Description
                            System.out.println("You decide to play some epic Computer Games because you haven't \nbeen able to since school started.");
                                //User plays games all day and doesn't do homework!
                                System.out.println("You had so much fun playing Computer Games that you forgot all \nabout your homework for the next day!");
                        }
                            
                        //User Chooses Sleep
                        else if (userChoice.toUpperCase().matches("S|s")) {
                            //Sleep Description
                            System.out.println("You decide to go back to sleep because you haven't gotten 8 hours \nof sleep since school started.");
                                //User gets a good 8 hours sleep and does all their homework!
                                System.out.println("You get a full 8 hours of sleep and then have enough energy to do \nall your homework!");
                        }
                        else {
                            System.out.println("Incorrect input, try again.");
                        }
                    }
                        
                }
        //End
        System.out.println("The End!");
        System.out.println("Do you want to play again? [Y, N]");
        while (!(userChoice.matches("Y|N|y|n"))) {
            userChoice = player.nextLine();
    
        if (!(userChoice.matches("Y|N|y|n"))) {
            System.out.println("Incorrect input, try again.");
        }
     }
     if (userChoice.matches("Y|y")) {
            playAgain = true;
        }
        else if (userChoice.matches("N|n")) {
        	System.out.println("See you!");
            break;
        }
    }
        player.close();
  }
}