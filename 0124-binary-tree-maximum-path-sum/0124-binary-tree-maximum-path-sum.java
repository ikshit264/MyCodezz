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
    int res;

    public int preOrder(TreeNode root){
        if (root == null) return 0;

        int left = preOrder(root.left);
        int right = preOrder(root.right);

        left = Math.max(left, 0);
        right = Math.max(right, 0);

        res = Math.max(res, root.val + left + right);

        return Math.max(root.val + left, root.val + right);
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        res = root.val;
        preOrder(root);
        return res;
    }
}