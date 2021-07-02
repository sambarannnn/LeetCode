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
    public ListNode sortList(ListNode head) {
        //mergesort
        //to find middle of list
        if(head == null || head.next == null)
            return head;
        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //now slow is pointing at middle of the list
        //temp is pointing at node behind slow
        //slow is the head of 2nd list
        //temp is the tail of first list
        
        temp.next = null;
        
        ListNode left = sortList(head);//left list
        ListNode right = sortList(slow);//right list
        
        return merge(left, right);
    }
    
    private ListNode merge(ListNode head1, ListNode head2) {
        
        ListNode p = head1;
        ListNode q = head2;
        ListNode head = new ListNode(0); //dummy head
        ListNode merged = head;
        while(p != null && q != null) {
            if(p.val > q.val) {
                merged.next = q;
                q = q.next;
            } else {
                merged.next = p;
                p = p.next;
            }
            merged = merged.next;
        }
        
        if(q != null)
            merged.next = q;
        if(p != null)
            merged.next = p;
        
        return head.next;
    }
}
