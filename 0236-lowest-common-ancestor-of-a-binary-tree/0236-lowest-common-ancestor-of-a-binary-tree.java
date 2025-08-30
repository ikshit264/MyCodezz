class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base cases
        if (root == null || root == p || root == q) {
            return root;
        }
        
        // Recurse left and right
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // If p and q are in different subtrees, root is LCA
        if (left != null && right != null) {
            return root;
        }
        
        // Otherwise, return the side that is not null
        return (left != null) ? left : right;
    }
}
