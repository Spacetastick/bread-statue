package unit9;

public class ArrayReviewQuestions2D {

	private static final int ROWS = 5;
	private static final int COLUMNS = 5;
	
	private static boolean formatting = false;
	
	static int[][] values = new int[ROWS][COLUMNS];
	
	private static void setZero(int[][] array) {
		printDivider(array);
		
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[0].length; column++) {
				array[row][column] = 0;
			}
		}
	}
	
	private static void setCheckerboardPattern(int[][] array) {
		setZero(array);
		System.out.println("Fill elements alternately with 0s and 1s in a checkerboard pattern.");
		printDivider(array);
		
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[0].length; column++) {
				if ((row + column) % 2 == 0) {
					array[row][column] = 0;
				}
				else {
					array[row][column] = 1;
				}
			}
		}
		
		
	}
	
	private static void setNullTopAndBottom(int[][] array) {
		setZero(array);
		System.out.println("Fill only the elements in the top and bottom rows with zeroes.");
		printDivider(array);
		
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[0].length; column++) {
				if (row == 0 || row == array.length-1) {
					array[row][column] = 0;
				}
				else {
					array[row][column] = 1;
				}
			}
		}
	}
	
	private static void setNegativeFirstAndLast(int[][] array) {
		setZero(array);
		System.out.println("Fills the first and last columns as well as the first and last rows of a two-dimensional array of integers with -1");
		printDivider(array);
		
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[0].length; column++) {
				if (row == 0 || row == array.length-1) {
					array[row][column] = -1;
				}
				else if (column == 0 || column == array[0].length - 1){
					array[row][column] = -1;
				}
				else {
					array[row][column] = 0;
				}
			}
		}
		formatting = true;
	}
	
	private static void sumOfValues(int[][] array) {
		printDivider(array);
		
		int sum = 0;
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[0].length; column++) {
				sum += array[row][column];
			}
		}
		
		System.out.println("The sum of values is " + sum);
	}
	
	private static void print2DArray(int[][] array) {
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[0].length; column++) {
				if (formatting) {
					//so printing array with -1s has the columns line up properly
					if (array[row][column] == 0)  {
						System.out.print(array[row][column] + "  ");
					}
					else {
						System.out.print(array[row][column] + " ");
					}
				}
				else {
					System.out.print(array[row][column] + " ");
				}
			}
			System.out.println("");
		}
		formatting = false;
	}
	
	private static void printDivider(int[][] array) {
		for (int i = (array[0].length*2) -1; i > 0; i--) {
			System.out.print("-");
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		//part 1
		System.out.println("Fill all entries with 0.");
		setZero(values);
		print2DArray(values);
		setCheckerboardPattern(values);
		print2DArray(values);
		setNullTopAndBottom(values); 
		print2DArray(values);
		sumOfValues(values);
		
		//part 2
		setNegativeFirstAndLast(values);
		print2DArray(values);
	}
}