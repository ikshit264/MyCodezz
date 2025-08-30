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
    List<Integer> store;
    public void solve(TreeNode root){
        if (root == null) return;

        store.add(root.val);
        solve(root.left);
        solve(root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        store = new ArrayList<>();
        solve(root);
        return store;
    }
}