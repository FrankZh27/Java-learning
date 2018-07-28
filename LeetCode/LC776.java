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
    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode[] res = new TreeNode[2];
        if (root == null) {
            return res;
        }
        if (root.val <= V) {
            res[0] = root;
            TreeNode[] temp = splitBST(root.right, V);
            root.right = temp[0];
            res[1] = temp[1];
            return res;
        }
        res = splitBST(root.left, V);
        root.left = res[1];
        res[1] = root;
        return res;
    }
}
