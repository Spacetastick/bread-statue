package chapter5;

import java.util.Scanner;

public class Exercise05_09 {

	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter the number of students: ");
		int numStudents = input.nextInt();
		
		String[] names = new String[numStudents];
		int[] scores = new int[numStudents];
		
		for (int i = 0; i < numStudents; i++) {
			System.out.println("Enter a student name: ");
			names[i] = input.next();
			System.out.println("enter a student score: ");
			scores[i] = input.nextInt();
		}
		
		int topScore = 0;
		int topScoreIndex = 0;
		int runnerUp = 0;
		int runnerUpIndex = 0;
		for (int i = 0; i < numStudents; i++) {
			int tempScore;
			int tempIndex;
			if (scores[i] > topScore) {
				tempScore = topScore;
				tempIndex = topScoreIndex;
				
				topScore = scores[i];
				topScoreIndex = i;
				
				if (tempScore > runnerUp) {
					runnerUp = tempScore;
					runnerUpIndex = tempIndex;
				}
			}
			else if (scores[i] > runnerUp) {
				runnerUp = scores[i];
				runnerUpIndex = i;
			}
		}
		
		System.out.println("Top two students:");
		System.out.println(names[topScoreIndex] + "'s score is " + (double)scores[topScoreIndex]);
		System.out.println(names[runnerUpIndex] + "'s score is " + (double)scores[runnerUpIndex]);
		
	}
	
}
