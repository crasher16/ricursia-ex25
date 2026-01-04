package ex1;
import unit4.collectionsLib.Queue;

public class ex25_sortQueue {

    // Function to sort queue of strings in alphabetical order (ascending)
    public static void sortQueue(Queue<String> q) {
        if (q.isEmpty()) {
            return;
        }
        
        // Move all elements to a temporary queue and count them
        Queue<String> temp = new Queue<>();
        int size = 0;
        
        while (!q.isEmpty()) {
            temp.insert(q.remove());
            size++;
        }
        
        // Selection sort: find minimum and build sorted queue
        for (int i = 0; i < size; i++) {
            // Find minimum in temp
            String min = findMin(temp);
            
            // Remove one occurrence of minimum from temp and add to result
            removeOne(temp, min);
            q.insert(min);
        }
    }
    
    // Helper function: Find minimum string in queue without destroying it
    private static String findMin(Queue<String> q) {
        Queue<String> temp = new Queue<>();
        String min = q.remove();
        temp.insert(min);
        
        while (!q.isEmpty()) {
            String current = q.remove();
            temp.insert(current);
            
            if (current.compareTo(min) < 0) {
                min = current;
            }
        }
        
        // Restore queue
        while (!temp.isEmpty()) {
            q.insert(temp.remove());
        }
        
        return min;
    }
    
    // Helper function: Remove one occurrence of value from queue
    private static void removeOne(Queue<String> q, String value) {
        Queue<String> temp = new Queue<>();
        boolean removed = false;
        
        while (!q.isEmpty()) {
            String current = q.remove();
            
            if (!removed && current.equals(value)) {
                removed = true;
            } else {
                temp.insert(current);
            }
        }
        
        // Restore remaining elements
        while (!temp.isEmpty()) {
            q.insert(temp.remove());
        }
    }
    
    // Helper function to print queue without destroying it
    public static void printQueue(Queue<String> q) {
        Queue<String> temp = new Queue<>();
        System.out.print("Queue: [");
        
        boolean first = true;
        while (!q.isEmpty()) {
            String value = q.remove();
            temp.insert(value);
            if (!first) System.out.print(", ");
            System.out.print(value);
            first = false;
        }
        System.out.println("]");
        
        // Restore queue
        while (!temp.isEmpty()) {
            q.insert(temp.remove());
        }
    }
    
    public static void main(String[] args) {
        // Test case 1: Regular unsorted queue
        System.out.println("Test 1: Unsorted strings");
        Queue<String> q1 = new Queue<>();
        q1.insert("Zebra");
        q1.insert("Apple");
        q1.insert("Mango");
        q1.insert("Banana");
        q1.insert("Cherry");
        
        System.out.print("Before: ");
        printQueue(q1);
        
        sortQueue(q1);
        
        System.out.print("After:  ");
        printQueue(q1);
        System.out.println();
        
        // Test case 2: Already sorted
        System.out.println("Test 2: Already sorted");
        Queue<String> q2 = new Queue<>();
        q2.insert("Apple");
        q2.insert("Banana");
        q2.insert("Cherry");
        
        System.out.print("Before: ");
        printQueue(q2);
        
        sortQueue(q2);
        
        System.out.print("After:  ");
        printQueue(q2);
        System.out.println();
        
        // Test case 3: Reverse sorted
        System.out.println("Test 3: Reverse sorted");
        Queue<String> q3 = new Queue<>();
        q3.insert("Zebra");
        q3.insert("Mango");
        q3.insert("Cherry");
        q3.insert("Banana");
        q3.insert("Apple");
        
        System.out.print("Before: ");
        printQueue(q3);
        
        sortQueue(q3);
        
        System.out.print("After:  ");
        printQueue(q3);
        System.out.println();
        
        // Test case 4: Single element
        System.out.println("Test 4: Single element");
        Queue<String> q4 = new Queue<>();
        q4.insert("Hello");
        
        System.out.print("Before: ");
        printQueue(q4);
        
        sortQueue(q4);
        
        System.out.print("After:  ");
        printQueue(q4);
        System.out.println();
        
        // Test case 5: Two elements
        System.out.println("Test 5: Two elements");
        Queue<String> q5 = new Queue<>();
        q5.insert("Zoo");
        q5.insert("Ant");
        
        System.out.print("Before: ");
        printQueue(q5);
        
        sortQueue(q5);
        
        System.out.print("After:  ");
        printQueue(q5);
        System.out.println();
        
        // Test case 6: Case sensitivity
        System.out.println("Test 6: Mixed case strings");
        Queue<String> q6 = new Queue<>();
        q6.insert("orange");
        q6.insert("Apple");
        q6.insert("grape");
        q6.insert("Banana");
        
        System.out.print("Before: ");
        printQueue(q6);
        
        sortQueue(q6);
        
        System.out.print("After:  ");
        printQueue(q6);
    }
}


