import java.util.*;

public class fractionalKnapsack {
  public static void main(String[] args) {
    int value[] = { 60, 100, 120 };
    int weight[] = { 10, 20, 30 };
    int W = 50;

    double ratio[][] = new double[value.length][2];

    for (int i = 0; i < value.length; i++) {
      ratio[i][0] = i;
      ratio[i][1] = value[i] / (double) weight[i];
    }

    Arrays.sort(ratio, Comparator.comparingDouble(c -> c[1]));  

    int totalValue = 0;
    int capacity = W;

    for (int i = ratio.length - 1; i >= 0; i--) {
      int indx=(int)ratio[i][0];
      if (capacity >= weight[indx]) {
        totalValue += value[indx];
        capacity -= weight[indx];
      } else {
        totalValue +=( ratio[i][1] * capacity);
        capacity=0;
        break;
      }
    }
    System.out.println("Maximum total value = " + totalValue);
  }

}
