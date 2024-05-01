
public class CatalanNumber {
  // static int ans = 0;

  public static int catalan(int n) {
    if (n == 1 || n == 0) {
      return 1;
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
      ans += catalan(i) * catalan(n - i - 1);
    }
    return ans;
  }

  public static int catalanTab(int n) {
    int[] dp = new int[n + 1];
    dp[0] = dp[1] = 1;
    for (int i = 2; i < n + 1; i++) {// dp[i]=catalan(n)=> replace i->j and n-> i in recursive code part
      for (int j = 0; j < i; j++) {
        dp[i] += dp[j] * dp[i - j - 1];
      }
    }
    return dp[n];
  }

  public static int MountainRanges(int n) {
    int[] dp = new int[n + 1];
    dp[0] = dp[1] = 1;
    for (int i = 2; i < n + 1; i++) {// dp[i]=catalan(n)=> replace i->j and n-> i in recursive code part
      for (int j = 0; j < i; j++) {
        int inside = dp[j];
        int outside = dp[i - j - 1];
        dp[i] += inside * outside;
      }
    }
    return dp[n];
  }

  // how many bst are possible for n nodes in a tree
  public static int countBSts(int n) {
    int[] dp = new int[n + 1];
    dp[0] = dp[1] = 1;
    for (int i = 2; i < n + 1; i++) {// dp[i]=catalan(n)=> replace i->j and n-> i in recursive code part
      for (int j = 0; j < i; j++) {
        int left = dp[j];
        int right = dp[i - j - 1];
        dp[i] += left * right;
      }
    }
    return dp[n];
  }

  // how many mountain ranges are possible with the n upstream and n downsreams
  public static int catalanMemo(int n, int[] dp) {
    if (n == 1 || n == 0) {
      return 1;
    }
    if (dp[n] != 0) {
      return dp[n];
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
      ans += catalanMemo(i, dp) * catalanMemo(n - i - 1, dp);
    }
    return dp[n] = ans;
  }

  public static void main(String[] args) {
    int n = 5;
    int[] dp = new int[n + 1];
    System.out.println(catalan(n));
    System.out.println(catalanMemo(n, dp));
    System.out.println(catalanTab(n));
    System.out.println("No of BSTs " + countBSts(n));
    System.out.println("Possible Mountain ranges " + MountainRanges(n));
  }
}
