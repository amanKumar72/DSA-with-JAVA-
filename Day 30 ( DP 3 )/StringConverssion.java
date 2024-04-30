public class StringConverssion {
  // minimum operations required to convert one str to another str using add and
  // delete only
  public static int lcsTab(String str1, int n, String str2, int m) {
    int[][] dp = new int[n + 1][m + 1];// create initialize by default 0 in java
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[n][m];
  }

  public static void main(String[] args) {
    String str1 = "ea", str2 = "sea";
    int lcs = lcsTab(str1, str1.length(), str2, str2.length());
    int strConv = Math.abs(str1.length() - lcs) + Math.abs(str2.length() - lcs);
    System.out.println(strConv);
  }
}
