public class usingLinkList {
  public static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
    }
  }

  public static class Queue {
    Node rear = null, front = null;

    // empty
    public boolean isEmpty() {
      return rear == null;
    }

    // add
    public void add(int n) {
      Node newNode = new Node(n);
      if (isEmpty()) {
        front = rear = newNode;
      }
      rear.next = newNode;
      rear = newNode;
    }

    // remove
    public int remove() {
      if (isEmpty()) {
        System.out.println("Queue is empty");
        return -1;
      }
      int item = front.data;
      if (rear == front) {
        rear = front = null;
        return item;
      }
      front = front.next;
      return item;
    }

    // peek
    public int peek() {
      if (isEmpty()) {
        System.out.println("Queue is empty");
        return -1;
      }
      int item = front.data;
      return item;
    }

  }

  public static void main(String[] args) {
    Queue q = new usingLinkList.Queue();
    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);
    while (!q.isEmpty()) {
      System.out.println(q.remove());

    }
  }
}
