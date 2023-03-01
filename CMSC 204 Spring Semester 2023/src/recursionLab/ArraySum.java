package recursionLab;

public class ArraySum {
	
	public int sumOfArray(Integer[] a, int index) {
		int sum = a[index];
		if (index > 0)
			sum += sumOfArray(a, index-1);
		return sum;
		
	}
	
}
