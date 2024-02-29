import java.util.*;

public class TransposeAndMultiplicationOfAMatrix {

  public static int[][] transpose(int m[][]) {
    int r1 = m.length, c1 = m[0].length;
    int transpose[][] = new int[c1][r1];
    for (int i = 0; i < r1; i++) {
      for (int j = 0; j < c1; j++) {
        transpose[j][i] = m[i][j];
      }
    }
    return transpose;
  }

  public static int[][] Multiplication(int m[][], int n[][]) {
    int r1 = m.length, c1 = m[0].length, r2 = n.length, c2 = n[0].length;
    int multiplication[][] = new int[r1][c2];
    if (c1 == r2) {
      for (int i = 0; i < r1; i++) {
        for (int j = 0; j < c2; j++) {
          multiplication[i][j] = 0;
          for (int k = 0; k < c1; k++) {
            multiplication[i][j] += m[i][k] * n[k][j];
          }
        }
      }
    } else {
      System.out.println("multiplication Not Possible");
    }
    return multiplication;
  }

  public static void PrintMatrix(int m[][]) {
    int r1 = m.length, c1 = m[0].length;
    for (int i = 0; i < r1; i++) {
      for (int j = 0; j < c1; j++) {
        System.out.print(m[i][j] + "\t");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter No of rows Of Matrix 1");
    int r1 = sc.nextInt();
    System.out.println("Enter No of columns Of Matrix 1");
    int c1 = sc.nextInt();
    System.out.println("Enter No of rows Of Matrix 2");
    int r2 = sc.nextInt();
    System.out.println("Enter No of columns Of Matrix 2");
    int c2 = sc.nextInt();
    int m[][] = new int[r1][c1];
    int n[][] = new int[r2][c2];

    System.out.println("Enter Matrix 1");
    for (int i = 0; i < r1; i++) {
      for (int j = 0; j < c1; j++) {
        m[i][j] = sc.nextInt();
      }
    }
    System.out.println("Enter Matrix 2");
    for (int i = 0; i < r2; i++) {
      for (int j = 0; j < c2; j++) {
        n[i][j] = sc.nextInt();
      }
    }
    System.out.println("Transpose=\n");
    PrintMatrix(transpose(m));
    System.out.println("Multiplication=\n");
    PrintMatrix(Multiplication(m, n));

    sc.close();
    ;
  }
}