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
    int target; 
    int isSumTarget;

    public Boolean solve(TreeNode root, int targetSum){
       if ( root == null) return false;
       if (root.val == targetSum && root.left == null && root.right == null) return true;
       return solve(root.left, targetSum - root.val) || solve(root.right, targetSum - root.val);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return solve(root, targetSum);
    }
}