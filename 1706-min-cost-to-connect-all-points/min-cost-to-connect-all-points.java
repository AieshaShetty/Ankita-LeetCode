class Solution {
    private int[] dsu;
    public int minCostConnectPoints(int[][] points) {
        List<Edge> edges = generateEdges(points);
        initializeDSU(points.length);
        int cost = 0;
        for (Edge edge : edges) {
            int sourceRoot = findRoot(edge.source);
            int destinationRoot = findRoot(edge.destination);
            if (sourceRoot != destinationRoot) {
                cost += edge.weight;
                union(edge.source, edge.destination);
            }
        }
        return cost;
    }

    private void union(int node1, int node2) {
        node1 = findRoot(node1);
        node2 = findRoot(node2);
        dsu[node1] = node2;
    }

    private int findRoot(int vertex) {
        if (vertex == dsu[vertex]) {
            return vertex;
        }
        int root = findRoot(dsu[vertex]);
        dsu[vertex] = root;
        return root;
    }

    private void initializeDSU(int size) {
        dsu = new int[size];
        for (int i = 0; i < size; i++) {
            dsu[i] = i;
        }
    }

    private List<Edge> generateEdges(int[][] points) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                edges.add(new Edge(i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])));
            }
        }
        Collections.sort(edges, new Comparator<Edge>(){
            @Override
            public int compare(Edge edge1, Edge edge2) {
                return edge1.weight - edge2.weight;
            }
        });
        return edges;
    }
}
class Edge {
    int source;
    int destination;
    int weight;
    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}