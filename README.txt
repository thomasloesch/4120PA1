# 4120PA1
The purpose of this assignment is to compare different sort algorithms performance with different data set sizes.

To compile use:
$make all

To run use:
$java InsertionSortTest "filename"
$java MergeSortTest "filename"
$java -Xss8m QuickSortTest "filename"
$java -Xss8m RandQuickSortTest "filename"

Where "filename" is the input file.
Results will be output to "output.csv".

Be sure to add the "-Xss8m" to both quicksorts to avoid a stack overflow.

To clean up use:
$make clean
