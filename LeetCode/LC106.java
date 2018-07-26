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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    private TreeNode helper(int[] inorder, int inLeft, int inRight,
                            int[] postorder, int poLeft, int poRight) {
        if (inLeft > inRight || poLeft > poRight) {
            return null;
        }
        int shift = 0;
        TreeNode root = new TreeNode(postorder[poRight]);
        for (int i = inLeft; i <= inRight; i++) {
            shift++;
            if (inorder[i] == root.val) {
                break;
            }
        }
        
        TreeNode leftRoot = helper(inorder, inLeft, inLeft+shift-2, postorder, poLeft, poLeft+shift-2);
        TreeNode rightRoot = helper(inorder, inLeft+shift, inRight, postorder, poLeft+shift-1, poRight-1);
        root.left = leftRoot;
        root.right = rightRoot;
        return root;
    }
}
