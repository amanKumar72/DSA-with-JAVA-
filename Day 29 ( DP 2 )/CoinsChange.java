public class CoinsChange {
  public static int getWays(int[] coins, int sum) {
    int n = coins.length;
    int[][] dp = new int[n + 1][sum + 1];// create
    for (int i = 0; i < n + 1; i++) {// initialize
      dp[i][0] = 1;// only one to take nothing if n==0 then there is no way i.e. dp[0][i]=0 by
                   // default in java
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < sum + 1; j++) {
        if (coins[i - 1] <= j) {// valid
          dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];// include ways +exclude ways
        } else {// invalid
          dp[i][j] = dp[i - 1][j];// exclude
        }
      }
    }
    return dp[n][sum];
  }

  public static void main(String[] args) {
    int[] coins = { 2, 5, 3, 6 };
    int sum = 10;
    System.out.println(getWays(coins, sum));

  }
}
