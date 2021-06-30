package ir.ac.kntu;

import java.util.Arrays;
import java.util.List;

public class Printing {
    private List<Edge>[] adj;
    private boolean[] marked;

    public Printing(List<Edge>[] adj, int s, int t) {
        this.adj = adj;
        marked = new boolean[adj.length];

    }


}