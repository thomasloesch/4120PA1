/*
 * WRITTEN BY:	Thomas Loesch
 * DATE:		03/14/16
 * FILE NAME:	RandQuickSortTest.java
 * DESCRIPTION: This file allows the user to test an input using a quick sort(using a random index as the pivot).
 * INPUT:       A path to a .txt file with a number to be sorted on each line.
 * OUTPUT:		This program outputs both to the console and 'output.csv'.
 * 				The output is formatted as 'Size of input, # of comparisons, time of execution in ms'.
 * 				E.g '10000, 9999, 21'
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class RandQuickSortTest {
	public static long comparisons;
	public static Random rand;

	public static void main(String[] args) {
		// Declarations
		ArrayList<Integer> numArray;
		FileWriter writer;
		Date before, after;
		long totalTime;
		
		try {
			// Output to output.csv w/o destroying existing data
			writer = new FileWriter("output.csv", true);
			
			// Fill numArray with values from the input file
			numArray = InsertionSortTest.retriveValues(args[0]);
			
			rand = new Random();
			
			comparisons = 0;
			before = new Date();								// Get the time before testing
			randQuickSort(numArray, 0, numArray.size() - 1);	// Test for time and comparisons
			after = new Date();									// Get the time after testing
			
			// Calculate time of sort
			totalTime = after.getTime() - before.getTime();
			
			// Output values to file
			writer.append("Rand Quick Sort,");
			InsertionSortTest.displayValues(numArray, comparisons, totalTime, writer);
			
			// Output values to console
			InsertionSortTest.displayValues(numArray, comparisons, totalTime);
			
			// Close the output file
			writer.flush();
			writer.close();
		}
		catch(IOException e) {
			System.out.println("Something went wrong.");
			System.out.println("Make sure 'output.csv' is closed and your input file exists.");
		}
	}

	// Sorts the passed ArrayList in ascending order
	public static void randQuickSort(ArrayList<Integer> A, int p, int r) {
		if (p < r) {
			int q = randPartition(A, p, r);
			randQuickSort(A, p, q - 1);
			randQuickSort(A, q + 1, r);
		}
	}
	
	// Used by randQuickSort to find and arrange the passed ArrayList around a pivot point (a random index)
	public static int randPartition(ArrayList<Integer> A, int p, int r) {
		int i = rand.nextInt(r - p) + p;
		QuickSortTest.swap(A, r, i);
		return partition(A, p, r);
	}
	
	// Wrapped by randPartition
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
