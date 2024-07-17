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
    private int pos = 0;
    private List<Integer> ans = new ArrayList<>();

    private boolean dfs(TreeNode root, int[] voyage) {
        if (pos == voyage.length || root == null) {
            return true;
        }
        if (root.val != voyage[pos]) {
            return false;
        }

        pos++;
        if (pos < voyage.length && root.left != null && root.left.val != voyage[pos]) {
            ans.add(root.val);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        boolean leftResult = dfs(root.left, voyage);
        boolean rightResult = dfs(root.right, voyage);

        return leftResult && rightResult;
    }

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        ans.clear();
        if (!dfs(root, voyage)) {
            ans.clear();
            ans.add(-1);
        }
        return ans;
    }
}
