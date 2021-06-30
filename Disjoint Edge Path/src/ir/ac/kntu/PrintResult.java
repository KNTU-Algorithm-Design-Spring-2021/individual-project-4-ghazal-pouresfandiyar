package ir.ac.kntu;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class PrintResult {
    private List<Edge>[] adj;
    private boolean[] marked;
    static int min_num_of_edges = 0, edge_count = 0;

    public PrintResult(List<Edge>[] adj, int s, int t) {
        this.adj = adj;
        marked = new boolean[adj.length];
        Arrays.fill(marked, false);
        min_num_of_edges = Integer.MAX_VALUE;
        edge_count = 0;

        minEdgeDFSUtil(marked, s, t);

        // Print the minimum number of edges
        System.out.println(min_num_of_edges);
//        Stack<Integer> stack = new Stack<>();
//        DFS(marked, s, t, stack);

    }

    //    public Stack<Integer> convertAdjToStack(List<Edge>[] adj){
//
//    }
    // A function to print the path between
    // the given pair of nodes.
    static void printPath(Stack<Integer> stack) {
        for (int i = 0; i < stack.size() - 1; i++) {
            System.out.print(stack.get(i) + " -> ");
        }
        System.out.println(stack.get(stack.size() - 1));
    }

    // An utility function to do
    // DFS of graph recursively
    // from a given vertex x.
    private void minEdgeDFSUtil(boolean[] marked, int s, int t) {

        marked[s] = true;

        // If we have found the destination vertex
        // then check whether count of total number of edges
        // is less than the minimum number of edges or not
        if (s == t) {
            if (min_num_of_edges > edge_count)
                min_num_of_edges = edge_count;
        }

        // If current vertex is not destination
        else
        {
            for (Edge e : adj[s])
            {
                int v = e.from();

                if (!marked[v])
                {
                    edge_count++;
                    minEdgeDFSUtil(marked, v, t);
                }
            }
        }

        // Decrement the count of number of edges
        // and mark current vertex as unvisited
        marked[s] = false;
        edge_count--;
    }
//    void DFS(boolean[] marked, int s, int t, Stack<Integer> stack){}
}
