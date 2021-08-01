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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)
            return head;
        
        ListNode tail = head;
        while(tail.next != null)
            tail = tail.next;
        
        //build <x nodes using curr, buils >=x nodes using tail
        ListNode curr = head;
        ListNode last = tail;
        ListNode curr_prev = null;
        ListNode curr_next = null;
        
        while(curr != tail) {
            curr_next = curr.next;
            if(curr.val >= x) {
                if(curr_prev == null){//head is >= x
                    head = curr_next;
                } else {
                    curr_prev.next = curr_next;
                }
                curr.next = null;
                last.next = curr;
                last = last.next;
            } else {
                curr_prev = curr;
            }
            curr = curr_next;
        }
        
        if(tail.val >= x && last != tail) {
            if(curr_prev == null)//all elements in the list were larger
                head = tail.next;
            else
                curr_prev.next = tail.next;
            tail.next = null;
            last.next = tail;
            last = tail;
        }
        return head;
    }
}
