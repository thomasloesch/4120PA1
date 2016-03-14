/*
 * WRITTEN BY:	Thomas Loesch
 * DATE:		03/14/16
 * FILE NAME:	InsertionSortTest.java
 * DESCRIPTION: This file allows the user to test an input using an insertion sort.
 * INPUT:       A path to a .txt file with a number to be sorted on each line.
 * OUTPUT:		This program outputs both to the console and 'output.csv'.
 * 				The output is formatted as 'Size of input, # of comparisons, time of execution in ms'.
 * 				E.g '10000, 9999, 21'
 */

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
		ArrayList<Integer> numArray, testArray;
		FileWriter writer;
		Date before, after;
		long totalTime;
		
		try{
			// Output to output.csv w/o destroying existing data
			writer = new FileWriter("output.csv", true);
			
			// Fill numArray with values from the input file
			numArray = retriveValues(args[0]);
			
			// Make a testArray with the unsorted values from numArray
			testArray = new ArrayList<Integer>(numArray);
			comparisons = 0;
			insertionSortComparisons(testArray); // Get number of comparisons
			
			// Reset testArray back to being unsorted
			testArray = new ArrayList<Integer>(numArray);
			before = new Date(); // Get the time before testing
			insertionSort(testArray); // Test for time
			after = new Date();  // Get the time after testing
			
			// Calculate time of sort
			totalTime = after.getTime() - before.getTime();
				
			// Output values to file
			writer.append("Insertion Sort,");
			displayValues(numArray, comparisons, totalTime, writer);
			
			// Output values to console
			displayValues(numArray, comparisons, totalTime);
			
			// Close the output file
			writer.flush();
			writer.close();
		}
		catch (IOException e) {
			System.out.println("Something went wrong.");
			System.out.println("Make sure 'output.csv' is closed and your input file exists.");
		}
	}

	// Writes passed values to the file specified by the passed FileWriter object
	public static void displayValues(ArrayList<Integer> A, long c, long t, FileWriter writer) {
		try{
			writer.append(Integer.toString(A.size()));
			writer.append(",");
			writer.append(Long.toString(c));
			writer.append(",");
			writer.append(Long.toString(t));
			writer.append("\n");
		}
		catch (IOException e) {
			System.out.println("Could not print to 'output.csv', please make sure the file is closed.");
		}
	}

	// Displays passed values to console
	public static void displayValues(ArrayList<Integer> A, long c, long t) {
		System.out.println(A.size() + ", " + c + ", " + t);
	}
	
	// Displays the contents of the passed ArrayList to console.
	public static void displayValues(ArrayList<Integer> A) {
		Iterator<Integer> iterator = A.iterator();
		
		int i = 0;
		while (iterator.hasNext()) {
			System.out.println(i++ + " " + iterator.next());
		}
	}
	
	// Sorts the passed ArrayList in ascending order
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
	
	// Sorts the passed ArrayList in ascending order while tracking the number of comparisons in the global variable 'comparisons'
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
	
	// Returns an ArrayList<Integer> with the values from the file located at the passed String
	public static ArrayList<Integer> retriveValues(String path) {
		ArrayList<Integer> values = new ArrayList<Integer>(10000);
		File file = new File(path);
		
		try {
			Scanner scan = new Scanner(file);
			
			while (scan.hasNextLine()) 
				values.add(Integer.parseInt(scan.nextLine()));
			
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("There was an issue with your input file.");
			System.out.println("Please make sure the file exists and is formatted correctly.");
		}
		
		return values;
	}
}
