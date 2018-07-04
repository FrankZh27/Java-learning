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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int min = findMin(root, 0);
        int max = findMax(root, 0);
        for (int i = min+1; i <= max-1; i++) {
            List<Integer> list = new ArrayList<Integer>();
            findCol(list, root, i);
            ans.add(list);
        }
        return ans;
    }
    
    private void findCol(List<Integer> list, TreeNode root, int target) {
        
        Map<TreeNode, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        map.put(root, 0);
        int count;
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            count = map.get(node);
            if (count == target) {
                list.add(node.val);
            }
            if (node.left != null) {
                queue.offer(node.left);
                map.put(node.left, count-1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                map.put(node.right, count+1);
            }
        }
        return;
    }
    
    private int findMin(TreeNode root, int n) {
        if (root == null) {
            return n;
        }
        int left = findMin(root.left, n-1);
        int right = findMin(root.right, n+1);
        return left < right ? left : right;
    }
    
    private int findMax(TreeNode root, int n) {
        if (root == null) {
            return n;
        }
        int left = findMax(root.left, n-1);
        int right = findMax(root.right, n+1);
        return left > right ? left : right;
    }
}
