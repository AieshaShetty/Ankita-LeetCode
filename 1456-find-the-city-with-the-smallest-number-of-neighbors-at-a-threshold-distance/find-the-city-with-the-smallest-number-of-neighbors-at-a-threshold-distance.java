class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];

        // Initialize the distance array
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], (int) 1e9);
            distance[i][i] = 0;
        }

        // Set distances based on edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            distance[u][v] = w;
            distance[v][u] = w;
        }

        // Floyd-Warshall algorithm to find shortest paths
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        int ans = -1;
        int minReachable = Integer.MAX_VALUE;

        // Calculate the number of reachable cities within the threshold
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && distance[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= minReachable) {
                minReachable = count;
                ans = i;
            }
        }

        return ans;
    }
}
