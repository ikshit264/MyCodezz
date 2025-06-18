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
    int res = 0;
    public int preOrder (TreeNode root){
        if (root == null) return 0;

        int l_extra = preOrder(root.left);
        int r_extra = preOrder(root.right);

        int extra = l_extra + r_extra + root.val - 1;

        res += Math.abs(extra);

        return extra;
    }
    public int distributeCoins(TreeNode root) {
        res = 0; 
        preOrder(root);
        return res;
    }
}