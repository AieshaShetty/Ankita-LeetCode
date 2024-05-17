/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

     // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root, sb);
        return sb.toString();
    }

    private void dfsSerialize(TreeNode node, StringBuilder sb){
        addNode(sb, node);
        if(node == null){
            return;
        }
        dfsSerialize(node.left, sb);
        dfsSerialize(node.right, sb);
    }
    
    private StringBuilder addNode(StringBuilder sb, TreeNode node){
        if(sb.length() > 0){
            sb.append(",");
        }
        String value = node == null ? "null" : String.valueOf(node.val);
        sb.append(value);
        return sb;
    }
    private int i = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArr = data.split(",");
        return dfsDeserialize(dataArr);
    }
    
    private TreeNode dfsDeserialize(String[] dataArr){
        if(i == dataArr.length || dataArr[i].equals("null")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(dataArr[i]));
        i++;
        node.left = dfsDeserialize(dataArr);
        i++;
        node.right = dfsDeserialize(dataArr);
        return node;
    }
}

 

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));