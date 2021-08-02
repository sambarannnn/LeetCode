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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //perform normal reversal of linked list only in the given range
        //then connect the left and right endings of the reversed list properly
        
        ListNode p = head;
        ListNode q = null;
        ListNode r = null;
        int pos = 1;
        
        //bring p to the first node who's next link has to be altered
        //i.e. bring q to the first node to be reversed
        //r will be at the last proper node from the left
        while(pos <= left) {
            r = q;
            q = p;
            p = p.next;
            pos++;
        }
        ListNode leftend = r;
        ListNode start = q;
        
        //now q is at first left node(left)
        //update the links of all nodes until we cross right
        while(pos <= right) {
            r = q;
            q = p;
            p = p.next;
            q.next = r;
            pos++;
        }
        
        ListNode rightend = p;
        ListNode end = q;
        if(leftend != null) {//this will be nul if left = 1 , i.e., we had to reverse the head too
            leftend.next = end;
        } else {//if we have to reverse the head as well
            head = end;
        }
        //connect the first node of the tobe reversed segment to the first unchanged node of the right side
        //in case, all the nodes in right were to be reversed, right end will be null, 
        start.next = rightend;
        return head;
    }
}
