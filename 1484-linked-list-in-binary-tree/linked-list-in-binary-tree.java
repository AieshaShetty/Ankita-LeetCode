/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean dfs(TreeNode root, ListNode prev, ListNode current) {
        if (current == null) return true;
        if (root == null) return false;
        
        if (root.val != current.val) current = prev;
        if (prev.val == current.val) prev = current;
        
        if (root.val == current.val) current = current.next;
        
        return dfs(root.left, prev, current) || dfs(root.right, prev, current);
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        return dfs(root, head, head);
    }
}