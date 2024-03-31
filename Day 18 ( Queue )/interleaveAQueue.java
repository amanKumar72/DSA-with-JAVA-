import java.util.*;

public class interleaveAQueue {
  public static void interleave(Queue<Integer> q) {
    Queue<Integer> q1 = new LinkedList<>();
    int s=q.size()/2;
    for(int i=0;i<s;i++){
      q1.add(q.remove());
    }
    while (!q1.isEmpty()) {
      q.add(q1.remove());
      q.add(q.remove());
    }

  }

  public static void main(String[] args) {
    Queue<Integer> q = new LinkedList<>();
    for (int i = 1; i <= 10; i++) {
      q.add(i);
    }

    interleave(q);
    // System.out.println(q.size());
    while (!q.isEmpty()) {
      System.out.println(q.remove());
    }
  }
}
