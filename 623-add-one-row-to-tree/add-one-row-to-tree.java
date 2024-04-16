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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
		
		/**
		* If depth == 1 that means there is no depth depth - 1 at all, 
		* then create a tree node with value val as the new root of the whole original tree, 
		* and the original tree is the new root's left subtree.
		**/
	
            TreeNode n = new TreeNode(val);
            n.left = root;
            return n;
        }
        
        dfs(root, val, depth, 1);
        return root;
    }
    
    public void dfs(TreeNode n, int val, int depth, int currDepth) {
        if(n == null) return;
        
        if(currDepth == depth - 1) {
		
		/**
		* The next level is the level to insert the new row
		**/
		
            n.left = new TreeNode(val, n.left, null);
            n.right = new TreeNode(val, null, n.right);
        } else {
            dfs(n.left, val, depth, currDepth+1);
            dfs(n.right, val, depth, currDepth+1);
        }
    }
}