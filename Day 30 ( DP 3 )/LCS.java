public class LCS {
  // least common substring

  // TC O(2^n)
  public static int lcs(String str1, int n, String str2, int m) {
    if (n == 0 || m == 0) {
      return 0;
    }
    if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
      return 1 + lcs(str1, n - 1, str2, m - 1);
    } else {
      int ans1 = lcs(str1, n - 1, str2, m);
      int ans2 = lcs(str1, n, str2, m - 1);
      return Math.max(ans1, ans2);
    }
  }

  // TC = O(n*m)<<<<<<<O(2^n)
  public static int lcsMemo(String str1, int n, String str2, int m, int[][] dp) {
    if (n == 0 || m == 0) {
      return 0;
    }
    if (dp[n][m] != -1) {
      return dp[n][m];
    }
    if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
      dp[n][m] = 1 + lcs(str1, n - 1, str2, m - 1);
      return dp[n][m];
    } else {
      int ans1 = lcs(str1, n - 1, str2, m);
      int ans2 = lcs(str1, n, str2, m - 1);
      dp[n][m] = Math.max(ans1, ans2);
      return dp[n][m];
    }
  }

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
    String str1 = "pear", str2 = "sea";

    int[][] dp = new int[str1.length() + 1][str2.length() + 1];// create
    for (int i = 0; i < dp.length; i++) { // initialize
      for (int j = 0; j < dp[0].length; j++) {
        dp[i][j] = -1;
      }
    }
    System.out.println(lcs(str1, str1.length(), str2, str2.length()));
    System.out.println(lcsTab(str1, str1.length(), str2, str2.length()));
    int lcs = lcsMemo(str1, str1.length(), str2, str2.length(), dp);
    System.out.println(lcs);
  }

}
