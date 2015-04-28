import java.util.Arrays;
import java.util.Random;

/**
 * Test class for Sort.
 *
 * @author  Stefan Nilsson
 * @version 2011-10-23
 */
public class SortTest extends junit.framework.TestCase
{
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

    /**
     * Constructs a new test case.
     */
    public SortTest() {
        rand = new Random();
    }

    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    protected void setUp() {
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

    /**
     * Tears down the test fixture.
     * Called after every test case method.
     */
    protected void tearDown() {
    }

    public void testSelectionSort() {
        Sort sort = new Sort();

        sort.selectionSort(t0);
        assertTrue(Arrays.equals(t0, s0));

        sort.selectionSort(t1);
        assertTrue(Arrays.equals(t1, s1));

        sort.selectionSort(t2);
        assertTrue(Arrays.equals(t2, s2));

        sort.selectionSort(t7);
        assertTrue(Arrays.equals(t7, s7));

        sort.selectionSort(tr);
        assertTrue(Arrays.equals(tr, sr));
    }
    
    public void testInsertionSort()
    {
        Sort sort = new Sort();

        sort.insertionSort(t0);
        assertTrue(Arrays.equals(t0, s0));

        sort.insertionSort(t1);
        assertTrue(Arrays.equals(t1, s1));

        sort.insertionSort(t2);
        assertTrue(Arrays.equals(t2, s2));

        sort.insertionSort(t7);
        assertTrue(Arrays.equals(t7, s7));

        sort.insertionSort(tr);
        assertTrue(Arrays.equals(tr, sr));
    }
}

