public class DisjointSet {
  static int n = 7;
  static int[] par = new int[n];
  static int[] rank = new int[n];

  public static void init() {
    for (int i = 0; i < n; i++) {
      par[i] = i;
    }
  }

  public static int find(int x) {
    if (x == par[x]) {
      return x;
    }
    return par[x] = find(par[x]);
  }

  public static void union(int u, int v) {
    int parU = find(u);
    int parV = find(v);
    if (rank[parU] == rank[parV]) {
      par[parV] = parU;
      rank[parU]++;
    } else if (rank[parU] < rank[parV]) {
      par[parU] = parV;
    } else {
      par[parV] = parU;
    }
  }

  public static void main(String[] args) {
    init();
    // Test the disjoint set data structure.
    union(1, 3);
    System.out.println(find(3));
    union(2, 4);
    union(3, 6);
    union(1, 4);
    System.out.println(find(3));
    System.out.println(find(6));
  }
}