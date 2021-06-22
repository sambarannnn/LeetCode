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
    public boolean hasCycle(ListNode head) {
        ListNode p = head, q = head;
        if(head == null || head.next == null)
            return false;
        do {
            p = p.next;
            q = q.next;
            if(q != null)
                q = q.next;
        } while(p != null && q != null && p != q);
        if(p == q)
            return true;
        return false;
    }
}
