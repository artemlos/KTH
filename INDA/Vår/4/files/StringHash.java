package inda4;

import java.util.List;
import java.util.LinkedList;

/**
 * A hash table of strings.
 * 
 * @author Stefan Nilsson
 * @version 2010-07-21
 */
public class StringHash implements StringDictionary { 
    private List<String>[] table;

    /**
     * Creates a hash table with the given capacity.
     * 
     * @throws IllegalArgumentException if capacity <= 0.
     */
    public StringHash(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("capacity=" + capacity);

        // We want to do the following:
        //
        //     table = new LinkedList<String>[capacity];
        //
        // However, that won't compile ("generic array creation")
        // since Java generics and arrays don't get along very well.
        // Instead we need to do the following:
        //
        //     table = new LinkedList[capacity];
        //
        // The above will compile, but with a warning. The proper
        // approach is to document why the warning can be safely
        // ignored and then suppress the warning. Thus:

        /* 
         * This array will contain only LinkedList<String>
         * instances, all created in the add method. This
         * is sufficient to ensure type safety.
         */
        @SuppressWarnings("unchecked") // for this declaration only
        List<String>[] t = new LinkedList[capacity];
        
        table = t;
    }

    /**
     * Adds the given string to this dictionary.
     * Returns <code>true</code> if the dictionary
     * did not already contain the given string.
     *
     * Complexity: O(1) expected time.
     */
    @Override
    public boolean add(String s) {
        int hashCode = getIndex(s);
        
        List<String> ls = table[hashCode];
        
        if(ls == null)
        {
        	ls = new LinkedList<String>();
        	ls.add(s);
        	table[hashCode] = ls;
        	
        	return true;
        }
        else
        {
        	ls.add(s);
        	table[hashCode] = ls; // do we need this extra reference?
        	
        	return false;
        }
    }

    /**
     * Removes the given string from this dictionary
     * if it is present. Returns <code>true</code> if
     * the dictionay contained the specified element.
     *
     * Complexity: O(1) expected time.
     */
    @Override
    public boolean remove(String s) {
        
    	int hashCode = getIndex(s);
    	
        List<String> ls = table[hashCode];
        
        if(ls == null)
        	return false;
        
        return ls.remove(s);
    }

    /**
     * Returns <code>true</code> if the string is
     * in this dictionary.
     *
     * Complexity: O(1) expected time.
     */
    @Override
    public boolean contains(String s) {
        
    	int hashCode = getIndex(s);
    	
        List<String> ls = table[hashCode];
        
        if(ls == null)
        	return false;
        
        return ls.contains(s);
    }
    
    private int abs(int x)
    {
    	if(x < 0)
    		return -x;
    	return x;
    }
    
    private int getIndex(String s)
    {
    	return abs(s.hashCode() % table.length);
    }
}
