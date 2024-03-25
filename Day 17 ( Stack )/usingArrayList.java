import java.util.*;

public class usingArrayList {

  public static class Stack {
    ArrayList<Integer> list = new ArrayList<>();

    public boolean isEmpty() {
      return list.size() == 0;
    }

    // push
    public void push(int n) {
      list.addLast(n);
    }

    // pop
    public int pop() {
      if (isEmpty()) {
        return Integer.MIN_VALUE;
      }
      int top = list.size() - 1;
      int data = list.get(top);
      list.remove(top);
      return data;
    }

    // peek
    public int peek() {
      if (isEmpty()) {
        return Integer.MIN_VALUE;
      }
      return list.get(list.size() - 1);
    }
  }

  public static void main(String[] args) {

    Stack s = new Stack();
    s.push(8);
    s.push(3);
    s.push(5);
    while (!s.isEmpty()) {
      System.out.println(s.pop());
    }

  }
}
