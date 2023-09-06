/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        if(k == 1) return new ListNode[] { head };
        int count = 0;
        ListNode curr = head;
        while(curr != null) {
            count++;
            curr = curr.next;
        }

        ListNode[] arr = new ListNode[k];
        curr = head;

        int avg = count / k;
        int extra = count % k;
        int j = 0;

        while(curr != null) {
            ListNode c = curr;
            ListNode dummy = new ListNode(-1);
            ListNode temp = dummy;

            for(int i=0; i<avg; i++) {
                temp.next = new ListNode(curr.val);
                curr = curr.next;
                temp = temp.next;
            }

            if(extra > 0) {
                temp.next = new ListNode(curr.val);
                curr = curr.next;
                temp = temp.next;
                extra--;
            }

            arr[j++] = dummy.next;
        }
        return arr;
    }
}