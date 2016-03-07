import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class InsertionSortTest {
	public static long comparisons;

	public static void main(String[] args) {
		ArrayList<Integer> numArray;
		try{
			FileWriter writer = new FileWriter("output.csv", true);
			
			numArray = retriveValues(args[0]);
			
			ArrayList<Integer> testArray = new ArrayList<Integer>(numArray);
			comparisons = 0;
			insertionSortComparisons(testArray);
			
			testArray = new ArrayList<Integer>(numArray);
			Date before = new Date();
			insertionSort(testArray);
			Date after = new Date();
				
			writer.append("Insertion Sort,");
			displayValuesFile(testArray, comparisons, after.getTime() - before.getTime(), writer);
			
			writer.flush();
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void displayValuesFile(ArrayList<Integer> A, long c, long t, FileWriter writer) {
		try{
			writer.append(Integer.toString(A.size()));
			writer.append(",");
			writer.append(Long.toString(c));
			writer.append(",");
			writer.append(Long.toString(t));
			writer.append("\n");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
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
			while(i >= 0) {
				comparisons++;
				if(A.get(i) > key) {
					A.set(i + 1, A.get(i));
				}
				else
					break;
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
