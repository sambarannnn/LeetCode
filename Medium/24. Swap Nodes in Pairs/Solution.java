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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode p = head, q = null, prev = null;
        head = p.next;
        //for even && for odd
        while(p != null && p.next != null) {
            //next pointer
            q = p.next;
            // if(q == null)
            //     break;
            //SWAPPING DONE HERE
            p.next = q.next;
            q.next = p;
            //ATTACHING CURR SWAPPED NODESET TO PREV LIST
            if(prev != null)
                prev.next = q;
            //MARKING PREV FOR CONNECTING FUTURE NODES
            prev = p;
            p = p.next;
        }
        return head;
    }
}
