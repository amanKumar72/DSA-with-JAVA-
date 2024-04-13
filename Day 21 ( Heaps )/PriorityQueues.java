import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueues {
  public static void main(String[] args) {
    PriorityQueue<Integer> pqAsc = new PriorityQueue<>();
    // for ascending pq
    pqAsc.add(3);
    pqAsc.add(1);
    pqAsc.add(6);
    pqAsc.add(2);
    while (!pqAsc.isEmpty()) {
      System.out.print(pqAsc.remove()+" ");
    }
    // for desendind pq
    PriorityQueue<Integer> pqDes = new PriorityQueue<>(Comparator.reverseOrder());
    pqDes.add(3);
    pqDes.add(1);
    pqDes.add(6);
    pqDes.add(2);
    while (!pqDes.isEmpty()) {
      System.out.print(pqDes.remove()+" ");
    }
  }
}