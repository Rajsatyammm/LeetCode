// 148. Sort List

class Solution {
    
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while(curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        Collections.sort(list);
        curr = head;
        for(int i : list) {
            curr.val = i;
            curr = curr.next;
        }
        return head;
    }
}
