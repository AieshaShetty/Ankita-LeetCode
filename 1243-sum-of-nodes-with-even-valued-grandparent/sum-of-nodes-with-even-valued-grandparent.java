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
    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root.right, root.val, false)+ dfs(root.left, root.val, false);
    }
    public int dfs(TreeNode root, int parent, boolean grandParent){
        if(root==null) return 0;

        if(grandParent){
            return root.val+dfs(root.right, root.val, parent%2==0) + dfs(root.left, root.val, parent%2==0);
        }
        else{
            return dfs(root.right, root.val, parent%2==0) + dfs(root.left, root.val, parent%2==0);
        }
    }
}