import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class InsertionSortTest {
	public static int comparisons;

	public static void main(String[] args) {
		ArrayList<Integer> numArray = retriveValues(args[0]);
		
		
		comparisons = 0;
		Date before = new Date();
		insertionSort(numArray);
		Date after = new Date();
		
		displayValues(numArray, comparisons, after.getTime() - before.getTime());
	}

	public static void displayValues(ArrayList<Integer> A, int c, long t) {
		System.out.println(A.size() + ", " + c + ", " + t);
	}
	
	public static void insertionSort(ArrayList<Integer> A) {
		int i;
		int key;
		for(int j = 1; j < A.size(); j++) {
			key = A.get(j);
			i = j - 1;
			while(i >= 0 && A.get(i) > key) {
				comparisons++;
				A.set(i + 1, A.get(i));
				i = i - 1;
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
