/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<TreeNode> store;

    public boolean solve(TreeNode root, TreeNode target){
        if (root == null) return false;
        if (target == root) {
            store.add(root);
            System.out.print(root.val + " ");
            return true;
        }
        boolean left = solve(root.left, target);
        boolean right = solve(root.right, target);

        if (right || left){
            store.add(root);
            System.out.print(root.val + " ");
        }
        return right || left;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    store = new ArrayList<>();
    solve(root, p);
    List<TreeNode> pList = new ArrayList<>(store); // copy path for p
    
    store = new ArrayList<>();
    solve(root, q);

    // Compare paths
    int i = pList.size() - 1; // last = p itself
    int j = store.size() - 1; // last = q itself
    TreeNode lca = null;

    // Move backwards until paths diverge
    while (i >= 0 && j >= 0 && pList.get(i) == store.get(j)) {
        lca = pList.get(i);
        i--;
        j--;
    }
    return lca;
}

}