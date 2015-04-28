package inda6;

import java.util.Random;

public class QuickSortRandPivot implements ISort {
	
	private ISort sortingAlg;
	public int K = 10;
	
	public void sort(int[] v)
	{
		specsort(v, 0, v.length-1);
	}
	public void specsort(int[] v, int first, int last) {
		
	    if (first >= last) // Less than two elements
	        return;

	    
		if (last-first < K)
		{
			//perform insertion sort.
			//InsertionSort sorter = new InsertionSort();
			if(sortingAlg != null)
				sortingAlg.specsort(v, first, last);
			
		}
		
	    // Choose a pivot element.
		Random rn = new Random();
	    int p = v[rn.nextInt(last-first) + first];

	    // Partition the elements so that every number of
	    // v[first..mid] <= p and every number of v[mid+1..last] > p.
	    int[] mid = partition(v, first, last, p);

	    specsort(v, first, mid[0]);
	    specsort(v, mid[1], last); // removed  +1
	}
	
	public int[] partition(int[] v, int first, int last, int pivot) {
	    int low = first;
	    int mid = first;
	    int high = last;

	    while (mid <= high) {
	        // Invariant:
	        //  - v[first..low-1] < pivot
	        //  - v[low..mid-1] = pivot
	        //  - v[mid..high] are unknown
	        //  - v[high+1..last] > pivot
	        //
	        //       < pivot   = pivot      unknown     > pivot
	        //     -----------------------------------------------
	        // v: |          |          |a            |           |
	        //     -----------------------------------------------
	        //     ^          ^          ^           ^           ^
	        //    first      low        mid         high        last
	        //
	        int a = v[mid];
	        if (a < pivot) {
	            v[mid] = v[low];
	            v[low] = a;
	            low++;
	            mid++;
	        } else if (a == pivot) {
	            mid++;
	        } else { // a > pivot
	            v[mid] = v[high];
	            v[high] = a;
	            high--;
	        }
	    }
	    return new int[]{low,mid};
	}
	
	@Override
	public void setAlg(ISort alg) {
		this.sortingAlg = alg;
		
	}
	public void setK(int k)
	{
		this.K = k;
	}
}
