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
    List<String> list;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = findLCA(root,startValue,destValue);
        list = new ArrayList<>();
        StringBuilder sbStart = new StringBuilder();
        StringBuilder sbDest = new StringBuilder();
        // finding the startValue
        find(lca,sbStart,startValue);
        find(lca,sbDest,destValue);
        return "U".repeat(list.get(0).length()) + list.get(1);
        
        
        
    }    
    
    private TreeNode findLCA(TreeNode root,int p,int q){
        if (root == null || root.val == p || root.val == q) return root;
        
        TreeNode left = findLCA(root.left,p,q);
        TreeNode right = findLCA(root.right,p,q);
        
        if (left == null) return right;
        else if (right == null) return left;
        return root;
    }
    
    private void find(TreeNode root,StringBuilder sb,int data){
        if (root == null){
            sb.deleteCharAt(sb.length()-1);
            return;
        }
        if (root.val == data){
            list.add(sb.toString());
            return;
        }
        
        find(root.left,sb.append("L"),data);
        find(root.right,sb.append("R"),data);
        sb.deleteCharAt(sb.length()-1);
        return;
    }
   
}