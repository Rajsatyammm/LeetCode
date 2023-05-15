// 1721. Swapping Nodes in a Linked List

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode left = head, right = head;
        
        for (int i = 1; i < k; i++) {
            left = left.next;
        }
        
        ListNode curr = left;
        while (curr.next != null) {
            curr = curr.next;
            right = right.next;
        }
        
        int temp = left.val;
        left.val = right.val;
        right.val = temp;
        
        return head;
    }
}
