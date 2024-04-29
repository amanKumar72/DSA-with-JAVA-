public class TargetSumSubset {
  public static boolean targetSum(int[] nums, int sum, int i) {
    if (sum == 0) {
      return true;
    }
    if (i == -1) {
      return false;
    }
    if (nums[i] <= sum) {
      return targetSum(nums, sum - nums[i], i - 1);
    } else {
      return targetSum(nums, sum, i - 1);
    }
  }

  public static boolean targetSumMemo(int[] nums, int sum, Boolean[][] dp, int i) {
    if (sum == 0) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    if (dp[i][sum] != null) {
      return dp[i][sum];
    }
    if (nums[i - 1] <= sum) {
      dp[i][sum] = targetSum(nums, sum - nums[i - 1], i - 1);
      return dp[i][sum];
    } else {
      dp[i][sum] = targetSum(nums, sum, i - 1);
      return dp[i][sum];
    }
  }

  public static boolean targetSumTab(int[] nums, int sum) {
    boolean[][] dp = new boolean[nums.length + 1][sum + 1];// create
    for (int i = 0; i < dp.length; i++) {// initialize
      dp[i][0] = true;
    }
    // fill
    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        int n = nums[i - 1];
        if (n <= j && dp[i - 1][j - n] == true) {
          // include
          dp[i][j] = true;
        } else if (dp[i - 1][j] == true) {
          dp[i][j] = true;
        }
      }
    }
    print(dp);
    return dp[nums.length][sum];
  }

  public static int sum(int[] arr) {
    int Sum = 0;
    for (int I = 0; I < arr.length; I++) {
      Sum += arr[I];
    }
    return Sum;
  }

  public static void print(boolean[][] dp) {
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        System.out.print(dp[i][j] + "  ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int[] nums = { 4, 2, 7, 1, 3 };
    int sum = 17;
    Boolean[][] dp = new Boolean[nums.length + 1][sum + 1];// create
    for (int i = 0; i < dp.length; i++) {// initialize
      dp[i][0] = true;
    }
    for (int i = 0; i < dp[0].length; i++) {// initialize
      dp[0][i] = false;
    }
    System.out.println(targetSumTab(nums, sum));
    System.out.println(targetSum(nums, 4, nums.length - 1));
    sum = 19;
    if (sum > sum(nums)) {
      System.out.println("No Solution");
    } else {
      System.out.println(targetSumMemo(nums, sum, dp, nums.length));// give error because sum>SUM(array)
    }

  }
}
