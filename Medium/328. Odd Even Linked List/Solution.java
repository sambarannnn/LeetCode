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
    public ListNode oddEvenList(ListNode head) {
        if(head == null) 
            return null;
        else {
            ListNode odd = head;
            ListNode even = head.next;
            ListNode even_head = even;
            while(true) {
                if(odd == null || even == null || even.next == null) {
                    odd.next = even_head;
                    break;
                }
                //odd moves ahead
                odd.next = even.next;
                odd = even.next;    
                //after moving odd, if it reaches end
                if(odd.next == null) {
                    even.next = null;
                    odd.next = even_head;
                    break;
                } else {//even moves ahead
                    even.next = odd.next;
                    even = odd.next;
                }
            }
        }
        return head;
    }
}
