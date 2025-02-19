import java.util.Random;

public class binarySearch {
    public static void main(String[] args) {
        int length = 9;
        int[] array = new int[length];
        Random rand = new Random(); // Create a Random object
        array[0] = rand.nextInt(10); // Start with a small random number
        for (int i = 1; i < length; i++) {
            array[i] = array[i - 1] + rand.nextInt(10) + 1; // Ensure increasing order
        }
        int target = array[rand.nextInt(length)]; // Random number from 1 to 100
        System.out.println("Array: " + java.util.Arrays.toString(array) + "\nTarget: " + target);

        int mid, left = 0, right = length - 1;

        while (left <= right){
            mid = left + (right - left) / 2;
            if (array[mid] == target){
                System.out.println("Target found at index " + mid);
                break;
            }
            else if (array[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
    }
}
