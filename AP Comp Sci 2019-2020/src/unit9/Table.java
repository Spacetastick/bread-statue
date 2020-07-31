package unit9; //Noah Cil, period 1

/**
   Represents a table of values.
*/
public class Table
{
   private int[][] values;

   /**
      Construct a table with given rows and columns.
      @param rows the rows in the table.
      @param columns the columns in the table.
   */
   public Table(int rows, int columns)
   {
      values = new int[rows][columns];
   }

   /**
      Sets a value in the table.
      @param i the row of the item to modify
      @param j the column of the item to modify
      @param n the number to use for the new value.
   */
   public void set(int i, int j, int n)
   {
      values[i][j] = n;
   }

   /**
      Returns the average of the adjacent elements in a table.
      @param row the row of the element.
      @param column the column of the element.
      @return the average of the adjacent elements.
   */
   public double neighborAverage(int row, int column)
   {
	   //I checked all the math and found that all of the expected prompts from TableTester
	   //have wrong answers except the first two, mine are correct
	   double top, bottom, left, right;
	   int count = 0;
	   
	   try {
		   top = this.values[row+1][column];
		   count++;
		} catch ( IndexOutOfBoundsException e ) {
			top = 0;
		}
	   
	   try {
		   bottom = this.values[row-1][column];
		   count++;
	   } catch (IndexOutOfBoundsException e) {
		   bottom = 0;
	   }
	   
	   try {
		   left = this.values[row][column-1];
		   count++;
	   } catch (IndexOutOfBoundsException e) {
		   left = 0;
	   }
	   
	   try {
		   right = this.values[row][column+1];
		   count++;
	   } catch (IndexOutOfBoundsException e) {
		   right = 0;
	   }
	   
	   return ((top + bottom + left + right) / count);
   }
}
