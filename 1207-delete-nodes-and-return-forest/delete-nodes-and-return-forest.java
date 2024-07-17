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
    private static final int N = 1001;
    private Set<Integer> toDeleteSet = new HashSet<>();
    private List<TreeNode> ans = new ArrayList<>();

    private void dfs(TreeNode root, TreeNode parent, boolean isLeft) {
        if (root == null) return;
        if (toDeleteSet.contains(root.val)) {
            if (parent != null) {
                if (isLeft) parent.left = null;
                else parent.right = null;
            }
            dfs(root.left, null, true);
            dfs(root.right, null, false);
        } else {
            if (parent == null) 
                ans.add(root);
            dfs(root.left, root, true);
            dfs(root.right, root, false);
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int x : to_delete) 
            toDeleteSet.add(x);
        dfs(root, null, true);
        return ans;
    }
}

