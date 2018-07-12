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
    int maxPath = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int junk = helper(root);
        return maxPath;
    }
    
    private int helper(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftArrow = helper(root.left);
        int rightArrow = helper(root.right);
        int currMax = leftArrow + rightArrow + 2;
        maxPath = currMax > maxPath ? currMax : maxPath;
        return leftArrow > rightArrow ? leftArrow+1 : rightArrow+1;
    }
}
