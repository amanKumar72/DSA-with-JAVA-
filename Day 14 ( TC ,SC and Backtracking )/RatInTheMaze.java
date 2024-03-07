public class RatInTheMaze {

  public static void printMaze(int maze[][]) {
    int n = maze.length;
    int sol[][] = new int[n][n];
    if (ratInTheMaze(maze, 0, 0, sol)) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          System.out.print(sol[i][j] + " ");
        }
        System.out.println();
      }
    } else {
      System.out.println("Solution not exist");
    }
  }

  public static boolean isSafe(int maze[][], int i, int j) {
    int n = maze.length;
    return (i >= 0 && i < n && j >= 0 && j < n && maze[i][j] == 1);
  }

  public static boolean ratInTheMaze(int maze[][], int i, int j, int sol[][]) {
    // base case
    if (i == maze.length - 1 && j == maze.length - 1 && maze[i][j] == 1) {
      sol[i][j] = 1;
      return true;
    }
    // recursion
    if (isSafe(maze, i, j)) {
      if (sol[i][j] == 1) {
        return false;
      }
      sol[i][j] = 1;
      if (ratInTheMaze(maze, i + 1, j, sol)) {
        return true;
      }
      if (ratInTheMaze(maze, i, j + 1, sol)) {
        return true;
      }
      sol[i][j] = 0;
    }
    return false;
  }

  public static void main(String[] args) {
    int maze[][] = {
        { 1, 0, 0, 0 },
        { 1, 1, 0, 1 },
        { 0, 1, 0, 0 },
        { 1, 1, 1, 1 }
    };
    printMaze(maze);
  }
}
