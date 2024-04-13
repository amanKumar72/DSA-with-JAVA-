import java.util.*;

public class HeapDataStructure {

  static class MinHeap {
    ArrayList<Integer> arr = new ArrayList<>();

    public void add(int data) {
      arr.add(data);
      int childIndex = arr.size() - 1;
      int parentIndex = (childIndex - 1) / 2;
      while (arr.get(childIndex) < arr.get(parentIndex)) {
        int temp = arr.get(childIndex);
        arr.set(childIndex, arr.get(parentIndex));
        arr.set(parentIndex, temp);
        childIndex = parentIndex;
        parentIndex = (childIndex - 1) / 2;
      }
    }

    public boolean isEmpty() {
      return arr.size() == 0;
    }

    public int peek() {
      return arr.get(0);
    }

    private void heapify(int i) {
      int right = 2 * i + 2;
      int left = 2 * i + 1;
      int min = i;
      if (left < arr.size() && arr.get(left) < arr.get(min)) {
        min = left;
      }
      if (right < arr.size() && arr.get(right) < arr.get(min)) {
        min = right;
      }

      if (min != i) {
        int temp = arr.get(min);
        arr.set(min, arr.get(i));
        arr.set(i, temp);
        heapify(min);

      }

    }

    public int remove() {
      int t = arr.get(0);
      arr.set(0, arr.get(arr.size() - 1));
      arr.set(arr.size() - 1, t);
      arr.remove(arr.size() - 1);
      heapify(0);

      return t;
    }
  }

  static class MaxHeap {
    ArrayList<Integer> arr = new ArrayList<>();

    public void add(int data) {
      arr.add(data);
      int childIndex = arr.size() - 1;
      int parentIndex = (childIndex - 1) / 2;
      while (arr.get(childIndex) > arr.get(parentIndex)) {
        int temp = arr.get(childIndex);
        arr.set(childIndex, arr.get(parentIndex));
        arr.set(parentIndex, temp);
        childIndex = parentIndex;
        parentIndex = (childIndex - 1) / 2;
      }
    }

    public boolean isEmpty() {
      return arr.size() == 0;
    }

    public int peek() {
      return arr.get(0);
    }

    private void heapify(int i) {
      int right = 2 * i + 2;
      int left = 2 * i + 1;
      int max = i;
      if (left < arr.size() && arr.get(left) > arr.get(max)) {
        max = left;
      }
      if (right < arr.size() && arr.get(right) > arr.get(max)) {
        max = right;
      }

      if (max != i) {
        int temp = arr.get(max);
        arr.set(max, arr.get(i));
        arr.set(i, temp);
        heapify(max);

      }

    }

    public int remove() {
      int t = arr.get(0);
      arr.set(0, arr.get(arr.size() - 1));
      arr.set(arr.size() - 1, t);
      arr.remove(arr.size() - 1);
      heapify(0);

      return t;
    }
  }

  public static void heapify(int[] arr, int i, int size) {
    int right = 2 * i + 2;
    int left = 2 * i + 1;
    int max = i;
    if (left < size && arr[left] > arr[max]) {
      max = left;
    }
    if (right < size && arr[right] > arr[max]) {
      max = right;
    }
    if (max != i) {
      int temp = arr[i];
      arr[i] = arr[max];
      arr[max] = temp;
      heapify(arr, max, size);
    }
  }

  public static void heapSort(int[] arr) {
    int n = arr.length;
    // step 1 Create Max heap
    for (int i = n / 2; i >= 0; i--) {
      heapify(arr, i, n);
    }
    // step 2 push largest element at last
    for (int i = n - 1; i > 0; i--) {
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;
      heapify(arr, 0, i);
    }

  }

  // nearest k cars
  public static class Point implements Comparable<Point> {
    int x;
    int y;
    int dist;
    int indx;

    public Point(int x, int y, int dist, int indx) {
      this.x = x;
      this.y = y;
      this.dist = dist;
      this.indx = indx;

    }

    @Override
    public int compareTo(Point p2) {
      return this.dist - p2.dist;
    }
  }

  // connect n ropes at min cost
  public static int connectNRopes(int[] a) {
    PriorityQueue<Integer> ropes = new PriorityQueue<>();
    for (int i = 0; i < a.length; i++) {
      ropes.add(a[i]);
    }
    int cost = 0;
    while (ropes.size() > 1) {
      int min = ropes.remove();
      int min2 = ropes.remove();
      cost += min + min2;
      ropes.add(min + min2);
    }
    return cost;
  }

  // K weakest Soldier
  static class Soldiers implements Comparable<Soldiers> {
    int noOfSoldiers;
    int indx;

    public Soldiers(int noOfSoldiers, int indx) {
      this.noOfSoldiers = noOfSoldiers;
      this.indx = indx;
    }

    @Override
    public int compareTo(Soldiers S2) {
      if (this.noOfSoldiers == S2.noOfSoldiers) {
        return this.indx - S2.indx;
      } else {
        return this.noOfSoldiers - S2.noOfSoldiers;
      }
    }

  }

  // Sliding window maximum
  static class info implements Comparable<info> {
    int data;
    int indx;

    public info(int data, int indx) {
      this.data = data;
      this.indx = indx;
    }

    @Override
    public int compareTo(info i2) {
      return i2.data - this.data;
    }
  }

  public static void main(String[] args) {
    // MinHeap hp = new MinHeap();
    MaxHeap hp = new MaxHeap();
    hp.add(1);
    hp.add(2);
    hp.add(4);
    hp.add(5);
    hp.add(3);
    System.out.println(hp.arr);
    System.out.println(hp.remove());
    System.out.println(hp.remove());

    int[] a = { 1, 2, 4, 5, 3 };
    heapSort(a);
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }

    // k nearest cars
    int[][] points = { { 3, 3 }, { 5, -1 }, { 2, -4 } };
    int k = 3;
    PriorityQueue<Point> pq = new PriorityQueue<>();
    for (int i = 0; i < points.length; i++) {
      int distsq = points[i][0] * points[i][0] + points[i][1] * points[i][1];
      pq.add(new Point(points[i][0], points[i][1], distsq, i));
    }
    System.out.println();
    for (int i = 0; i < k; i++) {
      System.out.println("Car " + pq.remove().indx);
    }
    // connect n ropes at min cost
    int ropes[] = { 4, 3, 3, 2, 6 };
    System.out.println(connectNRopes(ropes));
    ;

    // K weakest Soldier
    int[][] sol = { { 1, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 } };
    PriorityQueue<Soldiers> soldiers = new PriorityQueue<>();
    for (int i = 0; i < sol.length; i++) {
      int noOfSoldiers = 0;
      for (int j = 0; j < sol[0].length; j++) {
        noOfSoldiers += sol[i][j];
      }
      soldiers.add(new Soldiers(noOfSoldiers, i));
    }
    for (int i = 0; i < k; i++) {
      System.out.println("Row" + soldiers.remove().indx);
    }

    // Sliding window max of k size
    PriorityQueue<info> PQ = new PriorityQueue<>();
    int arr[] = { 1,3,-1,-3,5,3,6,7 };
    int res[]=new int[arr.length-k+1];
    for(int i=0;i<k;i++){
      PQ.add(new info(arr[i], i));
    }
    res[0]=PQ.peek().data;
    for(int i=k;i<arr.length;i++){
      while (pq.size()>0&&pq.peek().indx<=(i-k)) {
        PQ.remove();
      }
      PQ.add(new info(arr[i], i));
      res[i-k+1]=PQ.peek().data;
    }
    for(int i=0;i<res.length;i++){
      System.out.print(res[i]+" ");
    }
  }
}
