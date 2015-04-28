package inda6;

import java.util.function.BiConsumer;

public interface ISort {
    /**
     * Sorts the array into ascending numerical order.
     */
    void sort(int[] v);
    
    void specsort(int[] v, int first, int last);
    
    //void setAlg(ISort sortAlg);
    
    void setAlg(ISort alg);
}