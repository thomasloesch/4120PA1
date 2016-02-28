import java.util.ArrayList;
import java.util.Random;

public class RandQuickSortTest {
	public static int comparisons;

	public static void main(String[] args) {
		ArrayList<Integer> numArray = InsertionSortTest.retriveValues(args[0]);
		
		int time = 0;
		comparisons = 0;
		randQuickSort(numArray, 0, numArray.size() - 1);

		InsertionSortTest.displayValues(numArray, comparisons, time);
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
