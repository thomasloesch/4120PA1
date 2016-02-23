import java.util.ArrayList;


public class RandQuickSortTest {

	public static void main(String[] args) {
		ArrayList<Integer> numArray = InsertionSortTest.retriveValues(args[0]);
		
		QuickSort(numArray, 0, numArray.size() - 1);

		InsertionSortTest.displayValues(numArray);
	}

	public static void QuickSort(ArrayList<Integer> A, int p, int r) {
		
	}
	
	public static void partition(ArrayList<Integer> A, int p, int r) {
		
	}
}
