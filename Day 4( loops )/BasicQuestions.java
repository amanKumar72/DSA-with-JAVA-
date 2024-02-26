import java.util.*;

public class BasicQuestions {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("enter Number ");
    int n = sc.nextInt();
    // sum of n natural number
    int s = 0;
    for (int i = 1; i <= n; i++) {
      s += i;
    }
    System.out.println("Sum of n natural number=" + s);

    // Reverse of a number
    int x = n;
    s = 0;
    int r = 0;
    while (x > 0) {
      r = x % 10;
      s = s * 10 + r;
      x /= 10;
    }
    System.out.println("Reverse = " + s);

    // check prime
    int f = 0;
    for (int i = 2; i < Math.sqrt(n) + 1; i++) {
      if (n % i == 0) {
        f = 1;
        break;
      }
    }
    if (f == 0 || n == 2) {
      System.out.println("Prime");
    } else {
      System.out.println("Not Prime");

    }

    // Parilledrome or not
    x = n;
    s = 0;
    r = 0;
    while (x > 0) {
      r = x % 10;
      s = s * 10 + r;
      x /= 10;
    }
    if (s == n) {
      System.out.println("parillodrome");
    } else {
      System.out.println(" Not parillodrome");
    }

    // Sum of digits
    x = n;
    s = 0;
    r = 0;
    while (x > 0) {
      r = x % 10;
      s += r;
      x /= 10;
    }
    System.out.println("Sum of digits of a number=" + s);

    // decimal to binary
    x = n;
    String b = "";
    r = 0;
    while (x > 0) {
      r = x % 2;
      b = r + b;
      x /= 2;
    }
    int bn = Integer.parseInt(b);
    System.out.println("Binary =" + bn);

    // binary to decimal
    x = n;
    s = 0;
    r = 0;
    int i = 0;
    while (x > 0) {
      r = x % 10;
      s += r * Math.pow(2, i);
      x /= 10;
      i++;
    }
    System.out.println("Decimal =" + s);
    sc.close();
  }
}