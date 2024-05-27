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
    public int includeRoot=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        return Math.max(egdes(root),includeRoot);
        
    }
    private int egdes(TreeNode root){
        if(root== null) return -1;
        
        int leftSide= egdes(root.left)+1;
        int rightSide= egdes(root.right)+1;
        
        includeRoot=Math.max(leftSide+rightSide, includeRoot);
        return Math.max(leftSide,rightSide);
        
    }
}