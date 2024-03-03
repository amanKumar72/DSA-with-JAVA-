public class ArrayIsSorted {

  // check array is sorted or not
  public static boolean isSorted(int a[], int i) {
    if (i == a.length - 1) {
      return true;
    }
    if (a[i] > a[i + 1]) {
      return false;
    }
    return isSorted(a, i + 1);
  }

  // first occurance of an element
  public static int firstOccurance(int a[], int i, int key) {
    if (i == a.length) {
      return -1;
    }
    if (a[i] == key) {
      return i;
    }
    return firstOccurance(a, i + 1, key);
  }

  // last occurance of an element
  public static int lastOccurance(int a[], int i, int key) {
    if (i == a.length) {
      return -1;
    }
    int isFound = lastOccurance(a, i + 1, key);
    if (a[i] == key && isFound == -1) {
      return i;
    }
    return isFound;
  }

  // x^n optimal
  public static int optPower(int x, int n) {
    if (n == 0) {
      return 1;
    }
    int xnby2 = optPower(x, n / 2); // calculate x^(n/2)
    int xn = xnby2 * xnby2; // calculate x^n = x^(n/2)* x^(n/2) if n is even
    if (n % 2 != 0) {
      xn *= x; // if n is odd the x^n =x^n * x
    }
    return xn;
  }

  // tailing problem of 2*n borrd and 2*1 tile size
  public static int TilingProblem(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }
    return TilingProblem(n - 1) + TilingProblem(n - 2); // totalWays=horizontal + vertical
  }

  // RemoveDuplicate from a string
  public static void removeDuplicate(String str, int i, StringBuilder newStr, boolean map[]) {
    if (i == str.length()) {
      System.out.println(newStr);
      return;
    }
    char currChar = str.charAt(i);
    if (map[currChar - 'a'] == true) {
      removeDuplicate(str, i + 1, newStr, map);
    } else {
      map[currChar - 'a'] = true;
      removeDuplicate(str, i + 1, newStr.append(currChar), map);
    }
  }

  // Friends pairing problem
  public static int friendPairing(int n) {
    if (n == 1 || n == 2) {
      return n;
    }
    return friendPairing(n - 1) + (n - 1) * friendPairing(n - 2); // total ways = single(n-1)+ (n-1)* pair(n-2)
  }

  // binaryStrings : print all binary strings in which there is no consecutive
  // ones
  public static void binaryStrings(int n, int lastplace, String str) {
    if (n == 0) {
      System.out.println(str);
      return;
    }
    binaryStrings(n - 1, 0, str + "0");
    if (lastplace == 0) {
      binaryStrings(n - 1, 1, str + "1");
    }
  }

  public static void main(String[] args) {
    int a[] = { 1, 2, 5, 4, 6, 5, 8, 7 };
    int res = lastOccurance(a, 0, 5);
    System.out.println(res);
    System.out.println(optPower(3, 5));
    System.out.println(TilingProblem(4));
    System.out.println(friendPairing(3));
    boolean map[] = new boolean[26];
    removeDuplicate("amankumar", 0, new StringBuilder(""), map);
    binaryStrings(3, 0, "");
  }
}