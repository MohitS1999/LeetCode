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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        
        return helper(0,n-1,nums);
    }
    private TreeNode helper(int i,int j,int[] nums){
        if (i > j) return null;
        
        int mid = (i + j)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(i,mid-1,nums);
        node.right = helper(mid+1,j,nums);
        return node;
    }
}