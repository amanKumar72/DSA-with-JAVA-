import java.util.*;

public class palidrome {
  public static boolean CheckPalidrome(String str) {
    int i = 0, j = str.length() - 1;
    while (i <= j) {
      if (str.charAt(i) != str.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  public static String largestString(String str[]) {
    String largest = str[0];
    for (int i = 0; i < str.length - 1; i++) {
      int check = str[i].compareTo(str[i + 1]);
      if (check < 0) {
        largest = str[i + 1];
      }
    }
    return largest;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str1 = "Tony";
    String str2 = new String("Tony");
    String str3 = "Tony";

    // check equal
    System.out.println(str1 == str2);
    System.out.println(str1 == str3);

    // equals function
    System.out.println(str1.equals(str3)); // to compare only words
    System.out.println(str1.equals(str2));
    System.out.println(str1.length());

    // substring() function
    System.out.println(str1.substring(0, 2)); // to get a substring with (including , excluding ) words

    // compareTo and compareToIgnoreCase
    System.out.println(str1.compareTo(str2)); // returns positive value if string1 > string2 , returns zero if string1
                                              // == string2 and returns negative value if string1 < string2
    System.out.println(str1.compareToIgnoreCase(str2)); // ignore case ,consider A==a

    String str[] = { "apple", "mango", "banana" };
    String largest = largestString(str);
    System.out.println("The Largest string is : " + largest);
    // check a number is palidrome or not
    System.out.println("enter a word");
    // String txt=sc.next(); //for single word string
    String txt = sc.nextLine(); // for single line string
    boolean res = CheckPalidrome(txt);
    System.out.println(res);

    
    sc.close();
  }
}
