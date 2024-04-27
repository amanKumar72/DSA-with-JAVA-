import java.util.ArrayList;
import java.util.Collections;

public class KruskalsAlgo {
  static class Edge implements Comparable<Edge> {
    int src;
    int dest;
    int wt;

    public Edge(int s, int d, int w) {
      this.src = s;
      this.dest = d;
      this.wt = w;
    }

    @Override
    public int compareTo(Edge e2) {
      return this.wt - e2.wt; // ascending order
    }

  }

  public static void create(ArrayList<Edge> edges) {
    edges.add(new Edge(0, 1, 10));
    edges.add(new Edge(0, 2, 15));
    edges.add(new Edge(0, 3, 30));
    edges.add(new Edge(1, 3, 40));
    edges.add(new Edge(2, 3, 50));
  }

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

  public static void kruskal(ArrayList<Edge> edges, int V) {
    Collections.sort(edges);
    int cost = 0;
    int count = 0;
    ArrayList<Edge> ans = new ArrayList<>();
    for (int i = 0; count < V - 1; i++) {
      Edge e = edges.get(i);
      if (find(e.src) != find(e.dest)) {
        union(e.src, e.dest);
        cost += e.wt;
        ans.add(new Edge(e.src, e.dest, e.wt));
        count++;
      }
    }
    for (int i = 0; i < ans.size(); i++) {
      Edge curr = ans.get(i);
      if (curr.wt != 0) {
        System.out.print("(" + curr.src + "," + curr.dest + "," + curr.wt + ")" + " ");
      }
    }
    System.out.println("FinalCost= " + cost);

  }

  public static void main(String[] args) {
    init();
    int V = 4;
    ArrayList<Edge> edges = new ArrayList<>();
    create(edges);
    kruskal(edges, V);
  }
}
