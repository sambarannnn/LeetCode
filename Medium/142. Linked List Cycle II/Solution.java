/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        //floyds cycle detection extended
        //similar method to find duplicate number in immutable array
        
        if(head == null)
            return head;
        
        ListNode slow = head;
        ListNode fast = head;
        
        do{
            slow = slow.next;
            fast = fast.next;
            if(fast != null)
                fast = fast.next;
        } while(fast != null && slow != null && slow != fast);
        if(slow != fast || slow == null || fast == null) {//loop terminated for absence of cycle
            return null;
        }
        //move slow to head
        //increment both by 1
        //the point where they meet is intersection point(has two incoming edges)
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
