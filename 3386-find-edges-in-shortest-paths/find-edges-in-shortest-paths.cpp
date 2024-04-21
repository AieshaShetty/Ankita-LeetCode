class Solution {

public:
    vector<bool> findAnswer(int n, vector<vector<int>>& edges) { 
        vector<vector<pair<int, int>>> graph(n);
        for (const auto& edge :edges) {
            int u= edge[0], v =edge[1], w = edge[2];
            graph[u].emplace_back(v, w);
            graph[v].emplace_back(u, w);

        }
        int m=edges.size();
        vector<bool> answer(m, false);
        auto dijkstra = [&](int start) { 
            vector<int> dist(n, INT_MAX); 
            dist[start] = 0;
            priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int,int>>> pq;
            pq.emplace(0, start);
            while (!pq.empty()) {
                auto [d, u]=pq.top();
                pq.pop();
                if (d> dist[u]) {
                    continue;
                }
                for (const auto& [v, w]: graph[u]) {
                    if (dist[u] + w< dist[v]) {
                        dist[v] =dist[u] + w;
                        pq.emplace(dist[v], v);
                    }
                }
            }
            return dist;
        };
        vector<int> fdist=dijkstra(0);
        if(fdist[n-1]==INT_MAX){
            return answer;
        }
      vector<int> rdist= dijkstra(n-1);

for (int i = 0; i < m; i++) {

int u= edges[i][0], v =edges[i][1], w = edges[i][2];

if (fdist[u]+w+rdist[v] == fdist[n -1] || fdist[v]+w+rdist[u]==fdist[n-1]) {

answer[i] =true;
}
}
return answer;
    }
};