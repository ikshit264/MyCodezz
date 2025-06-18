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
    int ans = 0;

    public int preOrder(TreeNode root){
        if (root == null) return 0;

        int left = preOrder(root.left);
        int right = preOrder(root.right);

        int dirLeft = 0, dirRight = 0;

        if (root.left != null && root.left.val == root.val){
            dirLeft += left + 1;
        }
        if (root.right != null && root.right.val == root.val){
            dirRight += right + 1;
        }

        ans = Math.max(ans, dirLeft + dirRight);

        return Math.max(dirLeft, dirRight);

    }

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        preOrder(root);
        return ans;
    }
}