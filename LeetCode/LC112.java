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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return helper(root, sum);
    }
    public boolean helper(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                return true;
            }
            else {
                return false;
            }
        }
        boolean left = false, right = false;
        if (root.left != null) {
            left = helper(root.left, sum-root.val);
        }
        if (root.right != null) {
            right = helper(root.right, sum-root.val);
        }

        return left||right;
        
    }
}
