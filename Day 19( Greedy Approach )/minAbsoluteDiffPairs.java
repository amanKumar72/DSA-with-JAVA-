import java.util.Arrays;

public class minAbsoluteDiffPairs {
  public static void main(String[] args) {
    int A[]={4,8,7,1};
    int B[]={6,2,3,5};

    Arrays.sort(A);
    Arrays.sort(B);

    int minAbsDiff=0;
    for(int i=0;i<A.length;i++){
      minAbsDiff+=Math.abs(A[i]-B[i]);
    }

    System.out.println(minAbsDiff);
  }
}
