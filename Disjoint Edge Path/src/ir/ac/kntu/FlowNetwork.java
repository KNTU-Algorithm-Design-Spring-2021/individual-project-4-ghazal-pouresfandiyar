package ir.ac.kntu;

import java.util.Arrays;
import java.util.List;

public class FlowNetwork {
    static int min_num_of_edges = 0, edge_count = 0;

    private final int v;
    private List<Edge>[] adj;

    public FlowNetwork(List<Edge>[] adj){
        this.v = adj.length;
        this.adj = adj;
    }

    public Iterable<Edge> adj(int v){
        return adj[v];
    }

    public int v() {
        return v;
    }

//    private void minEdgeDFSUtil(boolean[] marked, int s, int t) {
//
//        // For keeping track of visited
//        // nodes in DFS
//        marked[s] = true;
//
//        // If we have found the destination vertex
//        // then check whether count of total number of edges
//        // is less than the minimum number of edges or not
//        if (s == t) {
//            if (min_num_of_edges > edge_count)
//                min_num_of_edges = edge_count;
//        }
//
//        // If current vertex is not destination
//        else {
//            for (Edge e : adj[s]) {
//                int v = e.to();
//
//                if (!marked[v]) {
//                    edge_count++;
//                    System.out.println(v);
//                    minEdgeDFSUtil(marked, v, t);
//                }
//            }
//        }
//
//        // Decrement the count of number of edges
//        // and mark current vertex as unvisited
//        marked[s] = false;
//        edge_count--;
//    }
//
//
//
//    // Function to print minimum number of edges
//    // It uses recursive minEdgeDFSUtil
//    void minEdgeDFS(int u, int v) {
//
//        // To keep track of all the
//        // visited vertices
//        boolean[] marked= new boolean[v];
//        Arrays.fill(marked, false);
//
//        // To store minimum number of edges
//        min_num_of_edges = Integer.MAX_VALUE;
//
//        // To store total number of
//        // edges in each path
//        edge_count = 0;
//
//        minEdgeDFSUtil(marked, u, v);
//
//        // Print the minimum number of edges
//        System.out.println(min_num_of_edges);
//    }
}
