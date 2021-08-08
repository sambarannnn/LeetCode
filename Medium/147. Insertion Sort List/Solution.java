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
    public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return head;
        
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode curr = head;
        
        while(curr != null) {
            ListNode next = curr.next;
            
            if(curr.val < prev.val)//if current value to be inserted is smaller than end of sorted list
                prev = dummy;//move it to start of dummy list
            while(prev.next != null && prev.next.val < curr.val) {//move prev ahead while next value is smaller
                prev = prev.next;
            }
            //now, next value of prev is bigger than curr
            //curr is to be inserted between prev and prev.next
            curr.next = prev.next;
            prev.next = curr;
            //prev == dummy;//don't have to move prev to beginning, if the next element will be greater than the current element we inserted
            curr = next;
        }
        return dummy.next;
    }
}
