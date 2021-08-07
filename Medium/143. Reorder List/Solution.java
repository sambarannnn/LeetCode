public class Solution {
    
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
      
         // step 1. cut the list to two halves
         // prev will be the tail of 1st half
         // slow will be the head of 2nd half
        
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode l1 = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //prev is at end of list1
        prev.next = null;
        
        //step 2. reverse the 2nd half
        ListNode p = slow;
        ListNode q = null;
        ListNode r = null;
        while(p != null) {
            r = q;
            q = p;
            p = p.next;
            q.next = r;
        }
        ListNode l2 = q;
         // step 3. merge the two halves
        while (l1 != null) {
            ListNode n1 = l1.next, n2 = l2.next;
            l1.next = l2;

            if (n1 == null)
                break;
            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    } 
}
