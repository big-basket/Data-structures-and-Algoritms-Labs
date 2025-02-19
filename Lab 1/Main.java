import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner myObj = new Scanner(System.in) // Create a Scanner object
        ) {
            System.out.println("Enter array");
            String userArrayInput = myObj.nextLine();  // Read user input
            String[] userArrayConverted = userArrayInput.split(",");
            System.out.println("array is: " + Arrays.toString(userArrayConverted));  // Output user input
            int[] intArray = Arrays.stream(userArrayConverted).mapToInt(Integer::parseInt).toArray();
            int min = Arrays.stream(intArray).min().getAsInt();
            int max = Arrays.stream(intArray).max().getAsInt();
    
            // printing minimum and maximum numbers
            System.out.println("Minimum number of array is : " + min);
            System.out.println("Maximum number of array is : " + max);
            int intArraySum = sum(intArray, intArray.length);
            System.out.println("Sum of array is : " + intArraySum);
            for (int i = 0; i < intArray.length / 2; i++) {
                int t = intArray[i];
                intArray[i] = intArray[intArray.length - 1 - i];
                intArray[intArray.length - 1 - i] = t;
            }
    
            System.out.println("Reverse of the array is: " + Arrays.toString(intArray));
        }
    }
    static int sum(int[] arr, int n)
    {

        // base or terminating condition
        if (n <= 0) {
            return 0;
        }

        // Calling method recursively
        return sum(arr, n - 1) + arr[n - 1];
    }
}
