import java.util.*;
class Solution {

    public boolean[] findAnswer(int n, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        int m = edges.length;
        boolean[] answer = new boolean[m];
        int[] fdist = dijkstra(0, n, graph);
        if (fdist[n - 1] == Integer.MAX_VALUE) {
            return answer;
        }
        int[] rdist = dijkstra(n - 1, n, graph);

        for (int i = 0; i < m; i++) {
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];
            if (fdist[u] + w + rdist[v] == fdist[n - 1] || fdist[v] + w + rdist[u] == fdist[n - 1]) {
                answer[i] = true;
            }
        }

        return answer;
    }

    private int[] dijkstra(int start, int n, List<List<int[]>> graph) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int u = pair[0], d = pair[1];
            if (d > dist[u]) {
                continue;
            }
            for (int[] edge : graph.get(u)) {
                int v = edge[0], w = edge[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        return dist;
    }
}
