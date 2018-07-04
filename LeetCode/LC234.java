/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode middle = findMiddle(head);
        ListNode newHead = reverseList(middle);
        while (newHead != null && head != null) {
            if (head.val != newHead.val) {
                return false;
            }
            newHead = newHead.next;
            head = head.next;
        }
        return true;

    }
    
    private ListNode findMiddle(ListNode head) {
        ListNode fast = head, slow = head;
        ListNode prev = new ListNode(-1);
        prev.next = head;
        while (fast != null && fast.next != null) {
            prev = prev.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }
    
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
