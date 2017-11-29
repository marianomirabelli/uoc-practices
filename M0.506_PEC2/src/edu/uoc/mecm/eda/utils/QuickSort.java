package edu.uoc.mecm.eda.utils;

import java.util.Comparator;

/*************************************************************************
 *  Compilation:  javac QuickX.java
 *  Execution:    java QuickX N
 *  
 *  Uses the Bentley-McIlroy 3-way partitioning scheme,
 *  chooses the partitioning element using Tukey's ninther,
 *  and cuts off to insertion sort.
 *
 *  Reference: Engineering a Sort Function by Jon L. Bentley
 *  and M. Douglas McIlroy. Softwae-Practice and Experience,
 *  Vol. 23 (11), 1249-1265 (November 1993).
 *
 *************************************************************************/

/**
 *  The <tt>QuickX</tt> class provides static methods for sorting an
 *  array using an optimized version of quicksort (using Bentley-McIlroy
 *  3-way partitioning, Tukey's ninther, and cutoff to insertion sort).
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/21elementary">Section 2.1</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class QuickSort {
    private static final int CUTOFF = 8;  // cutoff to insertion sort, must be >= 1



    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param <T>
     * @param a the array to be sorted
     */
    public static <T extends Comparable> void sort(T[] a) {
        sort(a, 0, a.length - 1,null);
    }
    
    /**
     * Rearranges the array in ascending order, using the order established by comp.
     * @param <T>
     * @param a the array to be sorted
     */
    public static <T extends Comparable> void sort(T[] a, Comparator<T> comp) {
        sort(a, 0, a.length - 1,comp);
    }

    private static <T extends Comparable> void sort(T[] a, int lo, int hi,Comparator<T> comp) { 
        int N = hi - lo + 1;

        // cutoff to insertion sort
        if (N <= CUTOFF) {
            insertionSort(a, lo, hi,comp);
            return;
        }

        // use median-of-3 as partitioning element
        else if (N <= 40) {
            int m = median3(a, lo, lo + N/2, hi,comp);
            exch(a, m, lo);
        }

        // use Tukey ninther as partitioning element
        else  {
            int eps = N/8;
            int mid = lo + N/2;
            int m1 = median3(a, lo, lo + eps, lo + eps + eps,comp);
            int m2 = median3(a, mid - eps, mid, mid + eps,comp);
            int m3 = median3(a, hi - eps - eps, hi - eps, hi,comp); 
            int ninther = median3(a, m1, m2, m3,comp);
            exch(a, ninther, lo);
        }

        // Bentley-McIlroy 3-way partitioning
        int i = lo, j = hi+1;
        int p = lo, q = hi+1;
        T v = a[lo];
        while (true) {
            while (less(a[++i], v,comp))
                if (i == hi) break;
            while (less(v, a[--j],comp))
                if (j == lo) break;

            // pointers cross
            if (i == j && eq(a[i], v,comp))
                exch(a, ++p, i);
            if (i >= j) break;

            exch(a, i, j);
            if (eq(a[i], v,comp)) exch(a, ++p, i);
            if (eq(a[j], v,comp)) exch(a, --q, j);
        }


        i = j + 1;
        for (int k = lo; k <= p; k++) exch(a, k, j--);
        for (int k = hi; k >= q; k--) exch(a, k, i++);

        sort(a, lo, j,comp);
        sort(a, i, hi,comp);
    }


    // sort from a[lo] to a[hi] using insertion sort
    private static <T extends Comparable> void insertionSort(T[] a, int lo, int hi, Comparator<T> comp) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1],comp); j--)
                exch(a, j, j-1);
    }


    // return the index of the median element among a[i], a[j], and a[k]
    private static <T extends Comparable> int median3(T[] a, int i, int j, int k, Comparator<T> comp) {
        return (less(a[i], a[j], comp) ?
               (less(a[j], a[k], comp) ? j : less(a[i], a[k],comp) ? k : i) :
               (less(a[k], a[j], comp) ? j : less(a[k], a[i],comp) ? k : i));
    }

   /***********************************************************************
    *  Helper sorting functions
 * @param <T>
    ***********************************************************************/
    
    // is v < w ?
    private static <T extends Comparable> boolean less(T v, T w, Comparator<T> comp) {
    	return ( comp == null ? v.compareTo(w) < 0 : comp.compare(v, w)<0 );
    }

    // does v == w ?
    private static <T extends Comparable> boolean eq(T v, T w, Comparator<T> comp) {
    	return ( comp == null ? v.compareTo(w) == 0 : comp.compare(v, w)==0 );
    }
        
    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


   /***********************************************************************
    *  Check if array is sorted - useful for debugging
 * @param <T>
    ***********************************************************************/
    private static <T extends Comparable> boolean isSorted(T[] a, Comparator<T> comp) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1],comp)) return false;
        return true;
    }

}
