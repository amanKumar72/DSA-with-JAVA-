
public class logical {
  public static void main(String[] args) {
      int a=5; int b=10;
      System.out.println("And :"+(a<b && b%a==0));
      System.out.println("OR :"+(a<b|| b%a==0));
      System.out.println("Not  :"+(!(a<b)));
  }
}
