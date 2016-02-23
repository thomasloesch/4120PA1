import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class InsertionSortTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> numArray = retriveValues(args[0]);
		
		Iterator<Integer> iterator = numArray.iterator();
		
		int i = 0;
		while (iterator.hasNext()) {
			System.out.println(i++ + " " + iterator.next());
		}
	}
	
	public void insertionSort(ArrayList<Integer> A) {
		
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
