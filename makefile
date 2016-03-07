JCC = javac
JFLAGS = -g -d ./
RUNFLAGS = -Xss6m
VPATH = src:/src
OUTFILE = output.scv

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

run: all
	@$(RM) $(OUTFILE)
	@java InsertionSortTest data/10kRand.txt
	@java InsertionSortTest data/10kRand.txt
	@java InsertionSortTest data/10kRand.txt
	@java InsertionSortTest data/10kRand.txt
	@java InsertionSortTest data/20kRand.txt
	@java InsertionSortTest data/20kRand.txt
	@java InsertionSortTest data/20kRand.txt
	@java InsertionSortTest data/20kRand.txt
	@java InsertionSortTest data/40kRand.txt
	@java InsertionSortTest data/40kRand.txt
	@java InsertionSortTest data/40kRand.txt
	@java InsertionSortTest data/40kRand.txt
	@java InsertionSortTest data/80kRand.txt
	@java InsertionSortTest data/80kRand.txt
	@java InsertionSortTest data/80kRand.txt
	@java InsertionSortTest data/80kRand.txt
	
	@java MergeSortTest data/10kRand.txt
	@java MergeSortTest data/10kRand.txt
	@java MergeSortTest data/10kRand.txt
	@java MergeSortTest data/10kRand.txt
	@java MergeSortTest data/20kRand.txt
	@java MergeSortTest data/20kRand.txt
	@java MergeSortTest data/20kRand.txt
	@java MergeSortTest data/20kRand.txt
	@java MergeSortTest data/40kRand.txt
	@java MergeSortTest data/40kRand.txt
	@java MergeSortTest data/40kRand.txt
	@java MergeSortTest data/40kRand.txt
	@java MergeSortTest data/80kRand.txt
	@java MergeSortTest data/80kRand.txt
	@java MergeSortTest data/80kRand.txt
	@java MergeSortTest data/80kRand.txt
	
	@java $(RUNFLAGS) QuickSortTest data/10kRand.txt
	@java $(RUNFLAGS) QuickSortTest data/10kRand.txt
	@java $(RUNFLAGS) QuickSortTest data/10kRand.txt
	@java $(RUNFLAGS) QuickSortTest data/10kRand.txt
	@java $(RUNFLAGS) QuickSortTest data/20kRand.txt
	@java $(RUNFLAGS) QuickSortTest data/20kRand.txt
	@java $(RUNFLAGS) QuickSortTest data/20kRand.txt
	@java $(RUNFLAGS) QuickSortTest data/20kRand.txt
	@java $(RUNFLAGS) QuickSortTest data/40kRand.txt
	@java $(RUNFLAGS) QuickSortTest data/40kRand.txt
	@java $(RUNFLAGS) QuickSortTest data/40kRand.txt
	@java $(RUNFLAGS) QuickSortTest data/40kRand.txt
	@java $(RUNFLAGS) QuickSortTest data/80kRand.txt
	@java $(RUNFLAGS) QuickSortTest data/80kRand.txt
	@java $(RUNFLAGS) QuickSortTest data/80kRand.txt
	@java $(RUNFLAGS) QuickSortTest data/80kRand.txt
	
	@java $(RUNFLAGS) RandQuickSortTest data/10kRand.txt
	@java $(RUNFLAGS) RandQuickSortTest data/10kRand.txt
	@java $(RUNFLAGS) RandQuickSortTest data/10kRand.txt
	@java $(RUNFLAGS) RandQuickSortTest data/10kRand.txt
	@java $(RUNFLAGS) RandQuickSortTest data/20kRand.txt
	@java $(RUNFLAGS) RandQuickSortTest data/20kRand.txt
	@java $(RUNFLAGS) RandQuickSortTest data/20kRand.txt
	@java $(RUNFLAGS) RandQuickSortTest data/20kRand.txt
	@java $(RUNFLAGS) RandQuickSortTest data/40kRand.txt
	@java $(RUNFLAGS) RandQuickSortTest data/40kRand.txt
	@java $(RUNFLAGS) RandQuickSortTest data/40kRand.txt
	@java $(RUNFLAGS) RandQuickSortTest data/40kRand.txt
	@java $(RUNFLAGS) RandQuickSortTest data/80kRand.txt
	@java $(RUNFLAGS) RandQuickSortTest data/80kRand.txt
	@java $(RUNFLAGS) RandQuickSortTest data/80kRand.txt
	@java $(RUNFLAGS) RandQuickSortTest data/80kRand.txt
	
	@java InsertionSortTest data/10kSorted.txt
	@java InsertionSortTest data/10kSorted.txt
	@java InsertionSortTest data/10kSorted.txt
	@java InsertionSortTest data/10kSorted.txt
	@java InsertionSortTest data/20kSorted.txt
	@java InsertionSortTest data/20kSorted.txt
	@java InsertionSortTest data/20kSorted.txt
	@java InsertionSortTest data/20kSorted.txt
	@java InsertionSortTest data/40kSorted.txt
	@java InsertionSortTest data/40kSorted.txt
	@java InsertionSortTest data/40kSorted.txt
	@java InsertionSortTest data/40kSorted.txt
	@java InsertionSortTest data/80kSorted.txt
	@java InsertionSortTest data/80kSorted.txt
	@java InsertionSortTest data/80kSorted.txt
	@java InsertionSortTest data/80kSorted.txt
	
	@java MergeSortTest data/10kSorted.txt
	@java MergeSortTest data/10kSorted.txt
	@java MergeSortTest data/10kSorted.txt
	@java MergeSortTest data/10kSorted.txt
	@java MergeSortTest data/20kSorted.txt
	@java MergeSortTest data/20kSorted.txt
	@java MergeSortTest data/20kSorted.txt
	@java MergeSortTest data/20kSorted.txt
	@java MergeSortTest data/40kSorted.txt
	@java MergeSortTest data/40kSorted.txt
	@java MergeSortTest data/40kSorted.txt
	@java MergeSortTest data/40kSorted.txt
	@java MergeSortTest data/80kSorted.txt
	@java MergeSortTest data/80kSorted.txt
	@java MergeSortTest data/80kSorted.txt
	@java MergeSortTest data/80kSorted.txt
	
	@java $(RUNFLAGS) QuickSortTest data/10kSorted.txt
	@java $(RUNFLAGS) QuickSortTest data/10kSorted.txt
	@java $(RUNFLAGS) QuickSortTest data/10kSorted.txt
	@java $(RUNFLAGS) QuickSortTest data/10kSorted.txt
	@java $(RUNFLAGS) QuickSortTest data/20kSorted.txt
	@java $(RUNFLAGS) QuickSortTest data/20kSorted.txt
	@java $(RUNFLAGS) QuickSortTest data/20kSorted.txt
	@java $(RUNFLAGS) QuickSortTest data/20kSorted.txt
	@java $(RUNFLAGS) QuickSortTest data/40kSorted.txt
	@java $(RUNFLAGS) QuickSortTest data/40kSorted.txt
	@java $(RUNFLAGS) QuickSortTest data/40kSorted.txt
	@java $(RUNFLAGS) QuickSortTest data/40kSorted.txt
	@java $(RUNFLAGS) QuickSortTest data/80kSorted.txt
	@java $(RUNFLAGS) QuickSortTest data/80kSorted.txt
	@java $(RUNFLAGS) QuickSortTest data/80kSorted.txt
	@java $(RUNFLAGS) QuickSortTest data/80kSorted.txt
	
	@java $(RUNFLAGS) RandQuickSortTest data/10kSorted.txt
	@java $(RUNFLAGS) RandQuickSortTest data/10kSorted.txt
	@java $(RUNFLAGS) RandQuickSortTest data/10kSorted.txt
	@java $(RUNFLAGS) RandQuickSortTest data/10kSorted.txt
	@java $(RUNFLAGS) RandQuickSortTest data/20kSorted.txt
	@java $(RUNFLAGS) RandQuickSortTest data/20kSorted.txt
	@java $(RUNFLAGS) RandQuickSortTest data/20kSorted.txt
	@java $(RUNFLAGS) RandQuickSortTest data/20kSorted.txt
	@java $(RUNFLAGS) RandQuickSortTest data/40kSorted.txt
	@java $(RUNFLAGS) RandQuickSortTest data/40kSorted.txt
	@java $(RUNFLAGS) RandQuickSortTest data/40kSorted.txt
	@java $(RUNFLAGS) RandQuickSortTest data/40kSorted.txt
	@java $(RUNFLAGS) RandQuickSortTest data/80kSorted.txt
	@java $(RUNFLAGS) RandQuickSortTest data/80kSorted.txt
	@java $(RUNFLAGS) RandQuickSortTest data/80kSorted.txt
	@java $(RUNFLAGS) RandQuickSortTest data/80kSorted.txt
	
	@java InsertionSortTest data/10kReversed.txt
	@java InsertionSortTest data/10kReversed.txt
	@java InsertionSortTest data/10kReversed.txt
	@java InsertionSortTest data/10kReversed.txt
	@java InsertionSortTest data/20kReversed.txt
	@java InsertionSortTest data/20kReversed.txt
	@java InsertionSortTest data/20kReversed.txt
	@java InsertionSortTest data/20kReversed.txt
	@java InsertionSortTest data/40kReversed.txt
	@java InsertionSortTest data/40kReversed.txt
	@java InsertionSortTest data/40kReversed.txt
	@java InsertionSortTest data/40kReversed.txt
	@java InsertionSortTest data/80kReversed.txt
	@java InsertionSortTest data/80kReversed.txt
	@java InsertionSortTest data/80kReversed.txt
	@java InsertionSortTest data/80kReversed.txt
	
	@java MergeSortTest data/10kReversed.txt
	@java MergeSortTest data/10kReversed.txt
	@java MergeSortTest data/10kReversed.txt
	@java MergeSortTest data/10kReversed.txt
	@java MergeSortTest data/20kReversed.txt
	@java MergeSortTest data/20kReversed.txt
	@java MergeSortTest data/20kReversed.txt
	@java MergeSortTest data/20kReversed.txt
	@java MergeSortTest data/40kReversed.txt
	@java MergeSortTest data/40kReversed.txt
	@java MergeSortTest data/40kReversed.txt
	@java MergeSortTest data/40kReversed.txt
	@java MergeSortTest data/80kReversed.txt
	@java MergeSortTest data/80kReversed.txt
	@java MergeSortTest data/80kReversed.txt
	@java MergeSortTest data/80kReversed.txt
	
	@java $(RUNFLAGS) QuickSortTest data/10kReversed.txt
	@java $(RUNFLAGS) QuickSortTest data/10kReversed.txt
	@java $(RUNFLAGS) QuickSortTest data/10kReversed.txt
	@java $(RUNFLAGS) QuickSortTest data/10kReversed.txt
	@java $(RUNFLAGS) QuickSortTest data/20kReversed.txt
	@java $(RUNFLAGS) QuickSortTest data/20kReversed.txt
	@java $(RUNFLAGS) QuickSortTest data/20kReversed.txt
	@java $(RUNFLAGS) QuickSortTest data/20kReversed.txt
	@java $(RUNFLAGS) QuickSortTest data/40kReversed.txt
	@java $(RUNFLAGS) QuickSortTest data/40kReversed.txt
	@java $(RUNFLAGS) QuickSortTest data/40kReversed.txt
	@java $(RUNFLAGS) QuickSortTest data/40kReversed.txt
	@java $(RUNFLAGS) QuickSortTest data/80kReversed.txt
	@java $(RUNFLAGS) QuickSortTest data/80kReversed.txt
	@java $(RUNFLAGS) QuickSortTest data/80kReversed.txt
	@java $(RUNFLAGS) QuickSortTest data/80kReversed.txt
	
	@java $(RUNFLAGS) RandQuickSortTest data/10kReversed.txt
	@java $(RUNFLAGS) RandQuickSortTest data/10kReversed.txt
	@java $(RUNFLAGS) RandQuickSortTest data/10kReversed.txt
	@java $(RUNFLAGS) RandQuickSortTest data/10kReversed.txt
	@java $(RUNFLAGS) RandQuickSortTest data/20kReversed.txt
	@java $(RUNFLAGS) RandQuickSortTest data/20kReversed.txt
	@java $(RUNFLAGS) RandQuickSortTest data/20kReversed.txt
	@java $(RUNFLAGS) RandQuickSortTest data/20kReversed.txt
	@java $(RUNFLAGS) RandQuickSortTest data/40kReversed.txt
	@java $(RUNFLAGS) RandQuickSortTest data/40kReversed.txt
	@java $(RUNFLAGS) RandQuickSortTest data/40kReversed.txt
	@java $(RUNFLAGS) RandQuickSortTest data/40kReversed.txt
	@java $(RUNFLAGS) RandQuickSortTest data/80kReversed.txt
	@java $(RUNFLAGS) RandQuickSortTest data/80kReversed.txt
	@java $(RUNFLAGS) RandQuickSortTest data/80kReversed.txt
	@java $(RUNFLAGS) RandQuickSortTest data/80kReversed.txt
	
	@java InsertionSortTest data/10kSame.txt
	@java InsertionSortTest data/10kSame.txt
	@java InsertionSortTest data/10kSame.txt
	@java InsertionSortTest data/10kSame.txt
	@java InsertionSortTest data/20kSame.txt
	@java InsertionSortTest data/20kSame.txt
	@java InsertionSortTest data/20kSame.txt
	@java InsertionSortTest data/20kSame.txt
	@java InsertionSortTest data/40kSame.txt
	@java InsertionSortTest data/40kSame.txt
	@java InsertionSortTest data/40kSame.txt
	@java InsertionSortTest data/40kSame.txt
	@java InsertionSortTest data/80kSame.txt
	@java InsertionSortTest data/80kSame.txt
	@java InsertionSortTest data/80kSame.txt
	@java InsertionSortTest data/80kSame.txt
	
	@java MergeSortTest data/10kSame.txt
	@java MergeSortTest data/10kSame.txt
	@java MergeSortTest data/10kSame.txt
	@java MergeSortTest data/10kSame.txt
	@java MergeSortTest data/20kSame.txt
	@java MergeSortTest data/20kSame.txt
	@java MergeSortTest data/20kSame.txt
	@java MergeSortTest data/20kSame.txt
	@java MergeSortTest data/40kSame.txt
	@java MergeSortTest data/40kSame.txt
	@java MergeSortTest data/40kSame.txt
	@java MergeSortTest data/40kSame.txt
	@java MergeSortTest data/80kSame.txt
	@java MergeSortTest data/80kSame.txt
	@java MergeSortTest data/80kSame.txt
	@java MergeSortTest data/80kSame.txt
	
	@java $(RUNFLAGS) QuickSortTest data/10kSame.txt
	@java $(RUNFLAGS) QuickSortTest data/10kSame.txt
	@java $(RUNFLAGS) QuickSortTest data/10kSame.txt
	@java $(RUNFLAGS) QuickSortTest data/10kSame.txt
	@java $(RUNFLAGS) QuickSortTest data/20kSame.txt
	@java $(RUNFLAGS) QuickSortTest data/20kSame.txt
	@java $(RUNFLAGS) QuickSortTest data/20kSame.txt
	@java $(RUNFLAGS) QuickSortTest data/20kSame.txt
	@java $(RUNFLAGS) QuickSortTest data/40kSame.txt
	@java $(RUNFLAGS) QuickSortTest data/40kSame.txt
	@java $(RUNFLAGS) QuickSortTest data/40kSame.txt
	@java $(RUNFLAGS) QuickSortTest data/40kSame.txt
	@java $(RUNFLAGS) QuickSortTest data/80kSame.txt
	@java $(RUNFLAGS) QuickSortTest data/80kSame.txt
	@java $(RUNFLAGS) QuickSortTest data/80kSame.txt
	@java $(RUNFLAGS) QuickSortTest data/80kSame.txt
	
	@java $(RUNFLAGS) RandQuickSortTest data/10kSame.txt
	@java $(RUNFLAGS) RandQuickSortTest data/10kSame.txt
	@java $(RUNFLAGS) RandQuickSortTest data/10kSame.txt
	@java $(RUNFLAGS) RandQuickSortTest data/10kSame.txt
	@java $(RUNFLAGS) RandQuickSortTest data/20kSame.txt
	@java $(RUNFLAGS) RandQuickSortTest data/20kSame.txt
	@java $(RUNFLAGS) RandQuickSortTest data/20kSame.txt
	@java $(RUNFLAGS) RandQuickSortTest data/20kSame.txt
	@java $(RUNFLAGS) RandQuickSortTest data/40kSame.txt
	@java $(RUNFLAGS) RandQuickSortTest data/40kSame.txt
	@java $(RUNFLAGS) RandQuickSortTest data/40kSame.txt
	@java $(RUNFLAGS) RandQuickSortTest data/40kSame.txt
	@java $(RUNFLAGS) RandQuickSortTest data/80kSame.txt
	@java $(RUNFLAGS) RandQuickSortTest data/80kSame.txt
	@java $(RUNFLAGS) RandQuickSortTest data/80kSame.txt
	@java $(RUNFLAGS) RandQuickSortTest data/80kSame.txt
