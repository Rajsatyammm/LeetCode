// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */

// Approach 1 : 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for(ListNode l : lists) {
            if(l != null) {
                pq.add(l);
            }
        }

        ListNode dummy = new ListNode(0, null);
        ListNode prev = dummy;
        while(!pq.isEmpty()) {
            ListNode small = pq.poll();
            if(small.next != null) pq.add(small.next);
            prev.next = small;
            prev = prev.next;
        }
        prev.next = null;
        return dummy.next;
    }
}

// Approach 2 : 
// class Solution {
//     private ListNode merge(ListNode l1, ListNode l2) {
//         ListNode dummy = new ListNode(0, null);
//         ListNode ptr = dummy;
//         while(l1 != null && l2 != null) {
//             if(l1.val <= l2.val) {
//                 ptr.next = l1;
//                 l1 = l1.next;
//             }
//             else {
//                 ptr.next = l2;
//                 l2 = l2.next;
//             }
//             ptr = ptr.next;
//         }
//         while(l1 != null) {
//             ptr.next = l1;
//             l1 = l1.next;
//             ptr = ptr.next;
//         }
//         while(l2 != null) {
//             ptr.next = l2;
//             l2 = l2.next;
//             ptr = ptr.next;
//         }
//         return dummy.next;
//     }

//     public ListNode mergeKLists(ListNode[] lists) {
//         if (lists == null || lists.length == 0) {
//             return null;
//         }
        
//         int k = lists.length;
//         if(k == 1) return lists[0];
//         if(k == 2) {
//             ListNode head1 = lists[0];
//             ListNode head2 = lists[1];
//             // ListNode head = null
//             ListNode newHead = merge(head1, head2);
//             return newHead;   
//         } 
//         else {
//             ListNode head1 = lists[0];
//             ListNode head2 = lists[1];
//             // ListNode head = null
//             ListNode newHead = merge(head1, head2);
//             for(int i=2; i<lists.length; i++) {
//                 ListNode curr = lists[i];
//                 newHead = merge(newHead, curr);
//             }
//             return newHead;
//         }
//     }
// }

