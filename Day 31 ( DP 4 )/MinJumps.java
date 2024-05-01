import java.util.Arrays;

public class MinJumps {
  public static int minjumps(int[] arr) {
    int n = arr.length;
    int[] dp = new int[n];
    Arrays.fill(dp, -1);
    dp[n - 1] = 0;
    for (int i = n - 2; i >= 0; i--) {
      int steps = arr[i];
      int min = Integer.MAX_VALUE;
      for (int j = i + 1; j <= i + steps && j < n; j++) {
        if (dp[j] != -1) {
          min = Math.min(min, 1 + dp[j]);
        }
      }
      if (min != Integer.MAX_VALUE) {
        dp[i] = min;
      }
    }
    return dp[0];
  }

  public static void main(String[] args) {
    int[] arr = { 2, 3, 1, 1, 4 };
    System.out.println(minjumps(arr));
  }

}
