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

    private static void testSort(java.util.function.Consumer<String[]> method) {
        String[] items = {"table", "desk", "chair", "radio", "car", "house", "glass", "book"};
        String[] emptyArray = {};
        String[] singleElementArray = {"single"};
        String[] alreadySortedArray = {"apple", "banana", "cherry", "date"};
        String[] reverseSortedArray = {"zebra", "yak", "xenon", "wolf"};
        String[] identicalElementsArray = {"same", "same", "same", "same"};
        
        System.out.println("-------------------------------------------------");
        System.out.println("Sorting using " + method);  
        System.out.println("Original: " + Arrays.toString(items));
        method.accept(items);
        System.out.println("Sorted: " + Arrays.toString(items));
        System.out.println();
        
        System.out.println("Original: " + Arrays.toString(emptyArray));
        method.accept(emptyArray);
        System.out.println("Sorted: " + Arrays.toString(emptyArray));
        System.out.println();
        
        System.out.println("Original: " + Arrays.toString(singleElementArray));
        method.accept(singleElementArray);
        System.out.println("Sorted: " + Arrays.toString(singleElementArray));
        System.out.println();
        
        System.out.println("Original: " + Arrays.toString(alreadySortedArray));
        method.accept(alreadySortedArray);
        System.out.println("Sorted: " + Arrays.toString(alreadySortedArray));
        System.out.println();
        
        System.out.println("Original: " + Arrays.toString(reverseSortedArray));
        method.accept(reverseSortedArray);
        System.out.println("Sorted: " + Arrays.toString(reverseSortedArray));
        System.out.println();
        
        System.out.println("Original: " + Arrays.toString(identicalElementsArray));
        method.accept(identicalElementsArray);
        System.out.println("Sorted: " + Arrays.toString(identicalElementsArray));
        System.out.println();
        
        System.out.println("-------------------------------------------------");
    }
    /* --------------------------------------------------------------- */
     
    // Main function to run the program
    public static void main(String[] args) {
        testSort(StringSorting::insertionSort);
        testSort(StringSorting::mergeSort);
        testSort(array -> quickSort(array, 0, array.length - 1));
    }
}