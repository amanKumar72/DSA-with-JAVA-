public class GridWays {
  public static int gridWays(int i, int j, int n, int m) {
    // base case
    if (i == n - 1 && j == m - 1) { // last cell
      return 1;
    } else if (i == n || j == m) { // last cell traversed of a row or column
      return 0;
    }
    return gridWays(i + 1, j, n, m) + gridWays(i, j + 1, n, m);
  }

  // formula to find grid ways: ((n-1)+(m-1))!/((n-1)! * (m-1)!)
  // ex n=4,m=4
  // (6)!/(3! * 3!)=6*5*4*3!/(3! * 3*2*1) =20

  public static int fact(int n){
    if(n==0||n==1){
      return 1;
    }
    return n*fact(n-1);
  }

  public static int gridWaysTrick(int n,int m){
    return( fact((n-1)+(m-1)))/(fact(n-1)*fact(m-1));
  }
  public static void main(String[] args) {
    int n = 4, m = 4;
    System.out.println(gridWaysTrick(n, m));
    System.out.println(gridWays(0,0,n, m));
    ;

  }
}
