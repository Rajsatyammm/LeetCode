//  203. Remove Linked List Elements

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;
        
        while(curr != null) {
            //1st node is the target node
            if(curr.val == val && curr == head) {
                head = head.next;
                curr = head;
                continue;
            }

            // at the end of Linked List
            if(curr.next == null) {
                break;
            }

            // target is next of curr
            if(curr.next.val == val) {
                curr.next = curr.next.next;
                continue;
            }

            curr = curr.next;
        }
        return head;
    }
}
