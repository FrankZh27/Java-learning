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
    int max = 0;
    public int maxDepth(TreeNode root) {
        helper(0, root);
        return max;
    }
    
    private void helper(int depth, TreeNode root) {
        if (root == null) {
            return;
        }
        max = depth+1 > max ? depth+1 : max;
        helper(depth+1, root.left);
        helper(depth+1, root.right);
        return;
    }
}
