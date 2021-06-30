package ir.ac.kntu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Main{

    public static void main(String[] args) {
        List<Edge>[] adj = initialAdj();
        FlowNetwork G = new FlowNetwork(adj);
        FordFolkerson f = new FordFolkerson(G, 0, 7);
        System.out.print("Maximum number of disjoint edge paths is : " + f.value());
        if(f.value() >= 2) {
            for (int i = 0; i < (int) f.value(); i++) {
                System.out.print("\nThe path number " + (i + 1) + " is : ");
                LinkedList<Integer> toRemove = printShortestDistance(adj, 0, 7, 8);
                removeFirstPathEdges(adj, toRemove);
            }
        }else {
            System.out.println("The sheeps are in danger!");
        }

    }

    private static List<Edge>[] initialAdj(){
        List<Edge>[] adj = new ArrayList[8];
        for(int i = 0; i < adj.length; i++){
            adj[i] = new ArrayList<>();
        }

        adj[0].add(new Edge(0,1));
        adj[0].add(new Edge(0,2));
        adj[0].add(new Edge(0,3));

        adj[1].add(new Edge(0,1));
        adj[1].add(new Edge(1,2));
        adj[1].add(new Edge(5,1));

        adj[2].add(new Edge(0,2));
        adj[2].add(new Edge(1,2));
        adj[2].add(new Edge(2,3));
        adj[2].add(new Edge(4,2));
        adj[2].add(new Edge(2,6));

        adj[3].add(new Edge(0,3));
        adj[3].add(new Edge(2,3));
        adj[3].add(new Edge(3,6));

        adj[4].add(new Edge(4,2));
        adj[4].add(new Edge(5,4));
        adj[4].add(new Edge(4,7));

        adj[5].add(new Edge(5,1));
        adj[5].add(new Edge(5,4));
        adj[5].add(new Edge(6,5));
        adj[5].add(new Edge(5,7));

        adj[6].add(new Edge(2,6));
        adj[6].add(new Edge(3,6));
        adj[6].add(new Edge(6,5));
        adj[6].add(new Edge(6,7));

        adj[7].add(new Edge(4,7));
        adj[7].add(new Edge(5,7));
        adj[7].add(new Edge(6,7));

        return adj;
    }

    private static LinkedList<Integer> printShortestDistance(List<Edge>[] adj, int s, int dest, int v) {
        LinkedList<Integer> path = new LinkedList<>();

        int pred[] = new int[v];
        int dist[] = new int[v];

        if (BFS(adj, s, dest, v, pred, dist) == false) {
            System.out.println("Given source and destination" + " are not connected");
            return path;
        }

        int crawl = dest;
        path.add(crawl);
        while (pred[crawl] != -1) {
            path.add(pred[crawl]);
            crawl = pred[crawl];
        }

        for (int i = path.size() - 1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }
        return path;
    }

    private static boolean BFS(List<Edge>[] adj, int src, int dest, int v, int pred[], int dist[]) {
        Queue<Integer> queue = new LinkedList<>();

        boolean visited[] = new boolean[v];

        for (int i = 0; i < v; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }

        visited[src] = true;
        dist[src] = 0;
        queue.add(src);

        while (!queue.isEmpty()) {
            int u = queue.remove();
            for (int i = 0; i < adj[u].size(); i++) {
                if (! visited[adj[u].get(i).to()]) {
                    visited[adj[u].get(i).to()] = true;
                    dist[adj[u].get(i).to()] = dist[u] + 1;
                    pred[adj[u].get(i).to()] = u;
                    queue.add(adj[u].get(i).to());

                    if (adj[u].get(i).to() == dest)
                        return true;
                }
            }
        }
        return false;
    }

    private static void removeFirstPathEdges(List<Edge>[] adj, LinkedList<Integer> toRemove){
        Edge edge = null;
        for (int i = 0 ;i < toRemove.size()-1 ; i++) {
            for (List<Edge> list : adj){
                for (Edge e : list){
                    if (e.to() == toRemove.get(i) && e.from()==toRemove.get(i+1)) {
                        edge = e;
                        break;
                    }
                }
                list.remove(edge);
            }
        }
    }

}
