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
    public TreeNode makeTree(int[] nums, int l, int r)
    {
        TreeNode head = new TreeNode();
        if(l>r)
            return null;
        head.val = nums[(l+r)/2];
        head.left = makeTree(nums, l, (l+r)/2 -1);
        head.right = makeTree(nums, (l+r)/2 +1, r);
        return head;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode head = new TreeNode();
        head.val = nums[nums.length/2];
        head.left = makeTree(nums, 0, nums.length/2 -1);;
        head.right = makeTree(nums, nums.length/2 +1, nums.length-1);;
        return head;
        
    }
}