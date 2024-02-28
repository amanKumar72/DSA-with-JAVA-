
public class InsertonBubbleSelectionSort {

  public static void BubbleSort(int a[]) {
    for (int i = 0; i < a.length - 1; i++) {
      for (int j = 0; j < a.length - 1 - i; j++) {
        if (a[j] > a[j + 1]) {
          int t = a[j];
          a[j] = a[j + 1];
          a[j + 1] = t;
        }
      }
    }
  }

  public static void SelectionSort(int a[]) {
    for (int i = 0; i < a.length - 1; i++) {
      int min = i;
      for (int j = i + 1; j < a.length; j++) {
        if (a[j] < a[min]) {
          min = j;
        }
      }
      int t = a[min];
      a[min] = a[i];
      a[i] = t;
    }
  }

  public static void InsertionSort(int a[]) {
    for (int i = 0; i < a.length; i++) {
      int curr = a[i];
      int prev = i - 1;
      while (prev >= 0 && curr < a[prev]) {
        a[prev + 1] = a[prev];
        prev--;
      }
      a[prev + 1] = curr;
    }
  }

  public static void PrintArray(int array[]) {

    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + "\t");
    }
  }

  public static void main(String[] args) {
    int array[] = { 10, 2, 6, 7, 8, 9 };
    InsertionSort(array);
    PrintArray(array);
  }

}
