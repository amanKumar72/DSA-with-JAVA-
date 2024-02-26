import java.util.*;

public class decimalToBinary {
  public static int convertDecimalToBinary(int n) {
    int x = n;
    String b = "";
    int r = 0;
    while (x > 0) {
      r = x % 2;
      b = r + b;
      x /= 2;
    }
    int bn = Integer.parseInt(b);
    return bn;

}
public static void main(String args[]) {
  Scanner sc = new Scanner(System.in);
  System.out.print("enter Number ");
  int n = sc.nextInt();
  System.out.println("The Binary representation of " + n + " is :" + convertDecimalToBinary(n));
  sc.close();
}
}