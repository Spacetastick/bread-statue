package chapter3;
/*
(Science: day of the week) 
Zeller’s congruence is an algorithm developed by Christian Zeller to calculate the day of the week.
The formula is :
h = (q + 26(m+1)/10 + k + k/4 + j/4 + 5j) % 7
where
- h is the day of the week (0: Saturday, 1: Sunday, 2: Monday, 3: Tuesday, 4: Wednesday, 5: Thursday, 6: Friday).
- q is the day of the month.
- m is the month (3: March, 4: April, ..., 12: December). January and February are counted as months 13 and 14 of the previous year.
- j is the century (i.e., year/100)
- k is the year of the century (i.e., year%100).
Note that the division in the formula performs an integer division.
Write a program that prompts the user to enter a year, month, and day of the month, and displays the name of the day of the week.
Sample Run 1
Enter year: (e.g., 2012): 2015
Enter month: 1-12:  1
Enter the day of the month: 1-31: 25
Day of the week is Sunday
Sample Run 2
Enter year: (e.g., 2012): 2012
Enter month: 1-12: 5
Enter the day of the month: 1-31: 12
Day of the week is Saturday
Sample Run 3
Enter year: (e.g., 2012): 2002 
Enter month: 1-12: 3 
Enter the day of the month: 1-31: 26 
Day of the week is Tuesday
Sample Run 4
Enter year: (e.g., 2012): 2008 
Enter month: 1-12:  1
Enter the day of the month: 1-31: 1 
Day of the week is Tuesday 
Sample Run 5
Enter year: (e.g., 2012): 2000 
Enter month: 1-12: 2 
Enter the day of the month: 1-31: 12 
Day of the week is Saturday 
(Hint: January and February are counted as 13 and 14 in the formula, so you need to convert the user input 1 to 13 and 2 to 14 for the month and change the year to the previous year.)
Class Name: Exercise03_21
If you get a logical or runtime error, please refer https://liveexample.pearsoncmg.com/faq.html.
 */

import java.util.Scanner;

public class Exercise03_21 {
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Enter year: (e.g., 2012):");
        int year = scanner.nextInt();
        System.out.println("Enter month: 1-12:");
        int month = scanner.nextInt();
        System.out.println("Enter the day of the month: 1-31: ");
        int day = scanner.nextInt();
        
        if (month == 1 || month == 2) {
        	month = (month == 1) ? 13 : 14;
        	year--;
        }
        
        int yearOfCentury = year % 100;
        int century = year / 100;
        int dayOfWeek = (day + (26 * (month + 1))/10 + yearOfCentury + (yearOfCentury / 4) + (century / 4) + (century * 5)) % 7;
        
        switch (dayOfWeek) {
            case 0:
                System.out.println("Day of the week is Saturday");
                break;
            case 1:
                System.out.println("Day of the week is Sunday");
                break;
            case 2:
                System.out.println("Day of the week is Monday");
                break;
            case 3:
                System.out.println("Day of the week is Tuesday");
                break;
            case 4: 
                System.out.println("Day of the week is Wednesday");
                break;
            case 5:
                System.out.println("Day of the week is Thursday");
                break;
            case 6:
                System.out.println("Day of the week is Friday");
                break;
        }
    }
}