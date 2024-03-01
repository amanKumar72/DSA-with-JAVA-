import java.util.*;

public class ShortestPath {
  // In string the direction is given as E for East , N for North, W for West and
  // S for South and we have to find the distance between the stating and the last
  // point so we use the formula sqrt((x2-x1)^2+(y2-y1)^2) where x1=0 and y1=0
  public static double shortestPath(String path) {
    int x = 0, y = 0;
    for (int i = 0; i < path.length(); i++) {
      char chr = path.charAt(i);
      if (chr == 'E') {
        x++;
      } else if (chr == 'W') {
        x--;
      } else if (chr == 'N') {
        y++;
      } else if (chr == 'S') {
        y--;
      }
    }

    return Math.sqrt(x * x + y * y);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("enter Path ");
    String str = sc.next();
    double path = shortestPath(str);
    System.out.println(path);
    sc.close();
  }

}
