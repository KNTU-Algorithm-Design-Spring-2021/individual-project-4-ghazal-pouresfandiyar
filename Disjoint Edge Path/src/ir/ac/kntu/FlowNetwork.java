package ir.ac.kntu;

import java.util.List;

public class FlowNetwork {
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


}
