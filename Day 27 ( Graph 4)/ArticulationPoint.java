import java.util.*;

public class ArticulationPoint {
  static class Edge {
    int src;
    int dest;
    int wt;

    public Edge(int s, int d, int w) {
      this.src = s;
      this.dest = d;
      this.wt = w;
    }
  }

  public static void dfs(ArrayList<Edge>[] graph, int[] dt, int[] low, boolean[] vis, boolean[] ap, int curr, int par,
      int time) {
    vis[curr] = true;
    low[curr] = dt[curr] = ++time;
    int child = 0;
    for (int i = 0; i < graph[curr].size(); i++) {
      int neigh = graph[curr].get(i).dest;
      if (neigh == par) {
        continue;
      } else if (!vis[neigh]) {
        dfs(graph, dt, low, vis, ap, neigh, curr, time);
        low[curr] = Math.min(low[curr], low[neigh]);
        if (par != -1 && dt[curr] <= low[neigh]) {
          // System.out.println("AP" + curr);
          ap[curr] = true;
        }
        child++;
      } else {
        low[curr] = Math.min(low[curr], dt[neigh]);

      }
    }
    if (par == -1 && child > 1) {
      // System.out.println("AP" + curr);
      ap[curr] = true;
    }
  }

  public static void getAP(ArrayList<Edge>[] graph, int V) {
    int[] dt = new int[V];
    int[] low = new int[V];
    boolean[] vis = new boolean[V];
    boolean[] ap = new boolean[V];
    int time = 0;
    for (int i = 0; i < V; i++) {
      if (!vis[i]) {
        dfs(graph, dt, low, vis, ap, i, -1, time);
      }
    }
    // PRINT ALL ARTICULATION POINTS
    for (int i = 0; i < V; i++) {
      if (ap[i]) {
        System.out.println("AP : " + i);
      }
    }
  }

  public static void createUndirectedgraph(ArrayList<Edge>[] graph) {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    graph[0].add(new Edge(0, 1, 5));
    graph[0].add(new Edge(0, 2, 5));
    graph[0].add(new Edge(0, 3, 5));

    graph[1].add(new Edge(1, 0, 5));
    graph[1].add(new Edge(1, 2, 1));

    graph[2].add(new Edge(2, 1, 1));
    graph[2].add(new Edge(2, 0, 1));

    graph[3].add(new Edge(3, 0, 1));
    graph[3].add(new Edge(3, 4, 3));
    // graph[3].add(new Edge(3, 5, 3));

    graph[4].add(new Edge(4, 3, 2));
    // graph[4].add(new Edge(4, 5, 2));

    // graph[5].add(new Edge(5, 3, 2));
    // graph[5].add(new Edge(5, 4, 2));

  }

  public static void main(String[] args) {
    int V = 6;
    @SuppressWarnings("unchecked")
    ArrayList<Edge>[] graph = new ArrayList[V];// default null so make Arraylist at indeces
    createUndirectedgraph(graph);
    getAP(graph, V);
  }
}
