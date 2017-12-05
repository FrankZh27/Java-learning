class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode curr = head;
        ListNode next = head.next;
        
        curr.next = null;
        ListNode prev = curr;
        curr = next;
        
        while(curr.next != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        curr.next = prev;
        return curr;
    }
}