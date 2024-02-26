import java.util.*;

public class Patterns {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("enter number of Rows ");
    int n = sc.nextInt();
    // Floyd's triagle
    int a = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.err.print(a++ + " ");

      }
      System.err.println();
    }

    // 0-1 triangle
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        if ((i + j) % 2 == 0) {
          System.out.print(1);
        } else {
          System.out.print(0);

        }
      }
      System.out.println("");
    }

    // Number Pyramid

    for (int i = 1; i <= n; i++) {

      for (int k = 1; k <= n - i; k++) {
        System.out.print(" ");
      }
      for (int k = 1; k <= i; k++) {
        System.out.print(i + " ");
      }

      System.out.println();
    }

    // Palidromic pyramid

    for (int i = 1; i <= n; i++) {

      for (int k = 1; k <= n - i; k++) {
        System.out.print("  ");
      }
      for (int j = i; j > 0; j--) {
        System.out.print(j + " ");

      }
      for (int j = 2; j <= i; j++) {
        System.out.print(j + " ");

      }

      System.out.println();
    }

    // butterfly Pattern
    // upper part
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.err.print("*");
      }
      for (int j = 1; j <= 2 * (n - i); j++) {
        System.err.print(" ");
      }
      for (int j = 1; j <= i; j++) {
        System.err.print("*");
      }

      System.err.println();
    }
    // lower part
    for (int i = n; i > 0; i--) {
      for (int j = i; j > 0; j--) {
        System.err.print("*");
      }
      for (int j = 2 * (n - i); j > 0; j--) {
        System.err.print(" ");
      }
      for (int j = i; j > 0; j--) {
        System.err.print("*");
      }

      System.err.println();
    }

    sc.close();
  }

}
