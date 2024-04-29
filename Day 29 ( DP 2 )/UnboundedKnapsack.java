public class UnboundedKnapsack {

  public static int knapsack(int[] val, int[] wt, int W, int n) {
    if (W == 0 || n == 0) {
      return 0;
    }
    if (wt[n - 1] <= W) {// valid
      int ans1 = val[n - 1] + knapsack(val, wt, W - wt[n - 1], n);// include
      int ans2 = knapsack(val, wt, W, n - 1);// exclude
      return Math.max(ans1, ans2);
    } else {
      return knapsack(val, wt, W, n - 1);
    }
  }

  public static int knapsackMemo(int[] val, int[] wt, int dp[][], int W, int n) {
    if (W == 0 || n == 0) {
      return 0;
    }
    if (dp[n][W] != -1) {
      return dp[n][W];
    }
    if (wt[n - 1] <= W) {// valid
      int ans1 = val[n - 1] + knapsackMemo(val, wt, dp, W - wt[n - 1], n);// include
      int ans2 = knapsackMemo(val, wt, dp, W, n - 1);// exclude
      dp[n][W] = Math.max(ans1, ans2);
      return dp[n][W];

    } else {
      dp[n][W] = knapsackMemo(val, wt, dp, W, n - 1);
      return dp[n][W];
    }
  }

  public static int knapsackTab(int[] val, int[] wt, int W, int n) {
    int[][] dp = new int[val.length + 1][W + 1];
    for (int i = 0; i < dp.length; i++) {
      dp[i][0] = 0;

    }
    for (int j = 0; j < dp[0].length; j++) {
      dp[0][j] = 0;
    }

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        int v = val[i - 1];
        int w = wt[i - 1];
        if (w <= j) {
          dp[i][j] = Math.max(v + dp[i][j - w], dp[i - 1][j]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    print(dp);
    return dp[n][W];

  }

  public static void print(int[][] dp) {
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int[] val = { 15, 14, 10, 45, 30 };
    int[] wt = { 2, 5, 1, 3, 4 };
    int W = 7;
    int[][] dp = new int[val.length + 1][W + 1];
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        dp[i][j] = -1;
      }
    }
    System.out.println(knapsackTab(val, wt, W, wt.length));
    System.out.println(knapsack(val, wt, W, wt.length));
    System.out.println(knapsackMemo(val, wt, dp, W, wt.length));
  }
}
