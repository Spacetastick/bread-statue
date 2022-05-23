package chapter11;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise11_13 {

	public static void removeDuplicate(ArrayList<Integer> list) {
		ArrayList<Integer> duplicateIndeces = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			for (int j = i+1; j < list.size(); j++) {
				if (list.get(i) == list.get(j))
					duplicateIndeces.add(j);
			}
		}
		
		ArrayList<Integer> newList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			boolean dupe = false;
			for (Integer index : duplicateIndeces) {
				if (index == i) {
					dupe = true;
					break;
				}
			}
			if (!dupe)
				newList.add(list.get(i));
		}

		//not sure why doing list = newList; doesn't work
		list.clear();
		list.addAll(newList);
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		
		System.out.print("Enter ten integers: ");
		for (int i = 0; i < 10; i++)
			list.add(input.nextInt());
		
		removeDuplicate(list);
		System.out.print("The distinct integers are ");
		for (Integer num : list)
			System.out.print(num + " ");
	}
	
}
