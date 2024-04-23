import java.util.*;

public class GraphPart2 {
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

    // topological sort using bfs
    public static void calculateIndeg(ArrayList<Edge>[] graph, int[] indeg) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                int neigh = graph[i].get(j).dest;
                indeg[neigh]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge>[] graph) {
        int[] indeg = new int[graph.length];
        calculateIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }
        // bfs
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");
            for (int i = 0; i < graph[curr].size(); i++) {
                int neigh = graph[curr].get(i).dest;
                indeg[neigh]--;
                if (indeg[neigh] == 0) {
                    q.add(neigh);
                }
            }
        }
        System.out.println();
    }

    // Dijikastra algorithm
    public static class Pair implements Comparable<Pair> {
        int node;
        int path;

        public Pair(int n, int p) {
            this.path = p;
            this.node = n;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;// path based assending order sorting
        }

    }

    public static void Dijikastra(ArrayList<Edge>[] graph, int src) {
        int[] dist = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;// infinity
            }
        }
        boolean[] vis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.node]) {
                vis[curr.node] = true;
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }

            }
        }
        // print
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();

    }

    // All paths from src to destination
    public static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, ArrayList<Integer> path) {
        if (src == dest) {
            path.add(src);
            System.out.println(path);
            path.clear();
            return;
        }
        for (int i = 0; i < graph[src].size(); i++) {
            int neigh = graph[src].get(i).dest;
            path.add(src);
            printAllPaths(graph, neigh, dest, path);
        }
    }

    public static void createDirectedgraoh(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 3, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));
        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));

    }

    public static void createDirectedgraohForDijikastra(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
        // graph[4].add(new Edge(4, 1, 1));
        // graph[5].add(new Edge(5, 0, 1));
        // graph[5].add(new Edge(5, 2, 1));

    }

    // depth first search
    public static void dfsutil(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
        System.out.print(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            int d = graph[curr].get(i).dest;
            if (!vis[d]) {
                dfsutil(graph, d, vis);
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                dfsutil(graph, i, vis);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];// default null so make Arraylist at indeces

        createDirectedgraohForDijikastra(graph);
        // topSort(graph);
        // printAllPaths(graph, 5, 1, new ArrayList<>());
        Dijikastra(graph, 0);

    }
}
