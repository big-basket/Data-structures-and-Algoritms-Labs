

public class LinkedListLab {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        
        list.add(10);
        list.add(20);
        list.add(30);

        System.out.print(list.search(20) + "\n"); // Expected Output: 1
        

        list.print(); // Expected Output: 10 -> 20 -> 30
    }
}

// MyLinkedList class
class MyLinkedList {
    private Node head; // Head node of the list

    // Constructor
    public MyLinkedList() {
        this.head = null; // Initially, the list is empty
    }

    // Method to add a node at the end
    public void add(int data) {
        Node newNode = new Node(data); // Create a new node
    
        // If the list is empty, set newNode as the head
        if (head == null) {
            head = newNode;
            return;
        }
    
        // Traverse to the last node
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
    
        // Link the last node to the new node
        current.next = newNode;
    }

    // Method to print the linked list
    public void print() {
        Node current = head; // Start from the head
        while (current != null) {
            System.out.print(current.data + " "); // Print the data
            current = current.next; // Move to the next node
        }
        System.out.println(); // Move to the next line
    }

    // Method to search for an element in the list
    public int search(int target) {
        int mid, left = 0, right = size() - 1;
        int[] array = toArray();
        int index = -1;

        while (left <= right){
            mid = left + (right - left) / 2;
            if (array[mid] == target){
                index = mid;
                break;
            }
            else if (array[mid] < target){
                left = mid + 1;
                System.out.println("Moving right");
            }
            else{
                right = mid - 1;
                System.out.println("Moving left");
            }
        }
        return index; 
    }

    // Method to delete a node at a given index
    public void deleteAtIndex(int index) {
        
    }

    // Method to delete a node by value
    public void deleteByValue(int value) {
        
    }

    private int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    private int[] toArray() {
        int[] arr = new int[size()];
        Node current = head;
        int index = 0;
        while (current != null) {
            arr[index] = current.data;
            index++;
            current = current.next;
        }
        return arr;
    }
}

// Node class
class Node {
    int data;
    Node next;

    // Constructor
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
