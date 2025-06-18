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

    public static int preOrder(TreeNode root, boolean isLeft, int depth){
        if (root == null) return depth;

        if (isLeft) {
            depth = Math.max(
                depth,
                Math.max(preOrder(root.left, true, 0),
                preOrder(root.right, false, depth+1))
            );
        }
        else {
            depth = Math.max(
                depth,
                Math.max(preOrder(root.left, true, depth+1),
                preOrder(root.right, false, 0))
            );
        }

        return depth;
    }

    public int longestZigZag(TreeNode root) {
        return Math.max(preOrder(root.left, true, 0), preOrder(root.right, false, 0));
    }
}