JCC = javac
JFLAGS = -g
VPATH = src

all: InsertionSortTest.class MergeSortTest.class QuickSortTest.class RandQuickSortTest.class

InsertionSortTest.class: InsertionSortTest.java
	$(JCC) $(JFLAGS) InsertionSortTest.java

MergeSortTest.class: MergeSortTest.java
	$(JCC) $(JFLAGS) MergeSortTest.java

QuickSortTest.class: QuickSortTest.java
	$(JCC) $(JFLAGS) QuickSortTest.java

RandQuickSortTest.class: RandQuickSortTest.java
	$(JCC) $(JFLAGS) RandQuickSortTest.java

clean:
	$(RM) *.class

run: default
	java InsertionSortTest ../data/10kRand.txt
	java MergeSortTest ../data/10kRand.txt
	java QuickSortTest ../data/10kRand.txt
	java RandQuickSortTest ../data/10kRand.txt
