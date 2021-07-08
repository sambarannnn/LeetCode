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
    public ListNode removeElements(ListNode head, int val) {
        //skipping all the reqd elements at head
        while(head != null && head.val == val) 
            head = head.next;
        
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            //if next element is reqd ele, rearrange curr's next pointer to skip next ele
            if (curr.next.val == val) 
                curr.next = curr.next.next;
            //otherwise just continue traversing
            else 
                curr = curr.next;
        }
        
        return head;
    }
}
