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
	
InsertionSortTest: InsertionSortTest.class
	@java InsertionSortTest data/10kRand.txt
	@java InsertionSortTest data/20kRand.txt
	@java InsertionSortTest data/40kRand.txt
	@java InsertionSortTest data/80kRand.txt
	@java InsertionSortTest data/10kSorted.txt
	@java InsertionSortTest data/20kSorted.txt
	@java InsertionSortTest data/40kSorted.txt
	@java InsertionSortTest data/80kSorted.txt
	@java InsertionSortTest data/10kReversed.txt
	@java InsertionSortTest data/20kReversed.txt
	@java InsertionSortTest data/40kReversed.txt
	@java InsertionSortTest data/80kReversed.txt
	@java InsertionSortTest data/10kSame.txt
	@java InsertionSortTest data/20kSame.txt
	@java InsertionSortTest data/40kSame.txt
	@java InsertionSortTest data/80kSame.txt
	
MergeSortTest: MergeSortTest.class
	@java MergeSortTest data/10kRand.txt
	@java MergeSortTest data/20kRand.txt
	@java MergeSortTest data/40kRand.txt
	@java MergeSortTest data/80kRand.txt
	@java MergeSortTest data/10kSorted.txt
	@java MergeSortTest data/20kSorted.txt
	@java MergeSortTest data/40kSorted.txt
	@java MergeSortTest data/80kSorted.txt
	@java MergeSortTest data/10kReversed.txt
	@java MergeSortTest data/20kReversed.txt
	@java MergeSortTest data/40kReversed.txt
	@java MergeSortTest data/80kReversed.txt
	@java MergeSortTest data/10kSame.txt
	@java MergeSortTest data/20kSame.txt
	@java MergeSortTest data/40kSame.txt
	@java MergeSortTest data/80kSame.txt
	
QuickSortTest: QuickSortTest.class
	@java QuickSortTest data/10kRand.txt
	@java QuickSortTest data/20kRand.txt
	@java QuickSortTest data/40kRand.txt
	@java QuickSortTest data/80kRand.txt
	@java QuickSortTest data/10kSorted.txt
	@java QuickSortTest data/20kSorted.txt
	@java QuickSortTest data/40kSorted.txt
	@java QuickSortTest data/80kSorted.txt
	@java QuickSortTest data/10kReversed.txt
	@java QuickSortTest data/20kReversed.txt
	@java QuickSortTest data/40kReversed.txt
	@java QuickSortTest data/80kReversed.txt
	@java QuickSortTest data/10kSame.txt
	@java QuickSortTest data/20kSame.txt
	@java QuickSortTest data/40kSame.txt
	@java QuickSortTest data/80kSame.txt
	
RandQuickSortTest: RandQuickSortTest.class
	@java RandQuickSortTest data/10kRand.txt
	@java RandQuickSortTest data/20kRand.txt
	@java RandQuickSortTest data/40kRand.txt
	@java RandQuickSortTest data/80kRand.txt
	@java RandQuickSortTest data/10kSorted.txt
	@java RandQuickSortTest data/20kSorted.txt
	@java RandQuickSortTest data/40kSorted.txt
	@java RandQuickSortTest data/80kSorted.txt
	@java RandQuickSortTest data/10kReversed.txt
	@java RandQuickSortTest data/20kReversed.txt
	@java RandQuickSortTest data/40kReversed.txt
	@java RandQuickSortTest data/80kReversed.txt
	@java RandQuickSortTest data/10kSame.txt
	@java RandQuickSortTest data/20kSame.txt
	@java RandQuickSortTest data/40kSame.txt
	@java RandQuickSortTest data/80kSame.txt

run: all
	@java InsertionSortTest data/10kRand.txt
	@java InsertionSortTest data/20kRand.txt
	@java InsertionSortTest data/40kRand.txt
	@java InsertionSortTest data/80kRand.txt
	@java MergeSortTest data/10kRand.txt
	@java MergeSortTest data/20kRand.txt
	@java MergeSortTest data/40kRand.txt
	@java MergeSortTest data/80kRand.txt
	@java QuickSortTest data/10kRand.txt
	@java QuickSortTest data/20kRand.txt
	@java QuickSortTest data/40kRand.txt
	@java QuickSortTest data/80kRand.txt
	@java RandQuickSortTest data/10kRand.txt
	@java RandQuickSortTest data/20kRand.txt
	@java RandQuickSortTest data/40kRand.txt
	@java RandQuickSortTest data/80kRand.txt
	@java InsertionSortTest data/10kSorted.txt
	@java InsertionSortTest data/20kSorted.txt
	@java InsertionSortTest data/40kSorted.txt
	@java InsertionSortTest data/80kSorted.txt
	@java MergeSortTest data/10kSorted.txt
	@java MergeSortTest data/20kSorted.txt
	@java MergeSortTest data/40kSorted.txt
	@java MergeSortTest data/80kSorted.txt
	@java QuickSortTest data/10kSorted.txt
	@java QuickSortTest data/20kSorted.txt
	@java QuickSortTest data/40kSorted.txt
	@java QuickSortTest data/80kSorted.txt
	@java RandQuickSortTest data/10kSorted.txt
	@java RandQuickSortTest data/20kSorted.txt
	@java RandQuickSortTest data/40kSorted.txt
	@java RandQuickSortTest data/80kSorted.txt
	@java InsertionSortTest data/10kReversed.txt
	@java InsertionSortTest data/20kReversed.txt
	@java InsertionSortTest data/40kReversed.txt
	@java InsertionSortTest data/80kReversed.txt
	@java MergeSortTest data/10kReversed.txt
	@java MergeSortTest data/20kReversed.txt
	@java MergeSortTest data/40kReversed.txt
	@java MergeSortTest data/80kReversed.txt
	@java QuickSortTest data/10kReversed.txt
	@java QuickSortTest data/20kReversed.txt
	@java QuickSortTest data/40kReversed.txt
	@java QuickSortTest data/80kReversed.txt
	@java RandQuickSortTest data/10kReversed.txt
	@java RandQuickSortTest data/20kReversed.txt
	@java RandQuickSortTest data/40kReversed.txt
	@java RandQuickSortTest data/80kReversed.txt
	@java InsertionSortTest data/10kSame.txt
	@java InsertionSortTest data/20kSame.txt
	@java InsertionSortTest data/40kSame.txt
	@java InsertionSortTest data/80kSame.txt
	@java MergeSortTest data/10kSame.txt
	@java MergeSortTest data/20kSame.txt
	@java MergeSortTest data/40kSame.txt
	@java MergeSortTest data/80kSame.txt
	@java QuickSortTest data/10kSame.txt
	@java QuickSortTest data/20kSame.txt
	@java QuickSortTest data/40kSame.txt
	@java QuickSortTest data/80kSame.txt
	@java RandQuickSortTest data/10kSame.txt
	@java RandQuickSortTest data/20kSame.txt
	@java RandQuickSortTest data/40kSame.txt
	@java RandQuickSortTest data/80kSame.txt
