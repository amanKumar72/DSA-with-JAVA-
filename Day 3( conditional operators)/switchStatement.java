
//program of a calculator in java
import java.util.*;

public class switchStatement {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter first no");
    int n1 = sc.nextInt();
    System.out.println("Enter Second no");
    int n2 = sc.nextInt();
    System.out.println("Enter operation no");
    String ch = sc.next();
    switch (ch) {
      case "+":
        System.out.println(n1 + n2);
        break;
      case "-":
        System.out.println(n1 - n2);

        break;
      case "*":
        System.out.println(n1 * n2);

        break;
      case "/":
        System.out.println(n1 / n2);

        break;

      default:
        System.out.println("Invalid operator");
        break;
    }

    sc.close();
  }
}
