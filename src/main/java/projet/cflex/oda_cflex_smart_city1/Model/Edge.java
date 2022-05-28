package projet.cflex.oda_cflex_smart_city1.Model;

public class Edge {
    public final int source, dest;

    private Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }

    // Factory method for creating an immutable instance of `Edge`
    public static Edge of(int a, int b) {
        return new Edge(a, b); // calls private constructor
    }
}