import java.util.*;

class Solution {

    public int height(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public void nthlevel(TreeNode root, int n, List<Integer> list) {
        if (root == null) return;
        if (n == 1) {
            list.add(root.val);
            return;
        }
        nthlevel(root.right, n - 1, list);
        nthlevel(root.left, n - 1, list);
    }

    public void nthlevel2(TreeNode root, int n, List<Integer> list) {
        if (root == null) return;
        if (n == 1) {
            list.add(root.val);
            return;
        }
        nthlevel2(root.left, n - 1, list);
        nthlevel2(root.right, n - 1, list);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        int level = height(root) + 1;

        for (int i = 1; i <= level; i++) {
            List<Integer> arr = new ArrayList<>();
            if (i % 2 == 0) {
                nthlevel(root, i, arr);    // right to left
            } else {
                nthlevel2(root, i, arr);   // left to right
            }
            result.add(arr);
        }

        return result;
    }
}