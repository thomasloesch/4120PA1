# 4120PA1
The purpose of this assignment is to compare different sort algorithms performance with different data set sizes.

To compile use:
$make all

To run use:
$java InsertionSortTest "filename"
$java MergeSortTest "filename"
$java -Xss6m QuickSortTest "filename"
$java -Xss6m RandQuickSortTest "filename"

Be sure to add the "-Xss6m" to both quicksorts to avoid a stack overflow.

To clean up use:
$make clean
