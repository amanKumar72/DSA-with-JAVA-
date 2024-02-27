import java.util.*;

public class linearAndBinarySearch {
  public static int linearSearch(int a[], int key) {
    for (int i = 0; i < a.length; i++) {
      if (a[i] == key) {
        return i;
      }
    }
    return -1;
  }

  public static int binarySearch(int a[], int key) {
    int beg = 0, end = a.length, mid;
    while (beg <= end) {
      mid = (beg + end) / 2;
      if (a[mid] == key) {
        return mid;
      }
      if (a[mid] < key) {
        beg = mid + 1;
      }
      if (a[mid] > key) {
        end = mid - 1;
      }
    }
    return -1;
  }

  public static void main(String args[]) {
    int arr[] = { 1, 2, 3, 4, 5 };
    Scanner sc = new Scanner(System.in);
    int key = sc.nextInt();
    int res = linearSearch(arr, key);
    if (res == -1) {
      System.out.println("NOT FOUND");
    } else {
      System.out.println(" FOUND At Location = " + res);

    }
    res = binarySearch(arr, key);
    if (res == -1) {
      System.out.println("NOT FOUND");
    } else {
      System.out.println(" FOUND At Location = " + res);

    }
    sc.close();
  }
}
