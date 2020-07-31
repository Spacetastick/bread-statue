package miscellaneous;

public class ForLoopReview {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, -6, -7, -8};
		double[] arr2 = {1.0, 2.3, 4.76, -3.1};
		int max = arr[0];
		int count = 0;
		double total = 0;
		double target = 4.76;
		boolean matches = false;
		
//Part One: Write enhanced for loops for the following tasks.
		for (int i : arr) {
			//Printing all elements of an array in a single row, separated by spaces.
			System.out.print(i + " ");
			// Computing the maximum of all elements in an array.
			if (i > max) {
				max = i;
			}
			//Counting how many elements in an array are negative.
			if (i < 0) {
				count++;
			}
		}
		System.out.println();
		System.out.println("max of array is: " + max);
		System.out.println("There are " + count + " negative numbers in array");
		
//Part Two: Rewrite the following loops without using the enhanced forloop construct. Here, values is an array of doubles.
		//for (double x : values) { total = total + x; }
		for (int i = 0; i < arr2.length; i++) {
			total += arr2[i];
		}
		System.out.println("Total is: " + total);
		//for (double x : values) { if (x == target) { return true; } }
		for (int i = 0; i < arr2.length; i ++) { 
			if (arr2[i] == target) {
				matches = true; //using boolean in place of returning value
			}
		}
		System.out.println("matches is: " + matches);
		/*
		int i = 0; 
		for (double x : values) {
	                values [i] = 2 * x;
	                 i++;
	        }
		*/
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = 2 * arr2[i];
			System.out.print(arr2[i] + " ");
		}
		System.out.println();
//Part Three: Rewrite the following loops using the enhanced for loop construct. Here, values is an array of doubles.
		//for (int i = 0; i < values.length; i++) { total = total + values[i]; }
		total = 0;
		for (double i : arr2) {
			total += i;
		}
		System.out.println(total);
		//for (int i = 1; i < values.length; i++) { total = total + values[i]; }
		total = 0;
		for (double i : arr2) {
			if (i == arr2[0]) {
				total -= i;
			}
			total += i;
		}
		System.out.println(total);
		/*
		for (int i = 0; i < values.length; i++){
        if (values[i] == target) { return i; }
        }
		 */
		for (double i : arr2) {
			if (i == target) {
				matches = true; //using boolean in place of returning value to make code run
			}
			else {
				matches = false;
			}
		}
		System.out.println("matches is: " + matches);
	}
	
}
