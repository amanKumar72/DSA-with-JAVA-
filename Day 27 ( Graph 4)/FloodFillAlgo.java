public class FloodFillAlgo {

  public static void floodFill(int[][] image, int sr, int sc, boolean[][] vis, int orgColor, int color) {
    if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || vis[sr][sc] || image[sr][sc] != orgColor) {
      return;
    }
    image[sr][sc] = color;
    floodFill(image, sr + 1, sc, vis, orgColor, color);// down
    floodFill(image, sr - 1, sc, vis, orgColor, color);// up
    floodFill(image, sr, sc + 1, vis, orgColor, color);// right
    floodFill(image, sr, sc - 1, vis, orgColor, color);// left
  }

  public static void main(String[] args) {
    int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
    int sr = 1, sc = 1, color = 2;
    floodFill(image, sr, sc, new boolean[image.length][image[0].length], image[sr][sc], color);
    for (int i = 0; i < image.length; ++i) {
      for (int j = 0; j < image[0].length; ++j) {
        System.out.print(image[i][j] + " ");
      }
      System.out.println();
    }
  }
}
