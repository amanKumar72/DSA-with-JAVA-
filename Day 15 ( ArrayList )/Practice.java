import java.util.*;

public class Practice {

  // Q1? check monotic or not : a series is monotonic increasing if for all i<=j
  // list.get(i)<=list.get(j)
  // : a series is monotonic decreasing if for all i<=j list.get(i)>=list.get(j)
  public static boolean motonicDec(ArrayList<Integer> list) {
    for (int i = 0; i < list.size() - 1; i++) {
      if (list.get(i) < list.get(i + 1)) {
        return false;
      }
    }
    return true;
  }

  public static boolean motonicInc(ArrayList<Integer> list) {
    for (int i = 0; i < list.size() - 1; i++) {
      if (list.get(i) > list.get(i + 1)) {
        return false;
      }
    }
    return true;
  }

  public static boolean monotonic(ArrayList<Integer> list) {
    return motonicDec(list) || motonicInc(list);
  }

  // Q2? Lonely number in a arrayList : a number is lonely number if for x there
  // is no (x-1) and (x+1) in the list
  public static boolean isLonely(ArrayList<Integer> list, int num) {
    return (!list.contains(num + 1)) && (!list.contains(num - 1)); // return true if x-1 and x+1 both are not exist
  }

  static int num = 0;

  public static void lonelyNumbers(ArrayList<Integer> list) {
    for (int i = 0; i < list.size(); i++) {
      num = list.get(i);
      if (isLonely(list, num)) {
        System.out.println(num);
      }
    }
  }

  // Most frequient no
  public int mostFrequent(ArrayList<Integer> nums, int key) {
    int[] result = new int[1000];
    for (int i = 0; i < nums.size() - 1; i++) {
      if (nums.get(i) == key) {
        result[nums.get(i + 1) - 1]++;
      }
    }
    int max = Integer.MIN_VALUE;
    int ans = 0;
    for (int i = 0; i < 1000; i++) {
      if (result[i] > max) {
        max = result[i];
        ans = i + 1;
      }
    }
    return ans;
  }

  
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(19);
    list.add(2);
    list.add(4);
    list.add(5);
    list.add(6);
    list.add(9);
    lonelyNumbers(list);
    System.out.println(monotonic(list));
    Collections.sort(list, Collections.reverseOrder());
    System.out.println(monotonic(list));
  }
}