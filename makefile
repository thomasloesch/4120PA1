JCC = javac
JFLAGS = -g -d ./
VPATH = src:/src
OUTFILE = output.csv

.SUFFIXES: .java .class .txt .csv

all: InsertionSortTest.class MergeSortTest.class QuickSortTest.class RandQuickSortTest.class

InsertionSortTest.class: InsertionSortTest.java
	@$(JCC) $(JFLAGS) $^

MergeSortTest.class: MergeSortTest.java InsertionSortTest.java
	@$(JCC) $(JFLAGS) $^

QuickSortTest.class: QuickSortTest.java InsertionSortTest.java
	@$(JCC) $(JFLAGS) $^

RandQuickSortTest.class: RandQuickSortTest.java QuickSortTest.java InsertionSortTest.java
	@$(JCC) $(JFLAGS) $^

clean:
	@$(RM) *.class
	@$(RM) $(OUTFILE)
