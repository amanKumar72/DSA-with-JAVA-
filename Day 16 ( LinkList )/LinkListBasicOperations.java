import java.util.*;

public class LinkListBasicOperations {

  public static void main(String[] args) {
    LinkedList<Integer> ll = new LinkedList<>();
    ll.add(1);
    ll.add(2);
    ll.add(4);
    ll.add(5);
    ll.add(2, 3);
    System.out.println(ll);
    ll.addFirst(0);
    ll.addLast(2);
    ll.addLast(2);
    System.out.println(ll);
    System.out.println("2 is present " + ll.contains(2));
    System.out.println("Value at Index 1 = " + ll.get(1));// output 1
    System.out.println("First element = " + ll.getFirst());
    System.out.println("Last element = " + ll.getLast());
    System.out.println("index of 2 = " + ll.indexOf(2));
    System.out.println("last occurance of 2 at index = " + ll.lastIndexOf(2));
    System.out.println("size = " + ll.size());
    ll.remove();
    System.out.println(ll);
    ll.remove(2);
    ll.removeFirst();
    ll.removeLast();
    System.out.println(ll);
    ll.removeFirstOccurrence(2);
    ll.removeLastOccurrence(2);
    ll.set(0, 1);// remove and set value at index 0 element 1
    System.out.println(ll);
  }
}
