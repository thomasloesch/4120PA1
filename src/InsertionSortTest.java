import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class InsertionSortTest {
	public static long comparisons;

	public static void main(String[] args) {
		ArrayList<Integer> numArray = retriveValues(args[0]);
		
		
		comparisons = 0;
		insertionSortComparisons(numArray);
		Date before = new Date();
		insertionSort(numArray);
		Date after = new Date();
		
		displayValues(numArray, comparisons, after.getTime() - before.getTime());
	}

	public static void displayValues(ArrayList<Integer> A, long c, long t) {
		System.out.println(A.size() + ", " + c + ", " + t);
	}
	
	public static void displayValues(ArrayList<Integer> A) {
		Iterator<Integer> iterator = A.iterator();
		
		int i = 0;
		while (iterator.hasNext()) {
			System.out.println(i++ + " " + iterator.next());
		}
	}
	
	public static void insertionSort(ArrayList<Integer> A) {
		int i;
		int key;
		for(int j = 1; j < A.size(); j++) {
			key = A.get(j);
			i = j - 1;
			while(i >= 0 && A.get(i) > key) {
				A.set(i + 1, A.get(i));
				i = i - 1;
			}
			A.set(i + 1, key);
		}
	}
	
	public static void insertionSortComparisons(ArrayList<Integer> A) {
		int i;
		int key;
		for(int j = 1; j < A.size(); j++) {
			key = A.get(j);
			i = j - 1;
			while(i >= 0 && A.get(i) > key) {
				if(A.get(i) > key) {
					A.set(i + 1, A.get(i));
					i = i - 1;
				}
				comparisons++;
			}
			A.set(i + 1, key);
		}
	}
	
	public static ArrayList<Integer> retriveValues(String path) {
		ArrayList<Integer> values = new ArrayList<Integer>(10000);
		File file = new File(path);
		
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				values.add(Integer.parseInt(scan.nextLine()));
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return values;
	}
}
