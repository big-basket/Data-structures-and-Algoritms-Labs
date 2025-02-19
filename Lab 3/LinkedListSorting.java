import java.util.LinkedList;

public class LinkedListSorting {

    // Merge Sort for LinkedList
    public static LinkedList<Integer> mergeSort(LinkedList<Integer> list) {
        if (list.size() < 2) return list; // Base case for recursion

        // Split the list into two halves
        int mid = list.size() / 2;
        LinkedList<Integer> left = new LinkedList<>(list.subList(0, mid));
        LinkedList<Integer> right = new LinkedList<>(list.subList(mid, list.size()));

        // Recursively sort both halves and merge
        return merge(mergeSort(left), mergeSort(right));
    }

    // Merge two sorted LinkedLists
    private static LinkedList<Integer> merge(LinkedList<Integer> left, LinkedList<Integer> right) {
        LinkedList<Integer> merged = new LinkedList<>();

        // Merge by comparing the first elements of both lists
        while (!left.isEmpty() && !right.isEmpty()) {
            merged.add(left.peek() <= right.peek() ? left.poll() : right.poll());
        }

        // Add any remaining elements
        merged.addAll(left);
        merged.addAll(right);

        return merged;
    }

    // Main function to test
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(3);
        list.add(15);
        list.add(7);
        list.add(8);
        list.add(2);

        System.out.println("Original Linked List: " + list);

        LinkedList<Integer> sortedList = mergeSort(list);

        System.out.println("Sorted Linked List: " + sortedList);
    }
}