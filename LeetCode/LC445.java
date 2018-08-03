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
        Stack<Integer> num1 = new Stack<>();
        Stack<Integer> num2 = new Stack<>();
        Stack<Integer> ans = new Stack<>();
        int carry = 0;
        while (l1 != null) {
            num1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            num2.push(l2.val);
            l2 = l2.next;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (!num1.isEmpty() || !num2.isEmpty()) {
            int curr = 0;
            if (!num1.isEmpty()) {
                curr += num1.pop();
            }
            if (!num2.isEmpty()) {
                curr += num2.pop();
            }
            curr += carry;
            if (curr > 9) {
                carry = 1;
            }
            else {
                carry = 0;
            }
            curr = curr % 10;
            ans.push(curr);
        }
        if (carry > 0) {
            ans.push(1);
        }
        
        while (!ans.isEmpty()) {
            ListNode node = new ListNode(ans.pop());
            head.next = node;
            head = head.next;
        }
        return dummy.next;
        
    }
}
