import java.util.*;

public class GraphBasic {
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

    // breadth first search
    public static void bfsutil(ArrayList<Edge>[] graph, boolean[] vis, int st) {
        Queue<Integer> q = new LinkedList<>();
        q.add(st);
        while (!q.isEmpty()) {
            Integer curr = q.remove();
            if (!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    q.add(graph[curr].get(i).dest);
                }
            }
        }
    }

    public static void bfs(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                bfsutil(graph, vis, i);
            }
        }
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

    // has path
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean vis[]) {
        if (src == dest) {
            return true;
        }
        vis[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            int newSrc = graph[src].get(i).dest;
            if (!vis[newSrc] && hasPath(graph, newSrc, dest, vis)) {
                return true;
            }
        }
        return false;
    }

    // cycle detection in undirected graph
    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1))
                    return true;
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, int par) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            int neigh = graph[curr].get(i).dest;
            // csse 3

            if (!vis[neigh]) {
                if (detectCycleUtil(graph, vis, neigh, curr)) {
                    return true;
                }
            }
            // case 1
            else if (vis[neigh] && neigh != par) {
                return true;
            }
        }
        return false;
    }

    // cycle detection for directed graph
    public static boolean isCyclic(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCyclicUtil(graph, vis, stack, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCyclicUtil(ArrayList<Edge>[] graph, boolean[] vis, boolean[] stack, int curr) {
        vis[curr] = true;
        stack[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            int neigh = graph[curr].get(i).dest;
            if (stack[neigh]) {
                return true;
            }
            if (!vis[neigh]) {
                if (isCyclicUtil(graph, vis, stack, neigh)) {
                    return true;
                }
            }
        }
        stack[curr] = false;
        return false;

    }

    // isBipartite
    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            color[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                q.add(i);
                color[i] = 0;// blue
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        int neigh = graph[curr].get(j).dest;
                        if (color[neigh] == -1) {
                            int nextColor = color[curr] == 0 ? 1 : 0;
                            color[neigh] = nextColor;
                            q.add(neigh);
                        } else if (color[neigh] == color[curr]) {
                            return false;
                        }

                    }
                }
            }
        }
        return true;
    }

    // TOPOLOGICAL SORTING
    public static void topologicalSort(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topologicalSortUtil(graph, vis, s, i);
            }
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void topologicalSortUtil(ArrayList<Edge>[] graph, boolean[] vis, Stack<Integer> s, int curr) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            int neigh = graph[curr].get(i).dest;
            if (!vis[neigh]) {
                topologicalSortUtil(graph, vis, s, curr);
            }
        }
        s.push(curr);
    }

    // create directed array
    public static void createDirectedgraoh(ArrayList<Edge>[] graph) {
        for (int i = 0; i < 5; i++) {
            graph[i] = new ArrayList<>();
        }

        // graph[0].add(new Edge(0, 2, 1));
        // graph[1].add(new Edge(1, 0, 1));
        // graph[2].add(new Edge(2, 3, 1));
        // graph[3].add(new Edge(3, 0, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[2].add(new Edge(2, 0, 1));
        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 2, 1));

    }

    // create undirected array
    public static void createUndirectedgraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < 5; i++) {
            graph[i] = new ArrayList<>();
        }

        // insert
        // for 0
        graph[0].add(new Edge(0, 1, 5));
        // for 1
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        // for 2
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));
        // for 3
        graph[3].add(new Edge(3, 2, 1));
        graph[3].add(new Edge(3, 1, 3));
        // FOR 4
        graph[4].add(new Edge(4, 2, 2));

    }

    // create Bipertite Graph
    public static void createBipertiteGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < 5; i++) {
            graph[i] = new ArrayList<>();
        }

        // insert
        // for 0
        graph[0].add(new Edge(0, 1, 5));
        graph[0].add(new Edge(0, 2, 5));
        // for 1
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 3, 3));
        // for 2
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 3, 2));
        // for 3
        graph[3].add(new Edge(3, 2, 1));
        graph[3].add(new Edge(3, 1, 3));

    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];// default null so make Arraylist at indeces

        // createBipertiteGraph(graph);
        // createUndirectedgraph(graph);
        createDirectedgraoh(graph);

        // all neighbours of 2
        for (int i = 0; i < graph[2].size(); i++) {
            System.out.println(graph[2].get(i).dest);
        }
        // bfs traversal
        System.out.print("bfs traveersal ");
        bfs(graph);
        System.out.println();

        // dfs
        System.out.print("dfs traveersal ");
        dfs(graph);
        System.out.println();

        // has path
        System.out.println("Has path " + hasPath(graph, 0, 7, new boolean[V]));

        System.out.println("Cycle exists " + detectCycle(graph));// fails in case of directed graph

        System.out.println("Cycle exists " + isCyclic(graph));

        System.out.print("topological sorting ");
        topologicalSort(graph);
        System.out.println();

        System.out.println("Is bipertite graph " + isBipartite(graph));

    }
}
