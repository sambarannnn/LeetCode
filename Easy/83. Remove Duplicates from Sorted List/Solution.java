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
        ListNode p = head;//slow
        ListNode q = new ListNode();//fast
        while (p != null) {
            q = p.next;
            if(q == null)
                break;
            if (q.val == p.val) {
                p.next = q.next;
            } else {
                p = p.next;
            }
        }
        return head;    
    }
}
