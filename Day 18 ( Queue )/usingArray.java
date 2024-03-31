public class usingArray {
  public static class Queue {
    static int data[];
    static int f = -1, r = -1, size;

    Queue(int size) {
      data = new int[size];
      this.size = size;
    }

    public static boolean isEmpty() {
      return r == -1;
    }

    public static boolean isFull() {
      return r >= size - 1;
    }

    // add
    public static void add(int n) {
      if (isFull()) {
        System.out.println("queue is full");
      }
      data[++r] = n;
    }

    // remove
    public static int remove() {
      if (isEmpty()) {
        System.out.println("Queue is Empty");
        return Integer.MIN_VALUE;
      }
      int item = data[0];
      r--;
      for (int i = 0; i < data.length - 1; i++) {
        data[i] = data[i + 1];
      }
      return item;
    }

    // peek
    public static int peek() {
      if (isEmpty()) {
        System.out.println("Queue is Empty");
        return -1;
      }
      int item = data[0];
      return item;
    }
  }

  public static class CircularQueue {
    static int data[];
    static int f = -1, r = -1, size;

    CircularQueue(int size) {
      data = new int[size];
      this.size = size;
    }

    public static boolean isEmpty() {
      return r == -1;
    }

    public static boolean isFull() {
      return f == (r + 1) % size;
    }

    // add
    public static void add(int n) {
      if (isFull()) {
        System.out.println("queue is full");
      }
      if (isEmpty()) {
        r = f = 0;
      } else {
        r = (r + 1) % size;
      }
      data[r] = n;
    }

    // remove
    public static int remove() {
      if (isEmpty()) {
        System.out.println("Queue is Empty");
        return Integer.MIN_VALUE;
      }
      int item = data[f];
      if (r == f) {
        r = f = -1;
        return item;
      }
      f = (f + 1) % size;
      return item;
    }

    // peek
    public static int peek() {
      if (isEmpty()) {
        System.out.println("Queue is Empty");
        return -1;
      }
      int item = data[f];
      return item;
    }
  }

  public static void main(String[] args) {
    CircularQueue q = new CircularQueue(6);
    q.add(3);
    q.add(3);
    q.add(2);
    q.add(1);
    q.add(2);
    q.add(3);
    while (q.peek() != -1) {
      System.out.println(q.remove());

    }

  }
}
