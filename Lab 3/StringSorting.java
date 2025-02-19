import java.util.Arrays;

public class StringSorting {

    /* --------------------------------------------------------------- */
    /* INSERTION SORT */
    public static void insertionSort(String[] array) {
        int currentIndex = 1; // Current index for the comparisons

        while (currentIndex < array.length) {
            // Performs one step of insertion sort
            String key = array[currentIndex];
            int j = currentIndex - 1;

            // Shift elements larger than key to the right
            while (j >= 0 && array[j].compareTo(key) > 0) { // comparison function is updated
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
    public static void mergeSort(String[] array) {
        if (array.length < 2) return; // Base case for recursion
    
        // Split the array into two halves
        int mid = array.length / 2;
        String[] left = java.util.Arrays.copyOfRange(array, 0, mid);
        String[] right = java.util.Arrays.copyOfRange(array, mid, array.length);
    
        // Recursively sort each half
        mergeSort(left);
        mergeSort(right);
    
        // Merge the sorted halves
        merge(array, left, right);        
    }
    
    private static void merge(String[] array, String[] left, String[] right) {
        int i = 0, j = 0, k = 0;
    
        // Merge elements from both halves in sorted order
        while (i < left.length && j < right.length) {
            array[k++] = (left[i].compareTo(right[j]) <= 0) ? left[i++] : right[j++];
        }
    
        // Copy remaining elements, if any
        while (i < left.length) array[k++] = left[i++];
        while (j < right.length) array[k++] = right[j++];
    }
    /* --------------------------------------------------------------- */
    
    /* --------------------------------------------------------------- */
    /* QUICK SORT */
    
    public static void quickSort(String[] array, int low, int high) {
        if (low >= high) return; // Base case
    
        int pivotIndex = partition(array, low, high);
        quickSort(array, low, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, high);


    }
    
    private static int partition(String[] array, int low, int high) {
        String pivot = array[high]; // Pivot as last element
        int i = low;
    
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                swap(array, i++, j); // Move smaller element to left
            }
        }
        swap(array, i, high); // Place pivot in correct position
        return i;

    }
    
    private static void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    /* --------------------------------------------------------------- */
     
    // Main function to run the program
    public static void main(String[] args) {
        String[] items = {"table", "desk", "chair", "radio", "car", "house", "glass", "book"};
        System.out.println (Arrays.toString(items));
        //insertionSort(items);
        //mergeSort(items);  //uncomment to test 
          quickSort(items, 0, items.length-1);  //uncomment to test 
        System.out.println (Arrays.toString(items));
    }
}