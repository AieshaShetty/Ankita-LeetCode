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
    public int leftx;
    public int rightx;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        size(root,x);
        int size2=n-rightx-leftx-1;
        int max=Math.max(size2,Math.max(leftx,rightx));
        
        int ans=n-max;
        if(max>ans)return true;
        return false;
        
    }
    public int size(TreeNode node,int x){
        if(node==null) return 0;
        int leftt=size(node.left,x);
        int rightt=size(node.right,x);
        
        if(node.val==x){
            leftx=leftt;
            rightx=rightt;
        }
        return leftt+rightt+1;
    }
}