public class MP {
  // minimum partitioning or minimum subset sum difference or partioning subsets
  // given an array of n positive integers , the task is to divide the array into
  // two sets such that the absolute difference between sums of two partitions is
  // minimum

  public static int minDiff(int arr[]) {
    int n = arr.length;
    int sum = 0;
    for (int i = 0; i < arr.length; i++)
      sum += arr[i];
    int w = sum / 2;
    int[][] dp = new int[n + 1][w + 1];
    for (int i = 1; i < n + 1; i++) {
      for (int j = 0; j < w + 1; j++) {
        if (arr[i - 1] <= j) {
          dp[i][j] = Math.max(arr[i - 1] + dp[i - 1][j - arr[i - 1]], dp[i - 1][j]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    int sum1 = dp[n][w];
    int sum2 = sum - sum1;
    return Math.abs(sum1 - sum2);
  }

  // if difference 0 possible return true else false
  public static boolean diff0(int arr[]) {
    int n = arr.length;
    int sum = 0;
    for (int i = 0; i < arr.length; i++)
      sum += arr[i];
    int w = sum / 2;
    int[][] dp = new int[n + 1][w + 1];
    for (int i = 1; i < n + 1; i++) {
      for (int j = 0; j < w + 1; j++) {
        if (arr[i - 1] <= j) {
          dp[i][j] = Math.max(arr[i - 1] + dp[i - 1][j - arr[i - 1]], dp[i - 1][j]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    double sum1 = dp[n][w];
    return sum1 == (double) sum / 2;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 6 };
    System.out.println(minDiff(arr));
    System.out.println(diff0(arr));

  }

}
