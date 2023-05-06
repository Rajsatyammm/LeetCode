// 83. Remove Duplicates from Sorted List

class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        // Recursive Approach
        // if(head == null || head.next == null) {

        //     return head;
        // }

        // ListNode newHead = deleteDuplicates(head.next);
        // if(newHead.val == head.val) {
        //     return newHead;
        // }
        // else {
        //     head.next = newHead;
        //     return head;
        // }


        // Iterative Approach
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = head;
        // ListNode temp = dummy.next;
        while(head.next != null) {
            if(head.val == head.next.val) {
                head.next = head.next.next;
            }
            else {
                head = head.next;
            }
        }
        return dummy;
    }
}
