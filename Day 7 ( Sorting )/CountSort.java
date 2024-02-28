
public class CountSort {
  public static void countSort(int a[]) {
    int max = Integer.MIN_VALUE;
    // find maximum range of array
    for (int i = 0; i < a.length; i++) {
      max = Math.max(max, a[i]);
    }
    int count[] = new int[max + 1];
    // insert frequency in count array
    for (int i = 0; i < a.length; i++) {
      count[a[i]]++;
    }
    // Sorting
    int j = 0;
    for (int i = 0; i < count.length; i++) {
      while (count[i] > 0) {
        a[j] = i;
        j++;
        count[i]--;
      }
    }

  }

  public static void PrintArray(int array[]) {

    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + "\t");
    }
  }

  public static void main(String[] args) {
    int array[] = { 10, 2, 6, 7, 8, 9 };
    countSort(array);
    PrintArray(array);
  }

}
