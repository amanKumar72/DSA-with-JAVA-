import java.util.*;

public class MaximumWater {
  public static int maxWater(ArrayList<Integer> height) {
    int maxwater = 0;
    int lp = 0, rp = height.size() - 1;
    while (lp < rp) {
      maxwater = Math.max(maxwater, (rp - lp) * Math.min(height.get(lp), height.get(rp)));
      if (height.get(lp) < height.get(rp)) {
        lp++;
      } else {
        rp--;
      }
    }

    return maxwater;
  }

  public static void main(String[] args) {
    ArrayList<Integer> height = new ArrayList<>();
    height.add(1);
    height.add(8);
    height.add(6);
    height.add(2);
    height.add(5);
    height.add(3);
    height.add(8);
    height.add(3);
    height.add(7);
    System.out.println(maxWater(height));
  }
}
