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
    
    private long totalSum;
    private long maxProduct;
    private static final int MOD= 1000000007;
    
    private long treeSum(TreeNode node){
        if(node==null) return 0;
        return node.val + treeSum(node.left) + treeSum(node.right);
    }

   private long postOrder(TreeNode node){
       if(node ==null) return 0;
       long leftSum=postOrder(node.left);
       long rightSum=postOrder(node.right);
       long totalExcludingCurrent = totalSum-(leftSum+rightSum);
       long bigProduct= Math.max((leftSum + totalExcludingCurrent) * rightSum, (rightSum + totalExcludingCurrent)*leftSum);
       maxProduct = Math.max(maxProduct, bigProduct);
       return leftSum + node.val + rightSum;
   }
    
    public int maxProduct(TreeNode root){
        totalSum= treeSum(root);
        maxProduct=0;
        postOrder(root);
        return (int) (maxProduct % MOD);
    }

}
