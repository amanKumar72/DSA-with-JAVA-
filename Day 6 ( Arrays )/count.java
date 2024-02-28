
public class count {
  public static boolean countGreaterThanTwo(int a[]) {
    for (int i = 0; i < a.length; i++) {
      for (int j = i + 1; j < a.length; j++) {
        if (a[i] == a[j])
          return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 1 };
    boolean res = countGreaterThanTwo(a);
    System.out.println(res);
  }
}
