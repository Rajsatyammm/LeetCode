// 19. Remove Nth Node From End of List

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode curr = head;
        while(curr != null) {
            size++;
            curr = curr.next;
        }

        if(n == size) {
            return head.next;
        }

        int prevIndex = size - n;
        ListNode prevNode = head;
        int i = 1;
        while(i < prevIndex) {
            prevNode = prevNode.next;
            i++;
        }
        prevNode.next = prevNode.next.next;
        return head;
    }
}
