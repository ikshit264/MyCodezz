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
    public static HashMap<TreeNode, TreeNode> store = new HashMap<>();
    public static HashSet<TreeNode> visited = new HashSet<>();

    public void PreOrder(TreeNode curr, TreeNode parent) {
        if (curr == null) return;

        store.put(curr, parent);
        PreOrder(curr.left, curr);
        PreOrder(curr.right, curr);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        store.clear();
visited.clear();
        PreOrder(root, null);

        Queue<TreeNode> queue = new LinkedList();

        queue.offer(target);

        while(!queue.isEmpty() && k > 0){
            k -= 1;
            int size = queue.size();

            for (int i = 0; i < size; i++){
                TreeNode curr = queue.poll();

                visited.add(curr);

                if ( !visited.contains(curr.left) && curr.left != null) queue.offer(curr.left);
                if ( !visited.contains(curr.right) && curr.right != null) queue.offer(curr.right);
                TreeNode parent = store.get(curr);
                if (parent != null && !visited.contains(parent)) {
                    queue.offer(parent);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }
        return result;
    }
}