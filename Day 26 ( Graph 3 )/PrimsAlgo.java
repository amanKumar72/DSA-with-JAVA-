import java.util.*;

public class PrimsAlgo {
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

    public static class Pair implements Comparable<Pair> {
        int v;
        int src;
        int cost;

        public Pair(int s, int v, int c) {
            this.v = v;
            this.cost = c;
            this.src = s;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;// assending order
        }
    }

    public static void prims(ArrayList<Edge>[] graph) {
        int V = graph.length;
        boolean[] vis = new boolean[V];
        ArrayList<Edge> al = new ArrayList<>();
        int finalCost = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.v]) {
                vis[curr.v] = true;
                finalCost += curr.cost;
                al.add(new Edge(curr.src, curr.v, curr.cost));
                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.src, e.dest, e.wt));
                }
            }
        }
        for (int i = 0; i < al.size(); i++) {
            Edge curr = al.get(i);
            if (curr.wt != 0) {
                System.out.print("(" + curr.src + "," + curr.dest + "," + curr.wt + ")" + " ");
            }
        }
        System.out.println("FinalCost= " + finalCost);
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));
        graph[1].add(new Edge(1, 3, 40));
        graph[2].add(new Edge(2, 3, 50));

    }

    public static void main(String[] args) {

        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];// default null so make Arraylist at indeces
        createGraph(graph);
        prims(graph);
    }
}