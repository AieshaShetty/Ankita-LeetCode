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
    public boolean isLeaf(TreeNode leaf) {
        if(leaf == null) return false;
        return leaf.left == null && leaf.right == null;
    }
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;

        int l = sumOfLeftLeaves(root.left);
        int r = sumOfLeftLeaves(root.right);

        if(isLeaf(root.left)) return l + r + root.left.val;
        return l + r;
    }
}