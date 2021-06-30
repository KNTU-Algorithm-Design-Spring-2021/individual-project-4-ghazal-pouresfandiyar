package ir.ac.kntu;

public class Edge {
    private final int v, w;
    private final double capacity = 1;
    private double flow;

    public Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }

    public int from(){
        return v;
    }

    public int to(){
        return w;
    }

    public int other(int vertex){
        if(vertex == v)
            return w;
        else if(vertex == w)
            return v;
        throw new RuntimeException("Illegal endpoint!");
    }

    public double getCapacity(){
        return capacity;
    }

    public double getFlow(){
        return flow;
    }

    public double residualCapacityTo(int vertex){
        if (vertex == v)
            return flow;
        else if(vertex == w)
            return capacity - flow;
        throw new RuntimeException("Illegal endpoint!");
    }

    public void addResidualFlowTo(int vertex, double delta){
        if (vertex == v)
            flow -= delta;
        else if(vertex == w)
            flow += delta;
        else throw new RuntimeException("Illegal endpoint!");
    }
}
