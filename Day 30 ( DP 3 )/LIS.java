import java.util.*;

//least increasing subsequence as for all i<j => a[i]<a[j]
public class LIS {
  public static int lcsTab(int[] arr1, int n, int[] arr2, int m) {
    int[][] dp = new int[n + 1][m + 1];// create initialize by default 0 in java
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        if (arr1[i - 1] == arr2[j - 1]) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
        }
      }
    }

    return dp[n][m];
  }

  public static int lis(int[] arr) {
    HashSet<Integer> hs = new HashSet<>();
    for (int i = 0; i < arr.length; i++) {
      hs.add(arr[i]);
    }
    int[] arr2 = new int[hs.size()];
    int i = 0;
    for (Integer n : hs) {
      arr2[i] = n;
      i++;
    }
    Arrays.sort(arr2);
    return lcsTab(arr, arr.length, arr2, arr2.length);
  }

  public static void main(String[] args) {
    int[] arr = { 50, 3, 10, 7, 40, 70 };
    System.out.println(lis(arr));
  }
}
