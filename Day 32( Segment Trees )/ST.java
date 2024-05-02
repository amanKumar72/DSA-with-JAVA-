public class ST {
  static int[] tree;

  public static void init(int n) {
    tree = new int[4 * n];
  }

  public static int buildST(int[] arr, int sti, int st, int end) {
    if (st == end) {
      return tree[sti] = arr[st];
    }
    int mid = (st + end) / 2;
    buildST(arr, 2 * sti + 1, st, mid);// left=2*sti+1
    buildST(arr, 2 * sti + 2, mid + 1, end);// left=2*sti+1
    return tree[sti] = tree[2 * sti + 1] + tree[2 * sti + 2];
  }

  public static int getSumutil(int i, int si, int sj, int qi, int qj) {
    if (si >= qj || sj <= qi) {// non overlapping
      return 0;
    } else if (si >= qi && sj <= qj) {// complete overlapping
      return tree[i];
    } else {// partially overlapping
      int mid = (si + sj) / 2;
      int left = getSumutil(2 * i + 1, si, mid, qi, qj);
      int rigth = getSumutil(2 * i + 2, mid + 1, sj, qi, qj);
      return rigth + left;
    }
  }

  public static int getSum(int[] arr, int i, int j) {
    int n = arr.length;
    return getSumutil(0, 0, n - 1, i, j);
  }

  public static void updateUtil(int i, int si, int sj, int idx, int diff) {
    if (idx < si || idx > sj) {
      return;
    }
    tree[i] += diff;
    if (si != sj) {
      int mid = (si + sj) / 2;
      updateUtil(2 * i + 1, si, mid, idx, diff);
      updateUtil(2 * i + 2, mid + 1, sj, idx, diff);
    }
  }

  public static void update(int[] arr, int idx, int value) {
    int diff = value - arr[idx];
    arr[idx] = value;
    updateUtil(0, 0, arr.length - 1, idx, diff);

  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8 };
    int n = nums.length;
    init(n);
    buildST(nums, 0, 0, n - 1);
    for (int i = 0; i < tree.length; i++) {
      System.out.print(tree[i] + " ");
    }
    System.out.println();
    System.out.println(getSum(nums, 2, 5));
    update(nums, 2, 2);
    System.out.println(getSum(nums, 2, 5));
  }
}