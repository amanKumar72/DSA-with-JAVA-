
public class clearBits {
  public static int clearLastIBits(int n,int i){
    int bitmask=((-1)<<i);
    return n&bitmask;

  }

  public static int clearRangeOfBits(int n,int st,int end){
    int a=(~(0)<<(end+1));
    int b=(1<<(st))-1;
    System.out.println(a+" "+b);
    int bitmask=a|b;
    return  n&bitmask;
  }
  public static void main(String[] args) {
    int x = 63; // binary
    System.out.println(clearRangeOfBits(x, 1,3));
  }
  
}
