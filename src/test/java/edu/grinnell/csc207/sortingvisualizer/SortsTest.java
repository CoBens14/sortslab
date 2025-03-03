package edu.grinnell.csc207.sortingvisualizer;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.sortslab.Sorts;

public class SortsTest {
    /**
     * @param <T> the carrier type of the array
     * @param arr the array to check
     * @return true iff <code>arr</code> is sorted.
     */
    public static <T extends Comparable<? super T>> boolean sorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i+1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static Integer[] makeTestArray() {
        return new Integer[] {
            3, 7, 9, 1, 2,
            18, 16, 15, 19, 8,
            14, 12, 5, 13, 4,
            6, 0, 17, 11, 10
        };
    }

    public void testSort(Consumer<Integer[]> func) {
        Integer[] arr = makeTestArray();
        func.accept(arr);
        assertTrue(sorted(arr));
    }

    @Test
    public void testBubbleSort() {
        testSort(Sorts::bubbleSort);
    }
    
    @Test
    public void testInsertionSort() {
        testSort(Sorts::insertionSort);
    }
    
    @Test
    public void testSelectionSort() {
        testSort(Sorts::selectionSort);
    }

    @Test
    public void testMergeSort() {
        testSort(Sorts::mergeSort);
    }
    
    @Test
    public void testQuickSort() {
        testSort(Sorts::quickSort);
    }

    @Test
    public void testBinarySearch() {
        int[] arr1 = {1, 4, 6, 7, 9, 10, 12, 34};
        assertEquals(2, Sorts.binarySearch(6, arr1, 0, 8));
    }

    @Test
    public void testBinarySearch2() {
        int[] arr1 = {1, 4, 6, 7, 9, 10, 12, 34, 56};
        assertEquals(4, Sorts.binarySearch(9, arr1, 0, 9));
    }

    @Test
    public void testBinarySearch3() {
        int[] arr1 = {1, 4, 6, 7, 9, 10, 12, 34, 56};
        assertEquals(-1, Sorts.binarySearch(11, arr1, 0, 9));
    }
}
