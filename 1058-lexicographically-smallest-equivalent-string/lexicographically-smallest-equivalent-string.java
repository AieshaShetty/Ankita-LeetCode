class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        HashMap<Character, List<Character>> map = new HashMap<>();
        DisJointSet ds = new DisJointSet(26);

        for(int i=0; i<s1.length(); i++) {
            int u = s1.charAt(i) - 'a';
            int v = s2.charAt(i) - 'a';
            ds.union(u, v);
        }

        for(int i=0; i<26; i++) {
            char ch = (char)('a' + i);
            char parent = (char) ('a' + ds.find(i));
            if(!map.containsKey(parent)) {
                map.put(parent, new ArrayList<>());
            }

            map.get(parent).add(ch);
        }

        for(Map.Entry<Character, List<Character>> entry: map.entrySet()) {
            Collections.sort(entry.getValue());
        }

        StringBuilder result = new StringBuilder();

        for(int i=0; i<baseStr.length(); i++) {
            int parent = ds.parent[baseStr.charAt(i) - 'a'];
            char ch = map.get((char)('a' + parent)).get(0);
            result.append(ch);
        }

        return result.toString();
    }
}

class DisJointSet {
    int[] size;
    int[] parent;

    public DisJointSet(int n) {
        size = new int[n];
        parent = new int[n];

        for(int i=0; i<n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int find(int node) {
        if(node == parent[node]) {
            return node;
        } else {
            parent[node] = find(parent[node]);
            return parent[node];
        }
    }

    public void union(int u, int v) {
        int ulp_u = find(u);
        int ulp_v = find(v);

        if(ulp_u == ulp_v) return;

        if(size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}