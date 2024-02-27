
public class TrappingRainwater {
  public static int TrappedWater(int height[]) {
    int n = height.length;
    int tp = 0, v;
    int leftmax[] = new int[n];
    int rightmax[] = new int[n];
    leftmax[0] = height[0];
    rightmax[n - 1] = height[n - 1];
    // calculate left maximum boundry
    for (int i = 1; i < n; i++) {
      leftmax[i] = Math.max(height[i], leftmax[i - 1]);
    }
    // calculate right maximum boundry
    for (int i = n - 2; i >= 0; i--) {
      rightmax[i] = Math.max(height[i], rightmax[i + 1]);
    }
    // calculating trapped water
    for (int i = 0; i < n; i++) {
      v = Math.min(leftmax[i], rightmax[i]) - height[i];
      if (v > 0) {
        tp += v;
      }
    }
    return tp;
  }

  public static void main(String[] args) {
    int arr[] = { 4, 2, 0, 6, 3, 2, 5 };
    int res = TrappedWater(arr);
    System.out.println("Maximum Trapped Rainwater =" + res);

  }
}
