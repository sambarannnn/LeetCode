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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode slow = null;
        ListNode fast = head;
        
        while(fast != null) {
            if(fast.next != null && fast.val == fast.next.val) {
                ListNode del = fast;
                while(fast != null && fast.val == del.val) 
                    fast = fast.next;
                if(head == del) {
                    head = fast;
                    slow = fast;
                } else {
                    slow.next = fast;
                }
            }else {
                slow = fast;
                fast = fast.next;
            }
        }
        return head;
    }
}
