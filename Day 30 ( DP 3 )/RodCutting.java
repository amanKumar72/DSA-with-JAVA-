public class RodCutting {
  public static void main(String[] args) {
    int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 }; // price of the rod in different lengths
    int[] length = { 1, 2, 3, 4, 5, 6, 7, 8 };
    int rodLength = 8;
    int[][] dp = new int[length.length + 1][rodLength + 1];// create
    for (int i = 0; i < dp.length; i++) { // initialize
      for (int j = 0; j < dp[0].length; j++) {
        dp[i][j] = -1;
      }
    }
    for (int i = 0; i < dp.length; i++) {
      dp[i][0] = 0;
    }
    for (int j = 0; j < dp[0].length; j++) {
      dp[0][j] = 0;
    }

    for (int i = 1; i < length.length + 1; i++) {// fill
      for (int j = 1; j < rodLength + 1; j++) {
        if (length[i - 1] <= j) {
          dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    System.out.println(dp[length.length][rodLength]);
  }
}