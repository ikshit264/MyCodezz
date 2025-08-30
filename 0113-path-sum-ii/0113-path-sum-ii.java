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
    int targetSum;
    List<List<Integer>> store;
    public void solve(TreeNode root, int currSum, List<Integer> temp){
        if (root == null) return;

        currSum += root.val;
        temp.add(root.val);

        if (root.left == null && root.right == null && currSum == targetSum) {
            store.add(new ArrayList<>(temp));
        }

        // recursive call
        solve(root.left, currSum, temp);
        solve(root.right, currSum, temp);

        temp.remove(temp.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        store = new ArrayList<>();
        this.targetSum = targetSum;
        solve(root, 0, new ArrayList<>());
        return store;
    }
}