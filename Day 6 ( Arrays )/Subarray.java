
public class Subarray {

  // brute force
  public static int[] MaxSumSubarrays(int a[]) {
    int totalSubarrays = 0, s = 0;
    int index[] = new int[2];
    int sum[] = new int[a.length * (a.length + 1) / 2];
    int maxSum = Integer.MIN_VALUE;

    for (int i = 0; i < a.length; i++) {
      for (int j = i; j < a.length; j++) {
        for (int k = i; k <= j; k++) {
          System.out.print(a[k] + ",");
          sum[s] += a[k];
        }
        if (sum[s] > maxSum) {
          maxSum = sum[s];
          index[0] = i;
          index[1] = j;
        }
        System.out.print(" ");
        totalSubarrays++;
        s++;
      }
      System.out.println();
    }
    System.out.println(totalSubarrays);
    for (int i = 0; i < sum.length; i++) {
      System.out.print(sum[i] + " ");
    }
    return index;
  }

  // prefix sum
  public static int MaxSumSubarraysPrefixSum(int a[]) {
    int maxSum = Integer.MIN_VALUE, currSum = 0;

    // prefix sum array
    int prefix[] = new int[a.length];
    prefix[0] = a[0];
    for (int i = 1; i < a.length; i++) {
      prefix[i] = prefix[i - 1] + a[i];
    }
    for (int i = 0; i < a.length; i++) {
      System.out.println(prefix[i]);
    }
    for (int i = 0; i < a.length; i++) {
      for (int j = i; j < a.length; j++) {
        currSum = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
        System.out.println(currSum);
        if (maxSum < currSum) {
          maxSum = currSum;
        }
      }
    }
    return maxSum;
  }

  // kadanes algorithm
  public static int kadanes(int a[]) {
    int cs = 0, ms = Integer.MIN_VALUE;
    boolean allnegative = true;
    for (int i = 0; i < a.length; i++) {
      if (a[i] >= 0) {
        allnegative = false;
        break;
      }
    }
    if (!allnegative) {
      for (int i = 0; i < a.length; i++) {
        cs += a[i];
        if (cs < 0) {
          cs = 0;
        }
        if (cs > ms) {
          ms = cs;
        }
      }
    } else {
      ms = a[0];
      for (int i = 0; i < a.length; i++) {
        if (ms < a[i]) {
          ms = a[i];
        }
      }
    }
    return ms;
  }

  public static void main(String[] args) {
    int arr[] = { -3, -4, -9, -5, -3 };
    int maxSum = kadanes(arr);
    System.out.println("MaxSum SubArray " + maxSum);

  }
}
