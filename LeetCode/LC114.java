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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        if (root.left == null) {
            flatten(root.right);
            return;
        }
        else {
            flatten(root.left);
            if (root.right == null) {
                root.right = root.left;
                root.left = null;
                return;
            }
            else {
                flatten(root.right);
                TreeNode right = root.right;
                root.right = root.left;
                root.left = null;
                while (root.right != null) {
                    root = root.right;
                }
                root.right = right;
                return;
            }
        }
        
    }
}
