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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode merged = new ListNode(0);//dummy head node
        ListNode curr = merged;
        
        while(l1 != null & l2 != null) {
            if(l1.val <= l2.val) {
                curr.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                curr.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1 != null && l2 == null)
            curr.next = l1;
        if(l2 != null & l1 == null)
            curr.next = l2;
        
        return merged.next;
    }
}
