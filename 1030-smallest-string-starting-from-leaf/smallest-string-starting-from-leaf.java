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
    public List<String> pq= new ArrayList<>();
    public String smallestFromLeaf(TreeNode root) {
        if(root==null) return "";
        helper(root,"");
        Collections.sort(pq);
        return pq.get(0);
    }
    public void helper(TreeNode root, String s){
        if(root == null){
            return;
        }
        if(root.left==null && root.right==null){
            String curr=s+((char)(root.val+97));
            StringBuilder sb = new StringBuilder(curr);
            pq.add(sb.reverse().toString());
            return;
        }
        helper(root.left,s+((char)(root.val+97)));
        helper(root.right,s+((char)(root.val+97)));
    }
}