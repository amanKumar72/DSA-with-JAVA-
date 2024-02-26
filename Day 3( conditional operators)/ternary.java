import java.util.*;

public class ternary {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter first no");
    int n1 = sc.nextInt();
    System.out.println("Enter Second no");
    int n2 = sc.nextInt();
    int res = n1 > n2 ? n1 : n2;
    // greater no using Ternary operator
    System.out.println("The maximum number:" + res);
    // odd even using ternary
    String oe = (n1 % 2 == 0) ? "Even" : "Odd";
    System.out.println("First number:" + oe);
    oe = (n2 % 2 == 0) ? "Even" : "Odd";
    System.out.println("Second number:" + oe);
    // if(n1>n2){
    // System.out.println("first Number is Greater ");
    // } else{
    // System.out.println("second Number is Greater ");

    // }
    sc.close();
  }
}
