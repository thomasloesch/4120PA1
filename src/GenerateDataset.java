/*
 * Copyright 2015, Robert Dyer,
 *                 and Bowling Green State University
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class to generate datasets for use as input in Project 1 in CS 4120/5120.
 *
 * The main method expects 1 or 2 arguments.  If 1 argument is given, it outputs
 * a list of N (the argument) random integers, one per line.  If 2 arguments are
 * given, instead of random integers the second argument is used.
 *
 * The output can also be sorted by passing '-Dsorted=true' to java.
 * The output can also be reverse sorted by passing '-Dreversed=true' to java.
 * These flags work with both the 1 and 2 argument programs.
 *
 * Finally, everything is accessible and controllable from other Java classes
 * so that this program can be directly called.
 *
 * @author rdyer
 */
public class GenerateDataset {
	/** The maximum value to use when generating random numbers. */
	public static int MAX_VALUE = 1000000;
	/** If set, the output data will be sorted in increasing order. */
	public static boolean SORTED = false;
	/** If set, the output data will be sorted in decreasing order. */
	public static boolean REVERSE_SORTED = false;

	public static void main(final String[] args) {
		if (args.length == 0 || args.length > 2) {
			System.err.println("Usage: java [-Dsorted=true] [-Dreversed=true] GenerateDataset <size> [<value>]");
			System.err.println("");

			System.err.println("where\t<size>  is the number of integers to generate");
			System.err.println("\t<value> is the number to use instead of a random number");
			System.err.println("");

			System.err.println("set -Dsorted=true to sort the output");
			System.err.println("set -Dreversed=true to reverse sort the output");
			System.err.println("");

			System.err.println("Examples:");
			System.err.println("\tjava GenerateDataset 1000");
			System.err.println("\t-> random list of 1000 integers");			System.err.println("");

			System.err.println("\tjava –Dsorted=true GenerateDataset 1000");			System.err.println("\t-> random sorted list of 1000 integers");			System.err.println("");

			System.err.println("\tjava –Dreversed=true GenerateDataset 1000");			System.err.println("\t-> random reverse sorted list of 1000 integers");			System.err.println("");

			System.err.println("\tjava GenerateDataset 1000 1234");			System.err.println("\t-> the number 1234 repeated 1000 times");
			System.exit(-1);
		}

		parseOptions();

		// display the data, one per line
		for (final int i : generateData(args))
			System.out.println(i);
	}

	/**
	 * Check for -D flags on the command line.
	 */
	public static void parseOptions() {
		if (Boolean.parseBoolean(System.getProperty("sorted")))
			SORTED = true;
		if (Boolean.parseBoolean(System.getProperty("reversed")))
			REVERSE_SORTED = true;

		// only allow 1 to be set at a time
		if (SORTED && REVERSE_SORTED) {
			System.err.println("Error: Only one of -Dsorted and -Dreversed may be set at a time.");
			System.exit(-1);
		}
	}

	/**
	 * Generates the list of data based on the command-line options.
	 *
	 * @param args the command-line arguments given
	 * @return a list with 'size' integers in it, according to the options given
	 */
	public static List<Integer> generateData(final String[] args) {
		try {
			final List<Integer> values;
			final int size = Integer.parseInt(args[0]);

			// generate the list of data
			if (args.length == 1)
				values = randomData(size);
			else
				try {
					values = sameData(size, Integer.parseInt(args[1]));
				} catch (final NumberFormatException e) {
					System.err.println("Error: argument <value> must be a number");
					System.exit(-1);
					return Collections.<Integer>emptyList();
				}

			// optionally (reverse) sort the data
			if (SORTED || REVERSE_SORTED)
				Collections.sort(values);

			if (REVERSE_SORTED)
				Collections.reverse(values);

			return values;
		} catch (final NumberFormatException e) {
			System.err.println("Error: argument <size> must be a number");
			System.exit(-1);
			return Collections.<Integer>emptyList();
		}
	}

	/**
	 * Generates a list of random numbers.
	 *
	 * @param size the number of entries in the returned list
	 * @return a list with 'size' randomly generated integers in it
	 */
	public static List<Integer> randomData(final int size) {
		final List<Integer> output = new ArrayList<Integer>();

		for (int i = 0; i < size; i++)
			output.add((int)(Math.random() * MAX_VALUE));

		return output;
	}

	/**
	 * Generates a list of numbers all the same value.
	 *
	 * @param size the number of entries in the returned list
	 * @param value the value to use when generating the list
	 * @return a list with 'size' copies of 'value' in it
	 */
	public static List<Integer> sameData(final int size, final int value) {
		final List<Integer> output = new ArrayList<Integer>();

		for (int i = 0; i < size; i++)
			output.add(value);

		return output;
	}
}
