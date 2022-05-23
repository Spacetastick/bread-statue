package chapter7;

import java.util.Scanner;
import java.util.Arrays;

public class Exercise07_05 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int numDistinct = 0;
		int[] nums = new int[10];
		Arrays.fill(nums, -1);
		
		System.out.print("Enter ten numbers: ");
		
		for (int i = 0; i < 10; i++) {
			int temp = input.nextInt();
			boolean broken = false;
			
			for (int j = 0; j < 10; j++) {
				if (temp == nums[j]) { 
					broken = true;
					break;
				}
			}
			
			if (!broken) {
				nums[i] = temp;
				numDistinct++;
			}
		}
		
		System.out.println("The number of distinct numbers is " + numDistinct);
		System.out.print("The distinct numbers are: ");
		for (int num : nums) {
			if (num != -1)
				System.out.print(num + " ");
		}
		
	}
	
}
