public class LeastCommonSubString {
  public static int lcsTab(String str1, int n, String str2, int m) {
    int ans = 0;
    int[][] dp = new int[n + 1][m + 1];// create initialize by default 0 in java
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
          ans = Math.max(ans, dp[i][j]);
        } else {
          dp[i][j] = 0;
        }
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    String str1 = "ace", str2 = "adce";
    System.out.println(lcsTab(str1, str1.length(), str2, str2.length()));
  }
}
