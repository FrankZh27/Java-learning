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
    
    Map<TreeNode, TreeNode> map = new HashMap<>();
    List<TreeNode> list = new ArrayList<>();
    int maxDepth = 0;
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }
        helper(root, 0);
        Queue<TreeNode> queue = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            queue.offer(list.get(i));
        }
        while (queue.size() > 1) {
            TreeNode node = queue.poll();
            if (map.get(node) == queue.peek()) {
                return map.get(node);
            }
            queue.offer(map.get(node));
        }
        return queue.peek();
    }
    
    private void helper(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                list.clear();
                list.add(root);
                return;
            }
            if (depth == maxDepth) {
                list.add(root);
            }
            return;
        }
        if (root.left == null) {
            map.put(root.right, root);
            helper(root.right, depth+1);
        }
        else if (root.right == null) {
            map.put(root.left, root);
            helper(root.left, depth+1);
        }
        else {
            map.put(root.left, root);
            map.put(root.right, root);
            helper(root.left, depth+1);
            helper(root.right, depth+1);
        }
        return;
    }
}
