public class EditDistance {
  //minimum number of operations required to get str2 from str1 using add,delete and replace
  public static int ED(String str1, String str2) {
    int n = str1.length(), m = str2.length();
    int[][] dp = new int[n + 1][m + 1];// create
    for (int i = 0; i < n + 1; i++) {//initialization
      for (int j = 0; j < m + 1; j++) {
        if (i == 0) {
          dp[i][j] = j;
        }
        if (j == 0) {
          dp[i][j] = i;
        }
      }
    }
    for (int i = 1; i < n + 1; i++) {//fill
      for (int j = 1; j < m + 1; j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          // both are same
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          // add
          int ans1 = dp[i][j - 1] + 1;
          // delete
          int ans2 = dp[i - 1][j] + 1;
          // replace
          int ans3 = dp[i - 1][j - 1] + 1;
          dp[i][j] = Math.min(ans1, Math.min(ans2, ans3));

        }
      }
    }
    return dp[n][m];
  }

  public static void main(String[] args) {
    String str1 = "intention", str2 = "execution";
    System.out.println(ED(str1, str2));

  }

}
