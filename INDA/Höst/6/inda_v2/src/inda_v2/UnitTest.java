package inda_v2;

import static org.junit.Assert.*;

import java.util.Random;

import inda_v2.*;

import org.junit.Test;

public class UnitTest {

	@Test
	public void factorialTest() {
		for (int i = 0; i <= 20; i++) {
			if(factorial(i) != fact(i))
				fail("Not equal at n=" + i);
		}
		
	}
	@Test
	public void sumTest()
	{
		int[] array = new int [50];
		for (int i = 0; i < 50; i++) 
		{
			array[i] = randInt(0, 20);
		}
		
		int min = randInt(0, 25);
		int max = randInt(26, 49);
		if(sum(array, min, max) != Sum(array, min, max))
		{
			fail("Not equal at min=" + min + " and max=" + max);
		}
	}
	
	@Test
	public void	maxValueInVectorTest()
	{
		int[] array = new int [50];
		for (int i = 0; i < 50; i++) 
		{
			array[i] = randInt(0, 20);
		}
		
		int max = maxValueInVector(array);
		
		System.out.println(max);
		
		int _max = maxValueInVectorRecursive(array, array.length-1);
		
		if(max != _max)
			fail("Max values not equal. Test 1");
		
		int[] vec = {3,2,1,5};
		
		if(maxValueInVector(vec) != maxValueInVectorRecursive(vec, vec.length -1))
			fail("Max value not equal. Test 2");
		
		System.out.println(_max);
	}
	
	public long factorial(int n)
	{
		long result = 1;
		
		for (int i = 1; i <= n; i++)
		{
			if(i == 0)
			{
				result = 1;
			}
			else
			{
				result *=i;
			}
		}
		return result;
	}
	
	public long fact(int n) {
	    if (n == 0) {
	        return 1;
	    } else {   // n > 0
	        return n*fact(n - 1);
	    }
	}
	
	
	public long sum (int[] v, int first, int last)
	{
		if(first == last)
			return v[first];
		else
		{
			long result = 0;
			
			for (int i = first; i <= last; i++)
			{
				result += v[i];
			}
			
			return result;
		}
	}
	
	public long Sum(int[] v, int first, int last) {
	    if (first == last) {
	        return v[first];
	    } else {   // first < last
	        return v[first] + Sum(v, first + 1, last);
	    }
	}
	
	/**
	 * Finds the maximum value in a vector recursively.
	 * @param vector The vector.
	 * @param v The length of the vector, i.e. vector.length.
	 * @return The maximum value.
	 */
	public int maxValueInVectorRecursive(int[] vector, int v)
	{
		if (v == 0)
		{
			return vector[0];
		}
		else
		{
			int temp = maxValueInVectorRecursive(vector, v-1);
			if(vector[v]  >  temp)
			{
				return vector[v];
			}
			else
			{
				return temp;
			}	
		}	
	}
	
	/**
	 * Finds the maximum value in a vector using iteration.
	 * @param vector The vector.
	 * @return The maximum value.
	 */
    public int maxValueInVector(int[] vector)
    {
    	int maxValue = Integer.MIN_VALUE;
    	
    	for(int value : vector)
    	{
    		if(value > maxValue)
    			maxValue = value;
    	}
    	
    	return maxValue;
    }
	
	public int randInt(int min, int max) {

	    // NOTE: Usually this should be a field rather than a method
	    // variable so that it is not re-seeded every call.
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}



}
