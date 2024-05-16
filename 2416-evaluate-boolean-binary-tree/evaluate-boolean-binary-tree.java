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
    public boolean evaluateTree(TreeNode root) {
        return helper(root);
    }
    private boolean helper(TreeNode root) {
        // base case
        if (root.left == null || root.right == null) {
            // check the value of leaf
            return root.val == 1 ? true : false;
            // return
        }
        // left tree First
        boolean f1 = helper(root.left);
        // Right Tree use
        boolean f2 = helper(root.right);
        // process the Root Node
        boolean flag = false;
        if (root.val == 2) {
            flag = f1 || f2;
        } else {
            flag = f1 && f2;
        }
        return flag;

    }
}