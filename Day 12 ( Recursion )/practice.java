public class practice {
  // find all occurances of key
  public static void allOccurances(int a[], int i, int key) {
    if (i >= a.length) {
      return;
    }
    if (a[i] == key) {
      System.out.println(i);
    }
    allOccurances(a, i + 1, key);
  }

  // intger to word
  static String number[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

  public static void intToWord(int n) {
    if (n == 0) {
      return;
    }
    intToWord(n / 10);
    System.out.print(number[n % 10] + " ");

  }

  // count all substrings which starts and ends with same characetrs
  public static int countSubStringsSameChars(String str, int i, int j, int length) {
    if (length <= 0) {
      return 0;
    }
    if (length == 1) {
      return 1;
    }
    int res = countSubStringsSameChars(str, i + 1, j, length - 1) + countSubStringsSameChars(str, i, j - 1, length - 1)
        - countSubStringsSameChars(str, i + 1, j - 1, length - 2);
    if (str.charAt(i) == str.charAt(j)) {
      res++;
    }

    return res;
  }

  public static void main(String[] args) {
    int a[] = { 1, 2, 3, 2, 4, 5, 2, 6, 4 };
    allOccurances(a, 0, 2);
    intToWord(123);
    System.out.println(countSubStringsSameChars("abcab", 0, 4, 5));
  }
}
