public class MaxProfit {
  public static int maxProfit(int prices[]) {
    int BP = prices[0];
    int profit = 0;
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] > BP) {
        profit = Math.max(profit, prices[i] - BP);
      } else {
        BP = prices[i];
      }
    }
    return profit;

  }

  public static void main(String[] args) {
    int prices[] = { 7, 5, 3,2 };
    int profit = maxProfit(prices);
    System.out.println(profit);
  }
}