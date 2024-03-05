
public class NQueens {
  static int solutions = 0;

  public static boolean isSafe(char board[][], int row, int col) {
    // vertical top
    for (int i = row - 1; i >= 0; i--) {
      if (board[i][col] == 'Q') {
        return false;
      }
    }

    // right diagonal
    for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
      if (board[i][j] == 'Q') {
        return false;
      }
    }

    // left diagonal
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 'Q') {
        return false;
      }
    }
    return true;
  }

  public static void nQueen(char board[][], int row) {
    if (row == board.length) {
      printBoard(board);
      solutions++;
      return;
    }
    // loop for column
    for (int j = 0; j < board.length; j++) {
      if (isSafe(board, row, j)) {
        board[row][j] = 'Q';
        nQueen(board, row + 1); // recursive call
        board[row][j] = 'x'; // backtracking step
      }
    }
  }

  // print only one solution if possible
  public static boolean nQueenOneSolution(char board[][], int row) {
    if (row == board.length) {
      return true;
    }
    // loop for column
    for (int j = 0; j < board.length; j++) {
      if (isSafe(board, row, j)) {
        board[row][j] = 'Q';
        if (nQueenOneSolution(board, row + 1)) {
          return true;
        }
        board[row][j] = 'x'; // backtracking step
      }
    }
    return false;
  }

  public static void printBoard(char board[][]) {
    System.out.println("------------------chess board-----------------------");
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.err.println();
    }
  }

  public static void main(String[] args) {
    int n = 5;
    char board[][] = new char[n][n];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        board[i][j] = 'x';
      }
    }
    nQueenOneSolution(board, 0); // print all solutions
    printBoard(board);
    System.out.println(solutions); // count no of solutions
  }

}
