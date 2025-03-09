package edu.grinnell.csc207.sortslab;

import java.util.Arrays;

/**
 * A collection of sorting algorithms over generic arrays.
 */
public class Sorts {

    /**
     * Swaps indices <code>i</code> and <code>j</code> of array
     * <code>arr</code>.
     *
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
        int ret = lo + (hi - lo) / 2;
        while (lo < hi && arr[ret] != value) {
            if (arr[ret] < value) {
                lo = ret + 1;
                ret = (hi + lo) / 2;
            } else {
                hi = ret;
                ret = (hi + lo) / 2;
            }
        }

        if (arr[ret] != value) {
            ret = -1;
        }

        return ret;
    }

    public static <T extends Comparable<? super T>> int binarySearchT(T value, T[] arr, int lo, int hi) {
        int ret = lo + (hi - lo) / 2;
        if (lo > hi) {
            return -1;
        } else {

            while (lo < hi && arr[ret] != value) {
                if (value.compareTo(arr[ret]) < 0) {
                    lo = ret;
                    ret = (hi + lo) / 2;
                } else {
                    hi = ret;
                    ret = (hi + lo) / 2;
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
     *
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * Sorts the array according to the selection sort algorithm:
     * <pre>
     * [ i smallest elements in order | unprocessed ]
     * </pre>
     *
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void selectionSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int k = i; k < arr.length; k++) {
                if (arr[k].compareTo(arr[min]) < 0) {
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
     *
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void insertionSort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j].compareTo(arr[j - 1]) < 0) {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }

    public static <T extends Comparable<? super T>> T[] merge(T[] arr1, T[] arr2) {
        T[] arr3 = Arrays.copyOf(arr1, arr1.length + arr2.length);
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i].compareTo(arr2[j]) < 0) {
                arr3[k] = arr1[i];
                k++;
                i++;
            } else {
                arr3[k] = arr2[j];
                k++;
                j++;
            }
        }
        while (i < arr1.length) {
            arr3[k] = arr1[i];
            k++;
            i++;
        }
        while (j < arr2.length) {
            arr3[k] = arr2[j];
            k++;
            j++;
        }

        return arr3;
    }

    /**
     * Sorts the array according to the merge sort algorithm:
     * <pre>
     * [ sorted | sorted ] -> [ sorted ]
     * </pre>
     *
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     * @return
     */
    public static <T extends Comparable<? super T>> T[] mergeSortHelper(T[] arr) {
        if (arr.length > 1) {
            return merge(mergeSortHelper(Arrays.copyOfRange(arr, 0, (arr.length / 2))),
                    mergeSortHelper(Arrays.copyOfRange(arr, arr.length / 2, arr.length)));
        } else {
            return arr;
        }

    }

    /**
     * Sorts the array according to the merge sort algorithm:
     * <pre>
     * [ sorted | sorted ] -> [ sorted ]
     * </pre>
     *
     * @param <T> the carrier type of the array
     * @param arr the array to sort
     */
    public static <T extends Comparable<? super T>> void mergeSort(T[] arr) {
        T[] arrTmp = Arrays.copyOf(arr, arr.length);
        if (arr.length > 1) {
            arrTmp = Arrays.copyOf(merge(mergeSortHelper(Arrays.copyOfRange(arr, 0, (arr.length / 2))),
                    mergeSortHelper(Arrays.copyOfRange(arr, arr.length / 2, arr.length))), arr.length);
        }
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arrTmp[i];
        }

    }

    /**
     * Sorts the array according to the quick sort algorithm:
     * <pre>
     * []
     * </pre>
     *
     * @param <T>
     * @param arr
     */
    public static <T extends Comparable<? super T>> void quickSort(T[] arr, int lo, int hi) {
        int med = hi;

        int left = lo;

        int right;

        if (hi > 0) {
            right = hi - 1;
        } else {
            right = left;
        }

        while (left < right) {
            if (arr[left].compareTo(arr[med]) > 0 && arr[right].compareTo(arr[med]) <= 0) {
                swap(arr, left, right);
            } else {
                if (arr[left].compareTo(arr[med]) < 0) {
                    left++;
                } else if (arr[right].compareTo(arr[med]) >= 0) {
                    right--;
                }

            }
        }
        if (arr[left].compareTo(arr[med]) > 0) {
            swap(arr, med, left);
        } else {
            left++;
        }

        if (hi - lo > 1) {
            if (left > 0){
                quickSort(arr, lo, (left - 1));
            }
            quickSort(arr, left, hi);
        }

    }

    /**
     * Sorts the array according to the quick sort algorithm:
     * <pre>
     * []
     * </pre>
     *
     * @param <T>
     * @param arr
     */
    public static <T extends Comparable<? super T>> void quickSort(T[] arr) {
        int med = arr.length - 1;

        int left = 0;

        int right;

        if (arr.length > 1) {
            right = arr.length - 2;
        } else {
            right = left;
        }

        while (left < right) {

            if (arr[left].compareTo(arr[med]) > 0 && arr[right].compareTo(arr[med]) <= 0) {
                swap(arr, left, right);
            } else {
                if (arr[left].compareTo(arr[med]) < 0) {
                    left++;
                } else if (arr[right].compareTo(arr[med]) >= 0) {
                    right--;
                }
                

            }

        }
        if (arr[left].compareTo(arr[med]) > 0) {
            swap(arr, med, left);
        } else {
            left++;
        }
        
        if (arr.length > 1) {
            if (left > 0){
                quickSort(arr, 0, (left - 1));
            }
            quickSort(arr, left, arr.length - 1);
        }


    }

    public static void main(String[] args) {
        Integer[] arr = {3, 7, 9, 1, 2,
            18, 16, 15, 19, 8,
            14, 12, 5, 13, 4,
            6, 0, 17, 11, 10};

        quickSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
