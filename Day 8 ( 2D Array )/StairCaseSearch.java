import java.util.Scanner;

public class StairCaseSearch {
  public static void Search(int matrix[][], int key) {
    // the pointer is at upper last element of the matrix
    int i = 0, j = matrix[0].length - 1;
    while (i < matrix.length && j >= 0) {
      if (key == matrix[i][j]) {
        System.out.println("key found at ( row = " + i + ", column = " + j + ")");
        return;
      } else if (key < matrix[i][j]) {
        j--;
      } else {
        i++;
      }
    }
    // the pointer is at lower first element of the matrix
    // i = matrix.length - 1;
    // j = 0;
    // while (i >= 0 && j < matrix[0].length) {
    // if (key == matrix[i][j]) {
    // System.out.println("key found at (" + i + "," + j + ")");
    // } else if (key < matrix[i][j]) {
    // i--;
    // } else {
    // j++;
    // }
    // }

    return;
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
    System.out.println("Enter item to search");
    int key = sc.nextInt();

    System.out.println("Sum of Primary and Secondory Diagonal=\n");
    Search(m, key);

    sc.close();
    ;
  }
}
