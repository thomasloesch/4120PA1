import java.util.ArrayList;

public class MergeSortTest {

	public static void main(String[] args) {
		ArrayList<Integer> numArray = InsertionSortTest.retriveValues(args[0]);
		
		mergeSort(numArray, 0, numArray.size() - 1);
		
		InsertionSortTest.displayValues(numArray);
	}

	public static void mergeSort(ArrayList<Integer> A, int p, int r) {
		
	}
	
	public static void merge(ArrayList<Integer> A, int p, int q, int r) {
		
	}
}
