public class QuickSort {
  public static void quickSort(int a[], int si, int ei) {
    if (si >= ei) {
      return;
    }
    int pindx = partition(a, si, ei);
    quickSort(a, si, pindx - 1);
    quickSort(a, pindx + 1, ei);
  }

  public static int partition(int a[], int si, int ei) {
    int i = si - 1, j = si, pivot = a[ei], temp;
    while (j < ei) {
      if (a[j] <= pivot) {
        i++;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
      }
      j++;
    }
    i++;
    temp = a[i];
    a[i] = a[ei];
    a[ei] = temp;
    return i;
  }

  public static void main(String[] args) {
    int a[] = { 8, 5, 4, 9, -1, 4, 2 };
    quickSort(a, 0, a.length - 1);
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i]+" ");
    }
  }
}
