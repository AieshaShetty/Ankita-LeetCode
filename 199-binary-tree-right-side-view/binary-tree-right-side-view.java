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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<Integer>();
        rightView(root,0,result);
        return result;
    }
    public void rightView(TreeNode curr_root,int level, List<Integer> result){
        if(curr_root==null) return;
        if(level==result.size()) result.add(curr_root.val);
        
        rightView(curr_root.right, level+1,result);
        rightView(curr_root.left, level+1,result);
        
        /*if left view is given then 
        rightView(curr_root.left, level+1,result);
        rightView(curr_root.right, level+1,result);
        */
        //TC: O(N), SC: O(H) By using reverse preorder traversal (Root Right Left)
    }
    
}