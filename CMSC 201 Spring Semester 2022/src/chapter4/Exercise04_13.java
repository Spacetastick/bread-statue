//maybe change code later after reading chapter to see how book wanted me to do it

package chapter4;

import java.util.Scanner;

public class Exercise04_13 {
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Enter a letter: ");
        Character letter = scanner.next().charAt(0);
        
        Character letterLower = Character.toLowerCase(letter);
        String letterString = letter.toString();
        
        if (letterLower >= 'a' && letterLower <= 'z') {
            if (letterString.matches("a|e|i|o|u|y"))
                System.out.println(letter + " is a vowel");
            else
                System.out.println(letter + " is a consonant");
        }
        else
            System.out.println(letter + " is an invalid input");
    }
}