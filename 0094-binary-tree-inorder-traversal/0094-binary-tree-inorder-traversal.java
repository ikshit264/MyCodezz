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
import java.util.*;

class Solution {
    List<Integer> store;

    public void solve(TreeNode root){
        if (root == null) return;  // fix
        solve(root.left);
        store.add(root.val);       // fix
        solve(root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        store = new ArrayList<>();  // fix
        solve(root);
        return store;
    }
}
