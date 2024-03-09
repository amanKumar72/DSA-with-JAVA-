import java.util.*;

public class Basic {

  public static void swap(ArrayList<Integer> list, int indx1, int indx2) {
    int temp = list.get(indx1);
    list.set(indx1, list.get(indx2));
    list.set(indx2, temp);
  }

  public static void main(String[] args) {

    ArrayList<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    System.out.println(list);
    System.err.println(list.size());
    System.out.println(list.get(2));
    // System.out.println(list.remove(2));
    System.out.println(list.contains(4));
    list.add(1, 6);
    System.out.println(list);
    Collections.sort(list, Collections.reverseOrder());
    System.out.println(list);
    swap(list, 2, 4);
    System.out.println(list);

    // MD ArrayList
    ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
    ArrayList<Integer> subList1 = new ArrayList<>();
    ArrayList<Integer> subList2 = new ArrayList<>();
    ArrayList<Integer> subList3 = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
      subList1.add(i * 1);
      subList2.add(i * 2);
      subList3.add(i * 3);
    }
    mainList.add(subList1);
    mainList.add(subList2);
    mainList.add(subList3);
    System.out.println(mainList);
  }
}
