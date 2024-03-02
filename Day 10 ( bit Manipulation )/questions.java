
public class questions {

  // Check a number is odd or even without using % operator
  public static boolean isEven(int num) {
    if ((num & 1) == 1) {
      return false;
    } else {
      return true;
    }
  }

  // check if a number is a power of 2 or not
  public static boolean powerOfTwo(int n) {
    if ((n & (n - 1)) == 0) {
      return true;
    } else {
      return false;
    }
  }

  // count set bits in a number
  public static int CountSetBit(int n) {
    int count = 0;
    while (n > 0) {
      if ((n & 1) == 1) {
        count++;
      }
      n = n >> 1;

    }
    return count;
  }


  //fast exponentiation of a^n
  public static int fastExp(int a,int n){
    int ans=1;
    while(n>0){
      if((n&1)==1){
        ans=ans*a;
      }
      a=a*a;
      n=n>>1;
    }

    return ans;
  }


  //X^X


  public static void main(String[] args) {
    int x = 4;
    System.out.println(fastExp(x, 5)); // 6

    System.out.println(-~x);  // add 1 in a number :- x+1=-(~x)=-(-x-1)=x+1
  }
}
