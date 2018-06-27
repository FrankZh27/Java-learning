/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
/*
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        TreeLinkNode prev = new TreeLinkNode(-1);
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()) {
            TreeLinkNode node = queue.poll();
            prev.next = node;
            if (node == null) {
                if (queue.isEmpty()) {
                    return;
                }
                prev = new TreeLinkNode(-1);
                queue.offer(null);
            }
            else {
                prev = node;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return;
    }
}
*/

public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode parent = root;
        TreeLinkNode childHead = null;
        TreeLinkNode child = null;
        while (parent != null) {
            while (parent != null) {
                if (parent.left != null) {
                    if (child == null) {
                        childHead = parent.left;
                        child = parent.left;
                    }
                    else {
                        child.next = parent.left;
                        child = parent.left;
                    }
                }
                if (parent.right != null) {
                    if (child == null) {
                        childHead = parent.right;
                        child = parent.right;
                    }
                    else {
                        child.next = parent.right;
                        child = parent.right;
                    }
                }
                parent = parent.next;
            }
            parent = childHead;
            child = null;
            childHead = null;
        }
        return;
    }
}
