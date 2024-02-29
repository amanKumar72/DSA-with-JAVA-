import java.util.Scanner;

public class SpiralMatrix {
  public static void TraverseSpiralMatrix(int matrix[][]) {
    int SR = 0, SC = 0, ER = matrix.length - 1, EC = matrix[0].length - 1, i, j;
    while (SR <= ER && SC <= EC) {
      // Top
      for (j = SC; j <= EC; j++) {
        System.out.print(matrix[SR][j] + " ");
      }
      // Right
      for (i = SR + 1; i <= ER; i++) {
        System.out.print(matrix[i][EC] + " ");
      }
      // Bottom
      for (j = EC - 1; j >= SC; j--) {    
        if (EC != SC) 
          System.out.print(matrix[ER][j] + " ");
      }
      // Right
      for (i = ER - 1; i >= SR + 1; i--) {
        if (ER != SR)
          System.out.print(matrix[i][SC] + " ");
      }
      // Updation
      SR++;
      SC++;
      ER--;
      EC--;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter No of rows Of Matrix 1");
    int r1 = sc.nextInt();
    System.out.println("Enter No of columns Of Matrix 1");
    int c1 = sc.nextInt();
    int m[][] = new int[r1][c1];
    System.out.println("Enter Matrix ");
    for (int i = 0; i < r1; i++) {
      for (int j = 0; j < c1; j++) {
        m[i][j] = sc.nextInt();
      }
    }

    System.out.println("Sum of Primary and Secondory Diagonal=\n");
    TraverseSpiralMatrix(m);

    sc.close();
    ;
  }
}
