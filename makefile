JCC = javac
JFLAGS = -g -d ./
VPATH = src:/src

.SUFFIXES: .java .class .txt

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

run: all
	@java InsertionSortTest data/10kRand.txt
	@java MergeSortTest data/10kRand.txt
	@java QuickSortTest data/10kRand.txt
	@java RandQuickSortTest data/10kRand.txt
