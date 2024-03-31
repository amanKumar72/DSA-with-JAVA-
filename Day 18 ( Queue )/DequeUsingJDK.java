import java.util.*;

public class DequeUsingJDK {
  public static void main(String[] args) {
    Deque<Integer> deque = new LinkedList<>();
    deque.addFirst(2); // Add element at the beginning of the queue
    deque.addLast(3); // Add element at the end of the queue
    deque.addFirst(1);
    deque.addLast(4);
    System.out.println(deque + " ");
    deque.removeFirst(); // Remove and return the first element from the queue
    deque.removeLast(); // Remove and return the last element from the queue
    System.out.println(deque);
    System.out.println("First Element " + deque.getFirst());
    System.out.println("Last Element " + deque.getLast());

  }
}
