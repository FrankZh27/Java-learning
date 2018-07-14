/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        TreeLinkNode leftMostChild;
        TreeLinkNode currRoot = root;
        TreeLinkNode currChild = root;
        
        if (currRoot.left != null) {
            leftMostChild = currRoot.left;
        }
        else {
            leftMostChild = currRoot.right;
        }
        
        while (leftMostChild != null) {
            
            currChild = leftMostChild;
            
            while (currRoot != null) {
                if (currRoot.left != null) {
                    currChild.next = currRoot.left;
                    currChild = currChild.next;
                }
                if (currRoot.right != null) {
                    currChild.next = currRoot.right;
                    currChild = currChild.next;
                }
                currRoot = currRoot.next;
            }
            currRoot = leftMostChild;
            
            // find leftMostChild
            while (currRoot != null) {
                leftMostChild = currRoot.left;
                if (leftMostChild != null) {
                    break;
                }
                leftMostChild = currRoot.right;
                if (leftMostChild != null) {
                    break;
                }
                currRoot = currRoot.next;
            }
        }
    }
}
