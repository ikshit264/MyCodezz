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
    public int preOrder(TreeNode root, int MaxValue){
        if (root == null) return 0;

        int res = (root.val >= MaxValue) ? 1 : 0;

        MaxValue = Math.max(root.val, MaxValue);

        res += preOrder(root.left, MaxValue);
        res += preOrder(root.right, MaxValue);
        return res;
    }
    public int goodNodes(TreeNode root) {
        return preOrder(root, root.val);
    }
}