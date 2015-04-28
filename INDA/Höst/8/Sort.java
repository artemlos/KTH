import java.util.Arrays;

/**
 * A collection of sorting algorithms for arrays of integers.
 * 
 * @author Stefan Nilsson 
 * @version 2009-10-22
 */
public class Sort
{
    private static final boolean DEBUGGING = false;
    
    private void debugPrint(String s) {
        if (DEBUGGING) {
            System.err.println("Sort: " + s);
        }
    }
    
    public int[] insertionSort(int[] v)
    {
    	for (int j = 1; j < v.length; j++)
    	{
			int key = v[j];
			int i = j-1;
			
			while(i>= 0 && v[i] > key)
			{
				v[i+1] = v[i];
				i--;
			}
			v[i+1] = key;
		}
    	
    	return v;
    }
    
    
    /**
     * Sort the elements in ascending order.
     * This algorithm has time complexity Theta(n*n), where n is
     * the length of the array.
     * 
     * @param v    An array of integers.
     * @return     The same array sorted in ascending order.
     */
    public void selectionSort(int[] v) {
        int n = v.length;
        debugPrint("selection sort, n=" + n);
        for (int i = 0; i < n - 1; i++) {
            // find index m of min element in v[i..n-1]  
            int m = i;
            for (int j = i + 1; j < n; j++) {
                if (v[j] < v[m]) {
                    m = j;
                }
            }
            if (DEBUGGING && n < 10) {
                debugPrint(Arrays.toString(v));
                debugPrint("i=" + i + ", m=" + m);
            }
            // swap v[i] and v[m]
            int temp = v[i];
            v[i] = v[m];
            v[m] = temp;
        }
    }
 }
