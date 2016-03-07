import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class QuickSortTest {
	public static long comparisons;

	public static void main(String[] args) {
		ArrayList<Integer> numArray = InsertionSortTest.retriveValues(args[0]);

		try{
			FileWriter writer = new FileWriter("output.csv", true);
			
			comparisons = 0;
			ArrayList<Integer> testArray = new ArrayList<Integer>(numArray);
			quickSortComparison(testArray, 0, testArray.size() - 1);
			
			testArray = new ArrayList<Integer>(numArray);
			Date before = new Date();
			quickSort(testArray, 0, testArray.size() - 1);
			Date after = new Date();
			
			writer.append("Quick Sort,");
			InsertionSortTest.displayValues(numArray, comparisons, after.getTime() - before.getTime(), writer);
			
			writer.flush();
			writer.close();
		}
		catch (IOException e) {
			
		}
		//InsertionSortTest.displayValues(testArray);
	}
	
	public static void quickSort(ArrayList<Integer> A, int p, int r) {
		if (p < r) {
			int q = partition(A, p, r);
			quickSort(A, p, q - 1);
			quickSort(A, q + 1, r);
		}
	}
	
	public static void quickSortComparison(ArrayList<Integer> A, int p, int r) {
		if (p < r) {
			int q = partitionComparison(A, p, r);
			quickSortComparison(A, p, q - 1);
			quickSortComparison(A, q + 1, r);
		}
	}
	
	public static int partition(ArrayList<Integer> A, int p, int r) {
		int x = A.get(r);
		int i = p - 1;
		for(int j = p; j < r; j++) {
			if(A.get(j) <= x){
				i++;
				swap(A, i, j);
			}
		}
		swap(A, i + 1, r);
		return i + 1;
	}
	
	public static int partitionComparison(ArrayList<Integer> A, int p, int r) {
		int x = A.get(r);
		int i = p - 1;
		for(int j = p; j < r; j++) {
			if(A.get(j) <= x){
				i++;
				swap(A, i, j);
			}
			comparisons++;
		}
		swap(A, i + 1, r);
		return i + 1;
	}
	
	public static void swap(ArrayList<Integer> A, int x, int y) {
		int temp = A.get(x);
		A.set(x, A.get(y));
		A.set(y, temp);
	}

}
