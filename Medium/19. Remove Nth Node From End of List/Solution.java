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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        
        while(n-->0) 
            fast = fast.next;
        
        //if fast becomes null just by creating gap of n nodes, node to be deleted is head
        if(fast == null)
            return head.next;  // The head needs to be removed, do it.
        
        fast = fast.next;
        //created a gap of n+1 between fast and slow
        //so that slow stops behind the node to be deleted
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        //node to be deleted is the slow.next one
        slow.next = slow.next.next;   // the one after the slow needs to be removed

        return head;
    }
}
