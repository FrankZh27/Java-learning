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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }
        return hasSameRoot(s, t);
    }
    
    private boolean hasSameRoot(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }
        boolean temp = false;
        if (s.val == t.val) {
             temp = isSame(s, t);
        }
        return temp || hasSameRoot(s.left, t) || hasSameRoot(s.right, t);
    }
    
    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null
            || (s.val != t.val)) {
            return false;
        }
        if (s.val == t.val) {
            return isSame(s.left, t.left) && isSame(s.right, t.right);
        }
        return true;
    }
}
