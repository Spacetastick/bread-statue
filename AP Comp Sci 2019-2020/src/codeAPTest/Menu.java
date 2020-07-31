package codeAPTest;

import java.util.ArrayList;

public class Menu {
	private ArrayList<Food> foodList;
	
	
	//ANSWER FOR A
	public String getMostChildChoices(String cat1, String cat2) {
		int cat1CF = 0;
		int cat2CF = 0;
		
		for (int i = 0; i < foodList.size(); i++) {
			if (foodList.get(i).isChildFriendly()) {
				if (foodList.get(i).getCategory().equals(cat1)) {
					cat1CF++;
				}
				else if (foodList.get(i).getCategory().equals(cat2)) {
					cat2CF++;
				}
			}
		}
		
		if (cat1CF > cat2CF) {
			return cat1;
		}
		else if (cat2CF > cat1CF) {
			return cat2;
		}
		else if (cat1CF == 0 && cat2CF == 0) {
			return "";
		}
		else {
			return cat1 + " or " + cat2;
		}
	}
	
	//ANSWER FOR B
	public int[] categoryCounts(String[] foodCategories) {
		int[] count = new int[foodCategories.length];
		
		for (int i = 0; i < foodCategories.length; i++) {
			for (int j = 0; j < foodList.size(); j++) {
				String category = foodList.get(j).getCategory();
				if (category.equals(foodCategories[i])) {
					count[i] += 1;
				}
			}
		}
		return count;
	}
	
	//ANSWER FOR C
	/*
		public Food leastExpensiveChildFriendly() would be the method header
		
		In order to integrate this new method into the Menu class, a price variable
		would have to be added to the Food class and the constructor for the Food objects
		in the Food class.
		The new price variable would be integrated as a private variable of type double,
		and its implementation would be something like: private double price;
		For the change in the food constructor, since it is not shown in the prompt I assume
		it would currently look something like this:
		public Food(String category, boolean childFriendly)
		After adding the price variable the constructor would need to be modified similar
		to this: public Food(String category, boolean childFriendly, double price)
		And then the variable of the food object would have to be initialized with the rest
		of the variables (example: this.price = price;)
		
		These two changes are the only ones required in order to implement this new method,
		as the check for food being child friendly is already in place, so I would be able
		to go through the arraylist in the menu and check each food item for its price and
		if it is child friendly in order to return the least expensive child friendly item.
	 */
}
