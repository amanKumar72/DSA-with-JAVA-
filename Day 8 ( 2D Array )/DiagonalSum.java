import java.util.Scanner;

public class DiagonalSum {
  public static int diagonalSum(int matrix[][]) {
    int row = matrix.length, sum = 0;
    for (int i = 0; i < row; i++) {
      // Brute force
      // int column = matrix[0].length;
      // for (int j = 0; j < column; j++) {
      // if(i==j||i+j==matrix.length-1){
      // sum+=matrix[i][j];
      // }
      // optimal approach
      sum += matrix[i][i];
      if (i != matrix.length - 1 - i) {
        sum += matrix[i][matrix.length - 1 - i];
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter No of rows Of Matrix 1");
    int r1 = sc.nextInt();
    System.out.println("Enter No of columns Of Matrix 1");
    int c1 = sc.nextInt();
    int m[][] = new int[r1][c1];
    System.out.println("Enter Matrix ");
    if (r1 == c1) {
      for (int i = 0; i < r1; i++) {
        for (int j = 0; j < c1; j++) {
          m[i][j] = sc.nextInt();
        }
      }
    } else {
      System.out.println("Diagonal Sum not Possible ");
    }

    System.out.println("Sum of Primary and Secondory Diagonal=\n");
    System.out.println(diagonalSum(m));

    sc.close();
    ;
  }

}