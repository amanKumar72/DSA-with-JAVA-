
public class FindInKthRotatedArray {
  public static int Search(int a[], int target) {
    int min = minSearch(a);
    if (a[min] <= target && target <= a[a.length - 1]) {
      return Search(a, min, a.length - 1, target);
    } else {
      return Search(a, 0, min - 1, target);
    }
  }

  public static int Search(int a[], int left, int right, int target) {
    while (left <= right) {
      int mid = left + ((right - left) / 2);
      if (a[mid] == target) {
        return mid;
      } else if (a[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }

  public static int minSearch(int a[]) {
    int left = 0, right = a.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (mid > 0 && a[mid] < a[mid - 1]) {
        return mid;
      } else if (a[left] <= a[mid] && a[mid] > a[right]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }

  public static void main(String[] args) {
    int array[] = { 4, 5, 6, 7, 0, 1, 2 };
    int index = Search(array, 2);
    System.out.println(index);
  }
}
