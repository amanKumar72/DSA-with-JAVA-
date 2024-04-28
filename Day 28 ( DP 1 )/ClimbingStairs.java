
public class ClimbingStairs {

  public static int countWays(int n) {
    if (n == 0 || n == 1) {
      return 1;// no of ways =1
    }
    return countWays(n - 1) + countWays(n - 2); // recursively calling the function to get no.of ways for (n-1) and
                                                // (n-2)
  }

  public static int countWaysMemoization(int n, int dp[]) {
    if (n == 0 || n == 1) {
      return 1;// no of ways =1
    }
    dp[n] = countWaysMemoization(n - 1, dp) + countWaysMemoization(n - 2, dp);// store
    return dp[n];
  }

  public static int countWaysTabulation(int n) {
    int[] dp = new int[n + 1];// create
    dp[0] = dp[1] = 1;// initialize
    for (int i = 2; i <= n; i++) {// meaning
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  public static void main(String[] args) {
    int n = 6;
    System.out.println(countWays(n));
    System.out.println(countWaysMemoization(n, new int[n + 1]));
    System.out.println(countWaysTabulation(n));
  }
}
