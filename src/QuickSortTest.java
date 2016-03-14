/*
 * WRITTEN BY:	Thomas Loesch
 * DATE:		03/14/16
 * FILE NAME:	QuickSortTest.java
 * DESCRIPTION: This file allows the user to test an input using a quick sort(using the middle index as the pivot).
 * INPUT:       A path to a .txt file with a number to be sorted on each line.
 * OUTPUT:		This program outputs both to the console and 'output.csv'.
 * 				The output is formatted as 'Size of input, # of comparisons, time of execution in ms'.
 * 				E.g '10000, 9999, 21'
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class QuickSortTest {
	public static long comparisons;

	public static void main(String[] args) {
		// Declarations
		ArrayList<Integer> numArray, testArray;
		FileWriter writer;
		Date before, after;
		long totalTime;
		
		try{
			// Output to output.csv w/o destroying existing data
			writer = new FileWriter("output.csv", true);
			
			// Fill numArray with values from the input file
			numArray = InsertionSortTest.retriveValues(args[0]);
			
			// Make a testArray with the unsorted values from numArray
			testArray = new ArrayList<Integer>(numArray);
			comparisons = 0;
			quickSortComparison(testArray, 0, testArray.size() - 1); // Get number of comparisons
			
			// Reset testArray back to being unsorted
			testArray = new ArrayList<Integer>(numArray);
			before = new Date();						// Get the time before testing
			quickSort(testArray, 0, testArray.size() - 1);	// Test for time
			after = new Date();						// Get the time after testing
			
			// Calculate time of sort
			totalTime = after.getTime() - before.getTime();
			
			// Output values to file
			writer.append("Quick Sort,");
			InsertionSortTest.displayValues(numArray, comparisons, totalTime, writer);
			
			// Output values to console
			InsertionSortTest.displayValues(numArray, comparisons, totalTime);
						
			// Close the output file
			writer.flush();
			writer.close();
		}
		catch (IOException e) {
			System.out.println("Something went wrong.");
			System.out.println("Make sure 'output.csv' is closed and your input file exists.");
		}
	}
	
	// Sorts the passed ArrayList in ascending order
	public static void quickSort(ArrayList<Integer> A, int p, int r) {
		if (p < r) {
			int q = partition(A, p, r);
			quickSort(A, p, q - 1);
			quickSort(A, q + 1, r);
		}
	}
	
	// Sorts the passed ArrayList in ascending order while tracking the number of comparisons in the global variable 'comparisons'
	public static void quickSortComparison(ArrayList<Integer> A, int p, int r) {
		if (p < r) {
			int q = partitionComparison(A, p, r);
			quickSortComparison(A, p, q - 1);
			quickSortComparison(A, q + 1, r);
		}
	}
	
	// Used by quickSort to find and arrange the passed ArrayList around a pivot point (the middle index)
	public static int partition(ArrayList<Integer> A, int p, int r) {
		swap(A, p + ((r - p) / 2), r); // swap the middle value to the end
		int x = A.get(r);
		int i = p - 1;
		for(int j = p; j < r; j++) {
			if(A.get(j) <= x){
				i++;
				swap(A, i, j);
			}
		}
		swap(A, i + 1, r);
		return i + 1;
	}
	
	// Used by quickSortComparison to find and arrange the passed ArrayList around a pivot point (the middle index)
	public static int partitionComparison(ArrayList<Integer> A, int p, int r) {
		swap(A, p + ((r - p) / 2), r); // swap the middle value to the end
		int x = A.get(r);
		int i = p - 1;
		for(int j = p; j < r; j++) {
			if(A.get(j) <= x){
				i++;
				swap(A, i, j);
			}
			comparisons++;
		}
		swap(A, i + 1, r);
		return i + 1;
	}
	
	// Swaps the two indices (x and y) in passed ArrayList
	public static void swap(ArrayList<Integer> A, int x, int y) {
		int temp = A.get(x);
		A.set(x, A.get(y));
		A.set(y, temp);
	}

}
