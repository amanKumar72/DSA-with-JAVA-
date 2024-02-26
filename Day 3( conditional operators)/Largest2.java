import java.util.*;

public class Largest2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter first no");
    int n1 = sc.nextInt();
    System.out.println("Enter Second no");
    int n2 = sc.nextInt();
    if (n1 > n2) {
      System.out.println("first Number is Greater ");
    } else {
      System.out.println("second Number is Greater ");

    }
    sc.close();
  }
}
