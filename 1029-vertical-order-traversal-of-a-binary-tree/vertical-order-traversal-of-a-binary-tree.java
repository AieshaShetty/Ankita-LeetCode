/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair<TreeNode, Pair<Integer, Integer>>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, new Pair<>(0, 0)));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Pair<Integer, Integer>> p = queue.poll();
            TreeNode node = p.getKey();
            int vertical = p.getValue().getKey();
            int level = p.getValue().getValue();

            map.putIfAbsent(vertical, new TreeMap<>());
            map.get(vertical).putIfAbsent(level, new PriorityQueue<>());
            map.get(vertical).get(level).add(node.val);

            if (node.left != null) {
                queue.add(new Pair<>(node.left, new Pair<>(vertical - 1, level + 1)));
            }
            if (node.right != null) {
                queue.add(new Pair<>(node.right, new Pair<>(vertical + 1, level + 1)));
            }
        }

        for (Map<Integer, PriorityQueue<Integer>> levelMap : map.values()) {
            List<Integer> col = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : levelMap.values()) {
                while (!nodes.isEmpty()) {
                    col.add(nodes.poll());
                }
            }
            ans.add(col);
        }

        return ans;
    }
}