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
/*class Solution {
    public boolean isCompleteTree(TreeNode root) {
        // level order traversal
        
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        boolean flag=false;
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp==null) flag=true;
            else{
                if(flag)return false;
                q.offer(temp.left);
                q.offer(temp.right);
            }
        }
        return true;
    }
    
}*/

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        // Get the total number of nodes in the tree
        int totalNodes = countNodes(root);

        // Check completeness using the helper function
        return isComplete(root, 0, totalNodes);
    }

    // Function to count the total number of nodes
    private int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    // Function to check completeness by validating indices
    private boolean isComplete(TreeNode node, int index, int totalNodes) {
        if (node == null) {
            return true;
        }

        // If the index is out of the expected range, the tree is not complete
        if (index >= totalNodes) {
            return false;
        }

        // Recursively check left and right subtrees
        return isComplete(node.left, 2 * index + 1, totalNodes) &&
               isComplete(node.right, 2 * index + 2, totalNodes);
    }
}
