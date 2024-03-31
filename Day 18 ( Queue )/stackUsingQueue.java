import java.util.*;

public class stackUsingQueue {

  // push in O(n) and pop in O(1)
  public static class Stack1 {
    Queue<Integer> q1 = new ArrayDeque<>();
    Queue<Integer> q2 = new ArrayDeque<>();

    public boolean isEmpty() {
      return q1.isEmpty();
    }

    // push
    public void push(int n) {
      while (!q1.isEmpty()) {
        q2.add(q1.remove());
      }
      q1.add(n);
      while (!q2.isEmpty()) {
        q1.add(q2.remove());
      }
    }

    // pop
    public int pop() {
      return q1.remove();
    }

    // peek
    public int peek() {
      return q1.peek();
    }
  }

  // push in O(1) and pop in O(n)
  public static class Stack2 {
    Queue<Integer> q1 = new ArrayDeque<>();
    Queue<Integer> q2 = new ArrayDeque<>();

    public boolean isEmpty() {
      return q1.isEmpty();
    }

    // push
    public void push(int n) {
      q1.add(n);
    }

    // pop
    public int pop() {
      if (q1.isEmpty()) {
        System.out.println("Stack is empty");
        return -1;
      }
      int item = -1;
      while (!q1.isEmpty()) {
        item = q1.remove();
        if (q1.isEmpty()) {
          break;
        }
        q2.add(item);
      }
      while (!q2.isEmpty()) {
        q1.add(q2.remove());
      }
      return item;
    }

    // peek
    public int peek() {
      if (q1.isEmpty()) {
        System.out.println("Stack is empty");
        return -1;
      }
      int item = -1;
      while (!q1.isEmpty()) {
        item = q1.remove();
        q2.add(item);
      }
      while (!q2.isEmpty()) {
        q1.add(q2.remove());
      }
      return item;
    }
  }

  public static void main(String[] args) {
    Stack2 s = new Stack2();
    s.push(1);
    s.push(2);
    s.push(3);
    while (!s.isEmpty()) {
      System.out.println(s.pop());
    }
  }
}
