// 24. Swap Nodes in Pairs

class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode curr = head.next.next;
        ListNode prev = head;
        head = head.next;
        head.next = prev;

        while(curr != null && curr.next != null) {
            prev.next = curr.next;
            prev = curr;
            ListNode temp = curr.next.next;
            curr.next.next = curr;
            curr = temp;
        }
        prev.next = curr;
        return head;
        
    }
}
