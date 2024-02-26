import java.util.*;

public class Largest3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter first no");
    int n1 = sc.nextInt();
    System.out.println("Enter Second no");
    int n2 = sc.nextInt();
    System.out.println("Enter Third no");
    int n3 = sc.nextInt();
    if (n1 > n2) {
      if (n1 > n3) {
        System.out.println("first Number is Greater ");
      } else {
        System.out.println("third Number is Greater ");
      }

    } else {
      if (n2 > n3) {
        System.out.println("second Number is Greater ");
      } else {
        System.out.println("third Number is Greater ");
      }

    }
    sc.close();
  }
}
