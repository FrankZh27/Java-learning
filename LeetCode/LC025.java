/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int count = 0;
        ListNode curr = head;
        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }
        if (count == k) {
            curr = reverseKGroup(curr, k);
            while(count-- > 0) {
                ListNode tempNode = head.next;
                head.next = curr;
                curr = head;
                head = tempNode;
            }
            return curr;
        }
        else {
            return head;
        }
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode curr = head;
        int count = k;
        while (curr != null && count-- > 0) {
            curr = curr.next;
        }
        if (curr == null && count > 0) {
            return head;
        }
        if (curr == null) {
            count--;
        }
        curr = reverseKGroup(curr, k);
        ListNode tempNode = head;
        while (tempNode != null && count++ < k-2) {
            tempNode = tempNode.next;
            head.next = curr;
            curr = head;
            head = tempNode;
        }
        tempNode.next = curr;
        return tempNode;
    }
}
