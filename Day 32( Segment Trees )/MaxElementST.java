public class MaxElementST {
  static int[] tree;

  public static void init(int n) {
    tree = new int[4 * n];
  }

  public static void buildST(int[] arr, int sti, int st, int end) {
    if (st == end) {
      tree[sti] = arr[st];
      return;
    }
    int mid = (st + end) / 2;
    buildST(arr, 2 * sti + 1, st, mid);// left=2*sti+1
    buildST(arr, 2 * sti + 2, mid + 1, end);// left=2*sti+1
    tree[sti] = Math.max(tree[2 * sti + 1], tree[2 * sti + 2]);
  }

  public static int getMax(int arr[], int i, int j) {
    int n = arr.length;
    return getMaxutil(0, 0, n - 1, i, j);
  }

  public static int getMaxutil(int i, int si, int sj, int qi, int qj) {
    if (si > qj || sj < qi) {// non overlapping
      return Integer.MIN_VALUE;
    } else if (si >= qi && sj <= qj) {// complete overlapping
      return tree[i];
    } else {// partially overlapping
      int mid = (si + sj) / 2;
      int left = getMaxutil(2 * i + 1, si, mid, qi, qj);
      int right = getMaxutil(2 * i + 2, mid + 1, sj, qi, qj);
      return Math.max(left, right);
    }
  }

  public static void updateUtil(int i, int si, int sj, int idx, int value) {
    if (idx < si || idx > sj) {
      return;
    }
    if (si == sj) {
      tree[i] = value;
    }
    if (si != sj) {
      tree[i] = Math.max(tree[i], value);
      int mid = (si + sj) / 2;
      updateUtil(2 * i + 1, si, mid, idx, value);
      updateUtil(2 * i + 2, mid + 1, sj, idx, value);
    }
  }

  public static void update(int[] arr, int idx, int value) {
    arr[idx] = value;
    updateUtil(0, 0, arr.length - 1, idx, value);

  }

  public static void main(String[] args) {

    int[] nums = { 6, 8, -1, 2, 17, 1, 3, 2, 4 };
    int n = nums.length;
    init(n);
    buildST(nums, 0, 0, n - 1);
    for (int i = 0; i < tree.length; i++) {
      System.out.print(tree[i] + " ");
    }
    System.out.println();
    System.out.println(getMax(nums, 0, 3));
    update(nums, 2, 10);
    System.out.println(getMax(nums, 0, 3));
  }
}
