import java.util.*;

public class add {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the first= ");
    int a = sc.nextInt();
    System.out.print("Enter the second= ");
    int b = sc.nextInt();
    System.out.print("Addition= ");
    int c = a + b;
    System.out.println(c);
    sc.close();
  }
}