package chapter7;

import java.util.Scanner;
import java.util.Arrays;

public class Exercise07_19 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter list: ");
		
		int[] list = new int[input.nextInt()];
		for (int i = 0; i < list.length; i++)
			list[i] = input.nextInt();
		
		int[] sorted = list.clone();
		Arrays.sort(sorted);
		if (Arrays.equals(sorted, list))
			System.out.print("The list is already sorted");
		else
			System.out.println("The list is not sorted");
		
	}

}
