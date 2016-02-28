import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class RandQuickSortTest {
	public static int comparisons;

	public static void main(String[] args) {
		ArrayList<Integer> numArray = InsertionSortTest.retriveValues(args[0]);
		
		comparisons = 0;
		Date before = new Date();
		randQuickSort(numArray, 0, numArray.size() - 1);
		Date after = new Date();

		InsertionSortTest.displayValues(numArray, comparisons, after.getTime() - before.getTime());
	}

	public static void randQuickSort(ArrayList<Integer> A, int p, int r) {
		if (p < r) {
			int q = randPartition(A, p, r);
			randQuickSort(A, p, q - 1);
			randQuickSort(A, q + 1, r);
		}
	}
	
	public static int randPartition(ArrayList<Integer> A, int p, int r) {
		Random rand = new Random();
		int i = rand.nextInt(r - p) + p;
		QuickSortTest.swap(A, r, i);
		return QuickSortTest.partition(A, p, r);
	}
}
