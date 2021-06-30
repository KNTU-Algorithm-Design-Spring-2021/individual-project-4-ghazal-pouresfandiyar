package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;


public class Main{

    public static void main(String[] args) {
        List<Edge>[] adj = initialAdj();
        FlowNetwork G = new FlowNetwork(adj);
        FordFolkerson f = new FordFolkerson(G, 0, 7);
        System.out.println("Maximum number of disjoint edge paths is : " + f.value());
//        PrintResult printResult = new PrintResult(adj, 0, 7);
//        Printing printing = new Printing(adj, 0, 7);
//        G.minEdgeDFS(0, 7);
    }

    public static List<Edge>[] initialAdj(){
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

}
