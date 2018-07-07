/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode node = head;
        ListNode prev = dummy;
        
        while (node != null) {
            if (node.val == val) {
                prev.next = node.next;
            }
            else {
                prev = prev.next;
            }
            node = node.next;
        }
        
        return dummy.next;
        
    }
}
