import java.util.ArrayList;
import java.util.Date;

public class QuickSortTest {
	public static int comparisons;

	public static void main(String[] args) {
		ArrayList<Integer> numArray = InsertionSortTest.retriveValues(args[0]);

		comparisons = 0;
		Date before = new Date();
		quickSort(numArray, 0, numArray.size() - 1);
		Date after = new Date();
		
		InsertionSortTest.displayValues(numArray, comparisons, after.getTime() - before.getTime());
	}
	
	public static void quickSort(ArrayList<Integer> A, int p, int r) {
		if (p < r) {
			int q = partition(A, p, r);
			quickSort(A, p, q - 1);
			quickSort(A, q + 1, r);
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
	
	public static void swap(ArrayList<Integer> A, int x, int y) {
		int temp = A.get(x);
		A.set(x, A.get(y));
		A.set(y, temp);
	}

}
