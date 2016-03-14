/*
 * WRITTEN BY:	Thomas Loesch
 * DATE:		03/14/16
 * FILE NAME:	MergeSortTest.java
 * DESCRIPTION: This file allows the user to test an input using a merge sort.
 * INPUT:       A path to a .txt file with a number to be sorted on each line.
 * OUTPUT:		This program outputs both to the console and 'output.csv'.
 * 				The output is formatted as 'Size of input, # of comparisons, time of execution in ms'.
 * 				E.g '10000, 9999, 21'
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class MergeSortTest {
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
			mergeSortComparison(testArray, 0, testArray.size() - 1); // Get number of comparisons
			
			// Reset testArray back to being unsorted
			testArray = new ArrayList<Integer>(numArray);
			before = new Date(); 						// Get the time before testing
			mergeSort(testArray, 0, testArray.size() - 1);	// Test for time
			after = new Date();						// Get the time after testing
			
			// Calculate time of sort
			totalTime = after.getTime() - before.getTime();
			
			// Output values to file
			writer.append("Merge Sort,");
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
	public static void mergeSort(ArrayList<Integer> A, int p, int r) {
		if(p < r) {
			int q = (int) Math.floor((p + r)/ 2);
			mergeSort(A, p, q);
			mergeSort(A, q + 1, r);
			merge(A, p, q, r);
		}
	}
	
	// Sorts the passed ArrayList in ascending order while tracking the number of comparisons in the global variable 'comparisons'
	public static void mergeSortComparison(ArrayList<Integer> A, int p, int r) {
		if(p < r) {
			int q = (int) Math.floor((p + r)/ 2);
			mergeSortComparison(A, p, q);
			mergeSortComparison(A, q + 1, r);
			mergeComparison(A, p, q, r);
		}
	}
	
	// Used by mergeSort to properly merge two sections of the passed array
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
	
	// Used by mergeSortComparison to properly merge two sections of the passed array
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
