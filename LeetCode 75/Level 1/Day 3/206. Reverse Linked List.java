// 206. Reverse Linked List

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode nextP = curr.next;
            curr.next = prev;

            //update
            prev = curr;
            curr = nextP;
        }
        curr = null;
        head = prev;
        return prev;
    }
}
