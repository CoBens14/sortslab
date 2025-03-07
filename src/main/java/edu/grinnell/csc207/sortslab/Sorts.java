package edu.grinnell.csc207.sortslab;

import java.util.Arrays;

/**
 * A collection of sorting algorithms over generic arrays.
 */
public class Sorts {
    /**
     * Swaps indices <code>i</code> and <code>j</code> of array <code>arr</code>.
     * @param <T> the carrier type of the array
     * @param arr the array to swap
     * @param i the first index to swap
     * @param j the second index to swap
     */
    public static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

/**
     * Sorts the array according to the binary search algorithm:
     *
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static int binarySearch(int value, int[] arr, int lo, int hi) {
        int ret = lo + (hi - lo)/ 2;
        while (lo < hi && arr[ret] != value) {
            if (arr[ret] < value) {
                lo = ret + 1;
                ret = (hi + lo)/ 2;
            } else {
                hi = ret;
                ret = (hi + lo)/ 2;
            }
        }

        if (arr[ret] != value) {
            ret = -1;
        }

        return ret;
    }

    public static <T extends Comparable<? super T>> int binarySearchT(T value, T[] arr, int lo, int hi) {
        int ret = lo + (hi - lo)/ 2;
        if (lo > hi) {
            return -1;
        } else {
        
        while (lo < hi && arr[ret] != value) {
            if (value.compareTo(arr[ret]) < 0) {
                lo = ret;
                ret = (hi + lo)/ 2;
            } else {
                hi = ret;
                ret = (hi + lo)/ 2;
            }
        }
    }   
        if (arr[ret] != value) {
            ret = -1;
        }

        return ret;
    }

    /**
     * Sorts the array according to the bubble sort algorithm:
     * <pre>
     * [ unprocessed | i largest elements in order ]
     * </pre>
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void bubbleSort(T[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length -1; j++) {
                if(arr[j].compareTo(arr[j+1]) > 0) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    /**
     * Sorts the array according to the selection sort algorithm:
     * <pre>
     * [ i smallest elements in order | unprocessed ]
     * </pre>
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void selectionSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int k = i; k < arr.length; k++) {
                if(arr[k].compareTo(arr[min]) < 0) {
                    min = k;
                }
            }
            swap(arr, i, min);
        }
    }

    /**
     * Sorts the array according to the insertion sort algorithm:
     * <pre>
     * [ i elements in order | unprocessed ] 
     * </pre>
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void insertionSort(T[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int j = i;
            while(j > 0 && arr[j].compareTo(arr[j-1]) < 0) {
                swap(arr, j, j-1);
                j--;
            }
        }
    }
    


    public static <T extends Comparable<? super T>> T[] merge(T[] arr1, T[] arr2) {
        int i = 0, k = 0;

        int j = 0;
        T[] arrFinal = Arrays.copyOf(arr1, arr1.length + arr2.length);
        while (i < arr1.length && k < arr2.length) {
            if (arr1[i].compareTo(arr2[k]) < 0) {
                arrFinal[j] = arr1[i];
                j++;
                i++;
            } else {
                arrFinal[j] = arr1[k];
                j++;
                k++;
            }
        }
            while (i < arr1.length) {
                arrFinal[j] = arr1[i];
                j++;
                i++;
            }

            while (k < arr1.length) {
                arrFinal[j] = arr1[k];
                j++;
                k++;
            }
        return arrFinal;
    }


    /**
     * Sorts the array according to the merge sort algorithm:
     * <pre>
     * [ sorted | sorted ] -> [ sorted ]
     * </pre>
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void mergeSort(T[] arr) {
       
        if (arr.length > 1) {
            

        } else {
            
        }
        
    }

/**
     * Sorts the array according to the quick sort algorithm:
     * <pre>
     * []
     * </pre>
     * @param <T>
     * @param arr
     */
    public static <T extends Comparable<? super T>> void quickSort(T[] arr, int lo, int hi) {
        int med = arr.length - 1;

        int left = 0, right = arr.length - 2;

        while (left != right) {
            if (arr[left].compareTo(arr[med]) > 0 && arr[right].compareTo(arr[med]) <= 0) {
                swap(arr, left, right);
            }

            if (arr[left].compareTo(arr[med]) < 0) {
                left++;
            }

            if (arr[right].compareTo(arr[med]) >= 0) {
                right++;
            }
        }
        if (hi - lo == 0) {
            quickSort(arr, (lo + left), (left - 1));
            quickSort(arr, left, hi);
        }

    }

    /**
     * Sorts the array according to the quick sort algorithm:
     * <pre>
     * []
     * </pre>
     * @param <T>
     * @param arr
     */
    public static <T extends Comparable<? super T>> void quickSort(T[] arr) {
        int med = arr.length - 1;

        int left = 0, right = arr.length - 2;

        while (left != right) {
            if (arr[left].compareTo(arr[med]) > 0 && arr[right].compareTo(arr[med]) <= 0) {
                swap(arr, left, right);
            }

            if (arr[left].compareTo(arr[med]) < 0) {
                left++;
            }

            if (arr[right].compareTo(arr[med]) >= 0) {
                right++;
            }
        }
        if (arr.length > 1) {
            quickSort(arr, 0, (left - 1));
            quickSort(arr, left, arr.length - 1);
        }

    }


}
