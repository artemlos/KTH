package inda6;

import static org.junit.Assert.*;
import inda6.Data.Order;

import java.beans.Expression;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class SortTest {

    /**
     * t: test case,  s: expected solution.
     */
    private int[] t0, s0, t1, s1, t2, s2, t7, s7;

    /**
     * Big array of random numbers.
     * tr: test case, sr: expected solution.
     * R_SIZE is the size of the array.
     */
    private static final int R_SIZE = 10000;
    private int[] tr, sr;

    private Random rand;
    
    ISort sort;

    /**
     * Constructs a new test case.
     */
    @Before
    public void SetUp()
    {
    	rand = new Random();
    	
    	 t0 = new int[0];
         s0 = new int[0];

         t1 = new int[] {1};
         s1 = new int[] {1};

         t2 = new int[] {2, 1};
         s2 = new int[] {1, 2};

         t7 = new int[] {9, 5, 2, 7, 1, 6, 6};
         s7 = new int[] {1, 2, 5, 6, 6, 7, 9};

         tr = new int[R_SIZE];
         sr = new int[R_SIZE];
         for (int i = 0; i < R_SIZE; i++) {
             tr[i] = sr[i] = rand.nextInt();
         }
         Arrays.sort(sr);
    }
    
    @Test
    public void testAllSortAlg()
    {
    	sort = new InsertionSort();
    	workingSortAlg();
    	
    	
    	SetUp();
    	sort = new QuickSortFixedPivot();
    	
    	workingSortAlg();
    	
    	
    	SetUp();
    	sort = new QuickSortFixedPivot();
    	
    	sort.setAlg(new InsertionSort());
    	workingSortAlg();
    	
    	SetUp();
    	sort = new QuickSortRandPivot();
    	
    	sort.setAlg(new QuickSortRandPivot());
    	workingSortAlg();
    }
    
    @Test
    public void InsertionSortNewTests()
    {
    	InsertionSort  sortA = new InsertionSort();
    	
    	int[] rand = new int[] {9, 5, 2, 7, 1, 6, 6};
    	
    	sortA.specsort(rand, rand.length-4, rand.length);
    	
    	int[] actual = new int[]{9, 5, 2, 1 , 6, 6, 7};
    	for (int i = 0; i < rand.length; i++) {
			assertTrue(actual[i] == rand[i]);
			
		}
    }
    
    public void workingSortAlg()
    {
        sort.sort(t0);
        assertTrue(Arrays.equals(t0, s0));

        sort.sort(t1);
        assertTrue(Arrays.equals(t1, s1));

        sort.sort(t2);
        assertTrue(Arrays.equals(t2, s2));

        sort.sort(t7);
        assertTrue(Arrays.equals(t7, s7));

        sort.sort(tr);
        assertTrue(Arrays.equals(tr, sr));
    }
    
    @Test
    public void RequiredTests()
    {
    	//these are required in the exercise
    	
    	//ALGORITHM 1
    	sort = new QuickSortFixedPivot();
    	sort.setAlg(new QuickSortFixedPivot());
    	RequiredTestCases();
    	
    	//ALGORITHM 2
    	sort = new QuickSortFixedPivot();
    	sort.setAlg(new InsertionSort());
    	RequiredTestCases();
    	
    	//ALGORITHM 3
    	sort = new QuickSortRandPivot();
    	sort.setAlg(new InsertionSort());
    	RequiredTestCases();
    	
    	//ALGORITHM 3
    	sort = new QuickSortRandPivot();
    	sort.setAlg(new QuickSortRandPivot());
    	RequiredTestCases();
    	
    }
    
    
    public void RequiredTestCases()
    {
    	//assertTrue(false);
    	Data dt = new Data(10000, 50, Order.RANDOM);
    	
    	int[] expdata = dt.get();
    	int[] actualdata = dt.get();
    	Arrays.sort(actualdata);
    	sort.sort(expdata);
    	assertTrue(compareArrays(expdata,actualdata));
    	
    	dt = new Data(1000, 50, Order.DESCENDING);
    	
    	expdata = dt.get();
    	actualdata = dt.get();
    	Arrays.sort(actualdata);
    	sort.sort(expdata);
    	assertTrue(compareArrays(expdata,actualdata));
    	
    	dt = new Data(1000, 1, Order.DESCENDING);
    	
    	expdata = dt.get();
    	actualdata = dt.get();
    	Arrays.sort(actualdata);
    	sort.sort(expdata);
    	assertTrue(compareArrays(expdata,actualdata));
    }
    
    public boolean compareArrays(int[] a, int[] b)
    {
    	if(a.length != b.length)
    		return false;
    	
    	for (int i = 0; i < b.length; i++) {
    		if(a[i] != b[i])
    			return false;
		}
    	
    	return true;
    }
    
    @Test
    public void ExecutionTimePivotNonInsertionSort()
    {
    	
    	for (int i = 0; i < 100; i++) {
    		Stopwatch sw = new Stopwatch();
			sw.start();
	    	//ALGORITHM 1
	    	sort = new QuickSortFixedPivot();
	    	sort.setAlg(new QuickSortFixedPivot());
	    	
	    	Data dt = new Data(10000, Integer.MAX_VALUE, Order.RANDOM);
	    	
	    	int[] expdata = dt.get();
	    	
	    	sort.sort(expdata);
	    	sw.stop();
	    	
	    	System.out.println(sw.nanoseconds());
		}
    }
    @Test
    public void ExecutionTimePivotInsertionSort()
    {
    	
    	for (int i = 0; i < 100; i++) {
    		Stopwatch sw = new Stopwatch();
			sw.start();
	    	//ALGORITHM 1
	    	sort = new QuickSortFixedPivot();
	    	sort.setAlg(new InsertionSort());
	    	
	    	Data dt = new Data(10000, Integer.MAX_VALUE, Order.RANDOM);
	    	
	    	int[] expdata = dt.get();
	    	
	    	sort.sort(expdata);
	    	sw.stop();
	    	
	    	System.out.println(sw.nanoseconds());
		}
    }
    
    @Test
    public void ExecutionTimeRandPivotInsertionSort()
    {
    	
    	for (int i = 0; i < 100; i++) {
    		Stopwatch sw = new Stopwatch();
			sw.start();
	    	//ALGORITHM 1
	    	sort = new QuickSortRandPivot();
	    	sort.setAlg(new InsertionSort());
	    	
	    	Data dt = new Data(10000, Integer.MAX_VALUE, Order.RANDOM);
	    	
	    	int[] expdata = dt.get();
	    	
	    	sort.sort(expdata);
	    	sw.stop();
	    	
	    	System.out.println(sw.nanoseconds());
		}
    }
    
    @Test
    public void ExecutionTimeRandPivotNonInsertionSort()
    {
    	
    	for (int i = 0; i < 100; i++) {
    		Stopwatch sw = new Stopwatch();
			sw.start();
	    	//ALGORITHM 1
	    	sort = new QuickSortRandPivot();
	    	sort.setAlg(new QuickSortRandPivot());
	    	
	    	Data dt = new Data(10000, Integer.MAX_VALUE, Order.RANDOM);
	    	
	    	int[] expdata = dt.get();
	    	
	    	sort.sort(expdata);
	    	sw.stop();
	    	
	    	System.out.println(sw.nanoseconds());
		}
    }
    
    @Test
    public void OptimizedAlgorithm()
    {
    	QuickSortFixedPivot sortA = new QuickSortFixedPivot();
    	
    	for (int i = 0; i < 100; i++) {
    		Stopwatch sw = new Stopwatch();
			sw.start();
	    	//ALGORITHM 1
	    	sortA = new QuickSortFixedPivot();
	    	sortA.setAlg(new InsertionSort());
	    	sortA.K = 15;
	    	
	    	Data dt = new Data(10000, Integer.MAX_VALUE, Order.RANDOM);
	    	
	    	int[] expdata = dt.get();
	    	
	    	sortA.sort(expdata);
	    	sw.stop();
	    	
	    	System.out.println(sw.nanoseconds());
		}
    }
    
    @Test
    public void ExecutionTimeArraySort()
    {
    	
    	for (int i = 0; i < 100; i++) {
    		Stopwatch sw = new Stopwatch();
			sw.start();
	    	//ALGORITHM 1
	    	Data dt = new Data(10000, Integer.MAX_VALUE, Order.RANDOM);
	    	
	    	int[] expdata = dt.get();
	    	
	    	Arrays.sort(expdata);
	    	sw.stop();
	    	
	    	System.out.println(sw.nanoseconds());
		}
    }
    
    
    //@Test
    public void FindOptimalKValue()
    {
    	
    	
    	long[] nanosec = new long[100];
    	for (int j = 0; j < 100; j++) {
    		int KVal = 0;
	       	for (int i = 0; i < 100; i++) {
	    		Stopwatch sw = new Stopwatch();
				sw.start();
		    	//ALGORITHM 1
		    	QuickSortFixedPivot sorta = new QuickSortFixedPivot();
		    	sorta.setAlg(new InsertionSort());
		    	
		    	sorta.K = KVal;
		    	
		    	Data dt = new Data(10000, Integer.MAX_VALUE, Order.RANDOM);
		    	
		    	int[] expdata = dt.get();
		    	
		    	sorta.sort(expdata);
		    	sw.stop();
		    	
		    	if(nanosec[KVal] < sw.nanoseconds())
		    		nanosec[KVal] = sw.nanoseconds();
		    	//System.out.println( sorta.K +"\t"+ sw.nanoseconds());
		    	
		    	KVal++;
			}
    	}
       	for (int i = 0; i < nanosec.length; i++) {
			System.out.println(i +"\t" + nanosec[i] );
		}
    }
    
    //@Test
    public void DifferentDataSetsRandom()
    {
    	int[] randomarray = new int[]{1,2,3,4,5};
    	InsertionSort sorter = new InsertionSort();
    	
    	sorter.sort(randomarray);
    	Arrays.sort(randomarray);
    	// doing things above to minimise java just in time...
    	
    	for (int i = 0; i <= 18; i++) {
    		Stopwatch sw = new Stopwatch();
			sw.start();
	    	//ALGORITHM 1
	    	Data dt = new Data((int)Math.pow(2, i), Integer.MAX_VALUE, Order.RANDOM);
	    	
	    	int[] expdata = dt.get();
	    	
	    	Arrays.sort(expdata);
	    	sw.stop();
	    	
	    	
	    	long sortArrays = sw.nanoseconds();
	    	
	    	sw.start();
	    	expdata = dt.get();
	    	sorter.sort(expdata);
	    	sw.stop();
	    	
	    	System.out.println(sortArrays + "\t" + sw.nanoseconds());
		}
    	
    	/*
    	System.out.println("break");
    	for (int i = 0; i <= 25; i++) {
    		Stopwatch sw = new Stopwatch();
			sw.start();
	    	//ALGORITHM 1
	    	Data dt = new Data((int)Math.pow(2, i), Integer.MAX_VALUE, Order.RANDOM);
	    	
	    	int[] expdata = dt.get();
	    	
	    	sorter.sort(expdata);
	    	sw.stop();
	    	
	    	System.out.println(sw.nanoseconds());
		}*/
    }
    
    @Test
    public void DifferentDataSetsOrdered()
    {
    	int[] randomarray = new int[]{1,2,3,4,5};
    	InsertionSort sorter = new InsertionSort();
    	
    	sorter.sort(randomarray);
    	Arrays.sort(randomarray);
    	// doing things above to minimise java just in time...
    	
    	for (int i = 0; i <= 18; i++) {
    		Stopwatch sw = new Stopwatch();
			sw.start();
	    	//ALGORITHM 1
	    	Data dt = new Data((int)Math.pow(2, i), Integer.MAX_VALUE, Order.ASCENDING);
	    	
	    	int[] expdata = dt.get();
	    	
	    	Arrays.sort(expdata);
	    	sw.stop();
	    	
	    	
	    	long sortArrays = sw.nanoseconds();
	    	
	    	sw.start();
	    	expdata = dt.get();
	    	sorter.sort(expdata);
	    	sw.stop();
	    	
	    	System.out.println(sortArrays + "\t" + sw.nanoseconds());
		}
    }
    
    
    @Test
    public void DifferentDataSetsDiscending()
    {
    	int[] randomarray = new int[]{1,2,3,4,5};
    	InsertionSort sorter = new InsertionSort();
    	
    	sorter.sort(randomarray);
    	Arrays.sort(randomarray);
    	// doing things above to minimise java just in time...
    	
    	for (int i = 0; i <= 18; i++) {
    		Stopwatch sw = new Stopwatch();
			sw.start();
	    	//ALGORITHM 1
	    	Data dt = new Data((int)Math.pow(2, i), Integer.MAX_VALUE, Order.DESCENDING);
	    	
	    	int[] expdata = dt.get();
	    	
	    	Arrays.sort(expdata);
	    	sw.stop();
	    	
	    	
	    	long sortArrays = sw.nanoseconds();
	    	
	    	sw.start();
	    	expdata = dt.get();
	    	sorter.sort(expdata);
	    	sw.stop();
	    	
	    	System.out.println(sortArrays + "\t" + sw.nanoseconds());
		}
    }
    
 
    
    
}
