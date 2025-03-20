class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        DSU dsu = new DSU(n);

        for (int temp[] : edges) {
            dsu.union(temp[0], temp[1]);

        }
        for (int temp[] : edges) {

            dsu.setWeight(dsu.find(temp[0]), temp[2]);
        }

        int ans[] = new int[query.length];
        for (int i = 0; i < ans.length; i++) {
            if (query[i][0] == query[i][1])
                continue;
            int a = dsu.find(query[i][0]);
            int b = dsu.find(query[i][1]);

            if (a == b)
                ans[i] = dsu.getWeight(a);
            else
                ans[i] = -1;
        }
        return ans;
    }
}

class DSU {

    int parent[];
    int weight[];

    public DSU(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        weight = new int[n];
        Arrays.fill(weight, -1);
    }

    public void union(int a, int b) {
        parent[find(a)] = find(parent[b]);
    }

    public void setWeight(int a, int w) {
        if (weight[a] != -1)
            weight[a] &= w;
        else
            weight[a] = w;
    }

    public int getWeight(int a) {
        return weight[a];
    }

    public int find(int a) {
        if (parent[a] == a)
            return a;
        parent[a] = find(parent[a]);
        return parent[a];

    }
}