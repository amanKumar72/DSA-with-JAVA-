public class MergeSort {

  // for numbers
  public static void mergeSort(int a[], int si, int ei) {
    if (si >= ei) {
      return;
    }
    int mid = si + (ei - si) / 2;
    mergeSort(a, si, mid);
    mergeSort(a, mid + 1, ei);
    merge(a, si, mid, ei);
  }

  public static void merge(int a[], int si, int mid, int ei) {
    int temp[] = new int[ei - si + 1];
    int i = si, j = mid + 1, k = 0;
    while (i <= mid && j <= ei) {
      if (a[i] < a[j]) {
        temp[k++] = a[i++];
      } else {
        temp[k++] = a[j++];
      }
    }
    while (i <= mid) {
      temp[k++] = a[i++];
    }
    while (j <= ei) {
      temp[k++] = a[j++];
    }
    for (i = si, k = 0; k < temp.length; i++, k++) {
      a[i] = temp[k];
    }
  }

  // for string
  public static void mergeSortString(String a[], int si, int ei) {
    if (si >= ei) {
      return;
    }
    int mid = si + (ei - si) / 2;
    mergeSortString(a, si, mid);
    mergeSortString(a, mid + 1, ei);
    mergeString(a, si, mid, ei);
  }

  public static void mergeString(String a[], int si, int mid, int ei) {
    String temp[] = new String[ei - si + 1];
    int i = si, j = mid + 1, k = 0;
    while (i <= mid && j <= ei) {
      if (a[i].compareTo(a[j]) <= 0) {
        temp[k++] = a[i++];
      } else {
        temp[k++] = a[j++];
      }
    }
    while (i <= mid) {
      temp[k++] = a[i++];
    }
    while (j <= ei) {
      temp[k++] = a[j++];
    }
    for (i = si, k = 0; k < temp.length; i++, k++) {
      a[i] = temp[k];
    }
  }

  // find the number which occurs majority times

  public static int CountInRange(int a[], int num, int si, int ei) {
    int count = 0;
    for (int i = si; i <= ei; i++) {
      if (a[i] == num) {
        count++;
      }
    }
    return count;
  }

  public static int MajorityElement(int a[], int si, int ei) {
    if (si == ei) {
      return a[si];
    }

    // find majority elemnt of right and left
    int mid = si + (ei - si) / 2;
    int left = MajorityElement(a, si, mid);
    int right = MajorityElement(a, mid + 1, ei);

    // if both are same the return anyone

    if (left == right) {
      return left;
    }

    // therwise find the count of both
    int leftCount = CountInRange(a, left, si, ei);
    int rightCount = CountInRange(a, right, si, ei);

    // return which is greater

    return rightCount > leftCount ? right : left;
  }

  // inversion count in an array : how far an arra is to be sorted
  // ex a[]={2,4,1,3,5} invertions (2,1),(4,1),(4,3) => total invertions
  // so return 3
  // in other words if a[i]>a[j] then it called an invertion
  public static int inversionCount(int a[], int si, int ei) {
    int invCount = 0;
    if (si < ei) {
      int mid = si + (ei - si) / 2;
      invCount = inversionCount(a, si, mid);
      invCount += inversionCount(a, mid + 1, ei);
      invCount += invversionMerge(a, si, mid + 1, ei);
    }
    return invCount;
  }

  public static int invversionMerge(int a[], int si, int mid, int ei) {
    int temp[] = new int[ei - si + 1];
    int invCount = 0;
    int i = si, j = mid, k = 0;
    while (i < mid && j <= ei) {
      if (a[i] <= a[j]) {
        temp[k++] = a[i++];
      } else {
        temp[k++] = a[j++];
        invCount += mid - i;
      }
    }
    while (i < mid) {
      temp[k++] = a[i++];
    }
    while (j <= ei) {
      temp[k++] = a[j++];
    }
    for (i = si, k = 0; k < temp.length; i++, k++) {
      a[i] = temp[k];
    }
    return invCount;
  }

  // main block
  public static void main(String[] args) {
    String a[] = { "man", "amanm", "boby", "shani", "amma" };
    int me[] = { -1, 2, 3, 4, 5, 6, 7, 8, 1 };
    int m = MajorityElement(me, 0, me.length - 1);
    System.out.println(m);
    System.out.println(inversionCount(me, 0, me.length - 1));
    // mergeSort(me, 0, me.length - 1);
    mergeSortString(a, 0, a.length - 1);
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }
    for (int i = 0; i < me.length; i++) {
      System.out.print(me[i] + " ");
    }
  }
}