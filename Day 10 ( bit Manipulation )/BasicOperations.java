public class BasicOperations {

  public static int getIthBit(int n, int i) {
    int bitmask = (1 << (i));

    if ((n & bitmask) == 1) {
      return 1;
    } else {
      return 0;
    }
  }

  public static int setIthBit(int n, int i) {
    int bitmask = (1 << (i));

    return n | bitmask;
  }

  public static int clearIthBit(int n, int i) {
    int bitmask = ~(1 << (i));

    return n & bitmask;
  }

  public static int updateIthBit(int n, int i, int nb) {
    // first method
    // if (nb == 1) {
    // return setIthBit(n, i);
    // } else {
    // return clearIthBit(n, i);
    // }

    // second method
    n = clearIthBit(n, i);
    int bitmask = nb << (i);
    return n | bitmask;
  }

  public static void main(String args[]) {
    // int a = 5, b = 2;
    // System.out.println(a & b); // a and b returs 1 if both bits are set i.e. 1
    // otherwise returns 0
    // System.out.println(a | b); // a or b returns 0 if both bits are unset i.e. 0
    // otherwise returns 1
    // System.out.println(a << b); // shift a by b places in the left a<<b=a*b^2
    // System.out.println(a >> b); // shift a by b places in the right a<<b=a/b^2
    // System.out.println(~a); // replace 0 by 1 and 1 by 0 , if number is n then
    // ~n=-(n+1)
    System.out.println(updateIthBit(5, 3, 0));

  }
}
