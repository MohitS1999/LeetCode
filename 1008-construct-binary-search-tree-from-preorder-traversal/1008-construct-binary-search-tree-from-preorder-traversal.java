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
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        for (int i=1;i<n;i++){
            helper(root,preorder[i]);
        }
        return root;
    }
    private void helper(TreeNode root,int data){
        TreeNode node = root;
        while (true){
            if (node.val > data){
                if (node.left == null){
                    TreeNode temp = new TreeNode(data);
                    node.left = temp;
                    return;
                }else{
                    node = node.left;
                }
            }else{
                if (node.right == null){
                    TreeNode temp = new TreeNode(data);
                    node.right = temp;
                    return;
                }else{
                    node = node.right;
                }
            }
        }
       
    }
}