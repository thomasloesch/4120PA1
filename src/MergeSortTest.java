import java.util.ArrayList;
import java.util.Date;

public class MergeSortTest {
	public static long comparisons;

	public static void main(String[] args) {
		ArrayList<Integer> numArray = InsertionSortTest.retriveValues(args[0]);
		
		comparisons = 0;
		ArrayList<Integer> testArray = new ArrayList<Integer>(numArray);
		mergeSortComparison(testArray, 0, testArray.size() - 1);
		
		testArray = new ArrayList<Integer>(numArray);
		Date before = new Date();
		mergeSort(testArray, 0, testArray.size() - 1);
		Date after = new Date();
		
		InsertionSortTest.displayValues(numArray, comparisons, after.getTime() - before.getTime());
	}

	public static void mergeSort(ArrayList<Integer> A, int p, int r) {
		if(p < r) {
			int q = (int) Math.floor((p + r)/ 2);
			mergeSort(A, p, q);
			mergeSort(A, q + 1, r);
			merge(A, p, q, r);
		}
	}
	
	public static void mergeSortComparison(ArrayList<Integer> A, int p, int r) {
		if(p < r) {
			int q = (int) Math.floor((p + r)/ 2);
			mergeSortComparison(A, p, q);
			mergeSortComparison(A, q + 1, r);
			mergeComparison(A, p, q, r);
		}
	}
	
	public static void merge(ArrayList<Integer> A, int p, int q, int r) {
		int n1 = q - p + 1,
			n2 = r - q,
			L[] = new int[n1 + 1],
			R[] = new int[n2 + 1],
			i, j;
		
		for(i = 0; i < n1; ++i) 
			L[i] = A.get(p + i);
		for(j = 0; j < n2; ++j)
			R[j] = A.get(q + j + 1);
		
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		i = 0;
		j = 0;
		
		for(int k = p; k <= r; ++k) {
			if(L[i] <= R[j]) {
				A.set(k, L[i]);
				++i;
			}
			else {
				A.set(k, R[j]);
				++j;
			}
		}
	}
	
	public static void mergeComparison(ArrayList<Integer> A, int p, int q, int r) {
		int n1 = q - p + 1,
			n2 = r - q,
			L[] = new int[n1 + 1],
			R[] = new int[n2 + 1],
			i, j;
		
		for(i = 0; i < n1; i++) 
			L[i] = A.get(p + i);
		for(j = 0; j < n2; j++)
			R[j] = A.get(q + j + 1);
		
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		i = 0;
		j = 0;
		
		for(int k = p; k <= r; k++) {
			if(L[i] <= R[j]) {
				A.set(k, L[i]);
				i++;
			}
			else {
				A.set(k, R[j]);
				j++;
			}
			comparisons++;
		}
	}
}
