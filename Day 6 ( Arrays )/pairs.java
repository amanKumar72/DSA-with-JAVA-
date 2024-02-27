
public class pairs {
  public static int printPairs(int a[], int n) {
    int totalPairs = 0;
    for (int i = 0; i < a.length; i++) {
      for (int j = i + 1; j < a.length; j++) {
        System.out.print("(" + a[i] + "," + a[j] + ")");
        totalPairs++;
      }
      System.out.println();
    }
    return totalPairs;
  }

  public static void main(String[] args) {
    int arr[] = { 1, 2, 3, 4, 5 };
    int tp = printPairs(arr, 5);
    System.out.println(tp);

  }
}
