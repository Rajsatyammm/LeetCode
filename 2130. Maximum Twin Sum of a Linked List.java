// 2130. Maximum Twin Sum of a Linked List

class Solution {
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode nextP = curr.next;
            curr.next = prev;

            prev = curr;
            curr = nextP;
        }
        head = prev;
        return head;
    }
    public int pairSum(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = reverse(slow);
        ListNode curr = head;
        int max = 0;
        while(curr.next != null) {
            int currMax = newHead.val + curr.val;
            max = Math.max(currMax, max);
            newHead = newHead.next;
            curr = curr.next;
        }
        return max;
    }
}
