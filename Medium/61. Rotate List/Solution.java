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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return head;
        int length = 0;
        ListNode p = head;
        while(p != null) { length++; p = p.next; }//find length
        k = k % length;//to keep k in our range
        
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 0; i < k; i++) fast = fast.next;//create a difference of k nodes between slow and fast
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        //fast is at the last node
        fast.next = head;
        //now, slow pointer is where we wanna rotate, head will be it's next node
        head = slow.next;
        slow.next = null;
        
        return head;
    }
}
