

import java.util.Arrays;

public class SortingTest {

    /* --------------------------------------------------------------- */
    /* INSERTION SORT */
    public static void insertionSort(int[] array) {
        int currentIndex = 1; // Current index for the comparisons

        while (currentIndex < array.length) {
            // Performs one step of insertion sort
            int key = array[currentIndex];
            int j = currentIndex - 1;

            // Shift elements larger than key to the right
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;

            currentIndex++; // Move to the next element for sorting
        }
    }
    /* --------------------------------------------------------------- */
    
    /* --------------------------------------------------------------- */
    /* MERGE SORT */
    public static void mergeSort(int[] array) {
        if (array.length < 2) return; // Base case for recursion
    
        // Split the array into two halves
        int mid = array.length / 2;
        int[] left = java.util.Arrays.copyOfRange(array, 0, mid);
        int[] right = java.util.Arrays.copyOfRange(array, mid, array.length);
    
        // Recursively sort each half
        mergeSort(left);
        mergeSort(right);
    
        // Merge the sorted halves
        merge(array, left, right);
    }
    
    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
    
        // Merge elements from both halves in sorted order
        while (i < left.length && j < right.length) {
            array[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        }
    
        // Copy remaining elements, if any
        while (i < left.length) array[k++] = left[i++];
        while (j < right.length) array[k++] = right[j++];
    }
    /* --------------------------------------------------------------- */
    
    /* --------------------------------------------------------------- */
    /* QUICK SORT */
    public static void quickSort(int[] array, int low, int high) {
        if (low >= high) return; // Base case
    
        int pivotIndex = partition(array, low, high);
        quickSort(array, low, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, high);
    }
    
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Pivot as last element
        int i = low;
    
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                swap(array, i++, j); // Move smaller element to left
            }
        }
        swap(array, i, high); // Place pivot in correct position
        return i;
    }
    
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    /* --------------------------------------------------------------- */
     
    // Main function to run the program
    public static void main(String[] args) {
        int[] items = {150, 68, 77, 90, 110, 80, 50, 200, 135, 40};
        System.out.println (Arrays.toString(items));
        insertionSort(items);
        //  mergeSort(items);  //uncomment to test 
        //  quickSort(items, 0, items.length-1);  //uncomment to test         
        System.out.println (Arrays.toString(items));
    }
}