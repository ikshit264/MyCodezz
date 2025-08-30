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
    boolean result = true;
    public int solve(TreeNode root){
        if (root == null) return 0;

        int left = 1 + solve(root.left);
        int right = 1 + solve(root.right);
        if (Math.abs(left - right) > 1) {
            result = false;
        }
        return Math.max(right, left);
    }
    public boolean isBalanced(TreeNode root) {
        solve(root);
        return result;
    }
}