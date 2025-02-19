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
        //TODO: Complete this part

        
    }
    
    private static void merge(String[] array, String[] left, String[] right) {
        //TODO: Complete this part


    }
    /* --------------------------------------------------------------- */
    
    /* --------------------------------------------------------------- */
    /* QUICK SORT */
    public static void quickSort(String[] array, int low, int high) {
        //TODO: Complete this part


    }
    
    private static int partition(String[] array, int low, int high) {
        //TODO: Complete this part
        

    }
    
    private static void swap(String[] array, int i, int j) {
        //TODO: Complete this part
               

    }
    /* --------------------------------------------------------------- */
     
    // Main function to run the program
    public static void main(String[] args) {
        String[] items = {"table", "desk", "chair", "radio", "car", "house", "glass", "book"};
        System.out.println (Arrays.toString(items));
        insertionSort(items);
        //  mergeSort(items);  //uncomment to test 
        //  quickSort(items, 0, items.length-1);  //uncomment to test 
        System.out.println (Arrays.toString(items));
    }
}