/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int curr = 0, curr1 = 0, curr2 = 0;
        ListNode head = new ListNode(0);
        ListNode node = head;
        while (l1 != null || l2 != null) {
            curr1 = l1 == null ? 0 : l1.val;
            curr2 = l2 == null ? 0 : l2.val;
            curr = (curr1 + curr2 + carry)%10;
            carry = (curr1 + curr2 + carry)/10;
            ListNode temp = new ListNode(curr);
            node.next = temp;
            node = node.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            ListNode temp = new ListNode(1);
            node.next = temp;
        };
        return head.next;
    }
}
