package ir.ac.kntu;

import java.util.LinkedList;
import java.util.Queue;

public class FordFolkerson {
    private boolean[] marked;
    private Edge[] edgeTo;
    private double value;

    public FordFolkerson(FlowNetwork G, int s, int t){
        value = 0;
        while (hasAugmentingPAth(G, s, t)){
            double bottle = Double.POSITIVE_INFINITY;
            for (int v = t; v != s; v = edgeTo[v].other(v))
                bottle = Math.min(bottle, edgeTo[v].residualCapacityTo(v));
            for (int v = t; v != s; v = edgeTo[v].other(v))
                edgeTo[v].addResidualFlowTo(v, bottle);
            value += bottle;
        }
    }
    //BFS to find path
    public boolean hasAugmentingPAth(FlowNetwork G, int s, int t){
        edgeTo = new Edge[G.v()];
        marked = new boolean[G.v()];

        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        marked[s] = true;
        while (!q.isEmpty()){
            int v = q.poll();
            for (Edge e : G.adj(v)){
                int w = e.other(v);
                if (e.residualCapacityTo(w) > 0 && !marked[w]){
                    edgeTo[w] = e;
                    marked[w] = true;
                    q.add(w);
                }
            }
        }
        return marked[t];
    }

    public double value(){
        return value;
    }

    public boolean inCut(int v){
        return marked[v];
    }
}
