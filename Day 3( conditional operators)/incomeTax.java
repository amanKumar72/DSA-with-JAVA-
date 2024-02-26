import java.util.*;

public class incomeTax {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int income = sc.nextInt();
    int t = 0;
    if (income <= 500000) {
      t = 0;
    } else if (income > 500000 && income <= 1000000) {
      t = (int) (income * 0.1f);
    } else {
      t = (int) (income * 0.25f);
    }
    System.out.println("Income tax is: " + t);
    sc.close();
  }
}
