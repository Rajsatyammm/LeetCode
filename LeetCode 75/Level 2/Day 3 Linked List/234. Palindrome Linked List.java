// 234. Palindrome Linked List

class Solution {
    public ListNode reverse(ListNode head) {
        ListNode prevNode = null;
        ListNode currNode = head;
        while(currNode != null) {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;

            //update
            prevNode = currNode;
            currNode = nextNode;
        }
        head = prevNode;
        return prevNode;
    }

    public ListNode findMiddle(ListNode head) {
        ListNode rabbit = head;
        ListNode turtle = head;

        while(rabbit.next != null && rabbit.next.next != null) {

            rabbit = rabbit.next.next;
            turtle = turtle.next;
        }
        return turtle;
    }

    public boolean isPalindrome(ListNode head) 
    {
        if(head == null || head.next == null) {
            return true;
        }

        ListNode middle = findMiddle(head);
        ListNode secondHalfStart = reverse(middle.next);

        //now compare
        ListNode firstHalfStart = head;
        while(secondHalfStart != null) 
        {
            if(firstHalfStart.val != secondHalfStart.val) {
                return false;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }
        return true;
    }
}
