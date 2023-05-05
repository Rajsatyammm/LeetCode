// 203. Remove Linked List Elements

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr.next != null) {
            if(curr.val == val) {
                //delete
                prev = curr.next;
                curr.next = null;
                curr = prev.next;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
        
    }
}
