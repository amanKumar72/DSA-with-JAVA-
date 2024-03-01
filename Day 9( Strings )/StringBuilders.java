
public class StringBuilders {
  // Convert each the first character of a word into upper case
  public static String ConvertUpperCase(String str) {
    StringBuilder sb = new StringBuilder("");
    char chr = str.charAt(0);
    sb.append(Character.toUpperCase(chr));
    for (int i = 1; i < str.length() - 1; i++) {
      if (str.charAt(i) == ' ') {
        sb.append(' ');
        i++;
        chr = str.charAt(i);
        sb.append(Character.toUpperCase(chr));
      } else {
        sb.append(str.charAt(i));
      }

    }
    return sb.toString();
  }

  // Comprehension of a string
  public static String StringComprehension(String str) {
    StringBuilder sb = new StringBuilder("");
    int n = str.length(), count = 0;
    for (int i = 0; i < n; i++) {
      count = 1;
      sb.append(str.charAt(i));
      while (i < n - 1 && str.charAt(i) == str.charAt(i + 1)) {
        count++;
        i++;
      }
      if (count > 1) {
        sb.append(count);
      }
    }
    return sb.toString();
  }

  // compare swo strings are anagram or not
  // two strings are anagram if the one string can be made by another string
  // by just interchanging its letters.
  public static boolean isAnagram(String str1, String str2) {
    int i = 0, j = 0;
    if (str1.length() == str2.length()) {
      for (i = 0; i < str1.length(); i++) {
        for (j = 0; j < str2.length(); j++) {
          if (str1.charAt(i) == str2.charAt(j)) {
            break;
          }
        }
        if (j == str2.length()) {
          return false;
        }
      }
    } else {
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    StringBuilder sb1 = new StringBuilder("aaaabbbccdeeefffffggggggg ");
    System.out.println(sb1);
    String str1 = "clothes";
    String str2 = "hotlesc";
    System.out.println(isAnagram(str1, str2));

  }
}
