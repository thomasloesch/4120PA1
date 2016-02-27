JCC = javac
JFLAGS = -g
VPATH = src

srcdir = src/

all: InsertionSortTest.class MergeSortTest.class QuickSortTest.class RandQuickSortTest.class

InsertionSortTest.class: InsertionSortTest.java
	$(JCC) $(JFLAGS) $(srcdir)InsertionSortTest.java

MergeSortTest.class: MergeSortTest.java
	$(JCC) $(JFLAGS) $(srcdir)MergeSortTest.java

QuickSortTest.class: QuickSortTest.java
	$(JCC) $(JFLAGS) $(srcdir)QuickSortTest.java

RandQuickSortTest.class: RandQuickSortTest.java
	$(JCC) $(JFLAGS) $(srcdir)RandQuickSortTest.java

clean:
	$(RM) *.class

run: all
	java InsertionSortTest data/10kRand.txt
	java MergeSortTest data/10kRand.txt
	java QuickSortTest data/10kRand.txt
	java RandQuickSortTest data/10kRand.txt
