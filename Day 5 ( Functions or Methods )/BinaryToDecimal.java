import java.util.*;

public class BinaryToDecimal {
  public static int convertBinaryToDecimal(int n) {
    int x = n;
    int s = 0;
    int r = 0;
    int i = 0;
    while (x > 0) {
      r = x % 10;
      s += r * Math.pow(2, i);
      x /= 10;
      i++;
    }
    return s;

  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.print("enter Number ");
    int n = sc.nextInt();
    System.out.println("The decimal representation of " + n + " is :" + convertBinaryToDecimal(n));
    sc.close();
  }
}