
public class usingLinkList {
  static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  static class Stack {
    static Node head = null;
    int size;

    public boolean isEmpty() {
      return head == null;
    }

    // push
    public void push(int n) {
      Node newNode = new Node(n);
      if (isEmpty()) {
        head = newNode;
        size++;
        return;
      }
      newNode.next = head;
      head = newNode;
      size++;
    }

    // pop
    public int pop() {
      if (isEmpty()) {
        return Integer.MIN_VALUE;
      }
      int data = head.data;
      head = head.next;
      size--;
      return data;
    }

    // peek
    public int peek() {
      if (isEmpty()) {
        return Integer.MIN_VALUE;
      }
      return head.data;
    }
  }

  public static void main(String[] args) {
    Stack stack = new Stack();
    stack.push(0);
    stack.push(5);
    stack.push(8);
    stack.push(1);
    while (stack.size != 0) {
      System.out.println(stack.pop());
    }
    // System.out.println(stack.size);

  }
}
