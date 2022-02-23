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
    
    public ListNode mergeKLists(ListNode[] lists) {
         //O(NLOGK APPROACH)
        //HEAP 
        if(lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        PriorityQueue<ListNode> minheap = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null)
                minheap.add(lists[i]);
        }
        while(!minheap.isEmpty()) {
            ListNode curr = minheap.remove();
            head.next = curr;
            head = head.next;
            if(curr.next != null) {
                minheap.add(curr.next);
            }
        }
        return dummy.next;
        //O(NLOGK APPROACH)
        //DIVIDE AND CONQUER 
        // if(lists.length == 0) {
        //     return null;
        // }
        // return mergeKLists(lists, 0, lists.length-1);
        
        // //O(KN APPROACH)
        // if(lists.length == 1) {
        //     return lists[0];
        // }
        // ListNode head = mergeTwoLists(lists[0], lists[1]);
        // for(int i = 2; i < lists.length; i++) {
        //     head = mergeTwoLists(head, lists[i]);
        // }
        // return head;
    }
    public ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if(start == end) {
            return lists[start];
        }
        int mid = start + (end-start)/2;
        ListNode left = mergeKLists(lists, start, mid);
        ListNode right = mergeKLists(lists, mid+1, end);
        
        return mergeTwoLists(left, right);
    }
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                head.next = head1;
                head = head.next;
                head1 = head1.next;
            } else {
                head.next = head2;
                head = head.next;
                head2 = head2.next;
            }
        }
        while(head1 != null) {
            head.next = head1;
            head = head.next;
            head1 = head1.next;
        }
        while(head2 != null) {
            head.next = head2;
            head = head.next;
            head2 = head2.next;
        }
        return dummy.next;
    }
}
