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
    Set<TreeNode> st;
    int ans=0;
    public int minCameraCover(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        st=new HashSet<>();
        st.add(null);
        dfs(root,null);
        return ans;
    }
    private void dfs(TreeNode root, TreeNode prev){
        if(root!=null){
            dfs(root.left, root);
            dfs(root.right,root);
            if((prev==null && !st.contains(root)) || !st.contains(root.left)|| !st.contains(root.right)){
                ans++;
                st.add(root);
                st.add(prev);
                st.add(root.left);
                st.add(root.right);
            }
        }
    }
}

