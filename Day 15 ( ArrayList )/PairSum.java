import java.util.*;

public class PairSum {
  public static boolean oneSum(ArrayList<Integer> list, int target) {
    int n = list.size();
    int lp = 0, rp = n - 1, x, y;
    while (lp != rp) {
      x = list.get(lp);
      y = list.get(rp);
      if (x + y == target) {
        return true;
      } else if (x + y > target) {
        rp--;
      } else {
        lp++;
      }
    }
    return false;
  }

  public static boolean twoSum(ArrayList<Integer> list, int target) {
    int n = list.size(), i;
    for (i = 0; i < n; i++) {
      if (list.get(i) < list.get(i + 1)) {
        break;
      }
    }
    int lp = i, rp = (n + (i - 1)) % n, x, y;
    while (lp != rp) {
      x = list.get(lp);
      y = list.get(rp);
      if (x + y == target) {
        return true;
      } else if (x + y > target) {
        rp = (rp - 1 + n) % n;
      } else {
        lp = (lp + 1) % n;
      }
    }
    return false;
  }

  public static void main(String[] args) {

    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);

    System.out.println(twoSum(list, 9)); // true
    System.out.println(twoSum(list, 19));
  }

}
