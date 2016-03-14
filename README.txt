# 4120PA1
The purpose of this assignment is to compare different sort algorithms performance with different data set sizes.

To compile use:
$make all

----------------------------------------------------------------------------------------------

To run, use any of the following:
$java InsertionSortTest "filename"
$java MergeSortTest "filename"
$java -Xss8m QuickSortTest "filename"
$java -Xss8m RandQuickSortTest "filename"

"filename" should be a path to a .txt file with an integer on each line.
To see an example of proper input, examine the files in the data folder.
Each time the program is run, there will be an output to both the console and 'output.csv'.
The output will be in the format of "Size, Comparisons, Time(in ms)" (e.g.) "10000, 9999, 21".

*Be sure to add the "-Xss8m" to both quicksorts to avoid a stack overflow.*

-----------------------------------------------------------------------------------------------

To clean up use:
$make clean

This will remove all .class files and 'output.csv'.
*If you want to save 'output.csv', rename it or move it before running the command.*
