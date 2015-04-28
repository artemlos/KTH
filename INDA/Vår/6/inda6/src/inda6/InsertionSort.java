package inda6;

public class InsertionSort implements ISort {
	
	/**
	 * Insertion sort from Inda 2014.
	 * @param v
	 */	
	public void sort(int[] v)
	{
		specsort(v, 0, v.length);
	}

    public void specsort(int[] v, int first, int last)
    {
    	for (int j = first + 1; j < last; j++)
    	{
			int key = v[j];
			int i = j-1;
			
			while(i>= first && v[i] > key)
			{
				v[i+1] = v[i];
				i--;
			}
			v[i+1] = key;
		}
    }
    
    public void setAlg(ISort sort)
    {
    	
    }
}
