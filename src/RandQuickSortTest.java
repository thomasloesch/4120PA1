import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class RandQuickSortTest {
	public static long comparisons;
	public static Random rand;

	public static void main(String[] args) {
		ArrayList<Integer> numArray = InsertionSortTest.retriveValues(args[0]);
		
		comparisons = 0;
		rand = new Random();
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
		int i = rand.nextInt(r - p) + p;
		QuickSortTest.swap(A, r, i);
		return partition(A, p, r);
	}
	
	public static int partition(ArrayList<Integer> A, int p, int r) {
		int x = A.get(r);
		int i = p - 1;
		for(int j = p; j < r; j++) {
			if(A.get(j) <= x){
				i++;
				QuickSortTest.swap(A, i, j);
			}
			comparisons++;
		}
		QuickSortTest.swap(A, i + 1, r);
		return i + 1;
	}
}
