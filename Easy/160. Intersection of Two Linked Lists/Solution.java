/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) 
            return null;
    
        ListNode p = headA;
        ListNode q = headB;
    
        //if a & b have different len, then we will stop the loop after second iteration
        while(p != q){
    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
        if(p == null)
            p = headB;
        else
            p = p.next;
            
        if(q == null)
            q = headA;
        else
            q = q.next;
    }
    
    return p;
       /*
        if(headA == null || headB == null)
            return null;
        
        Stack<ListNode> A = new Stack<ListNode>();
        Stack<ListNode> B = new Stack<ListNode>();
        ListNode hA = headA;
        ListNode hB = headB;
        while(hA != null) {
            A.push(hA);
            hA = hA.next;
        }
        while(hB != null) {
            B.push(hB);
            hB = hB.next;
        }
        
        ListNode result = null;
        while (!A.isEmpty() && !B.isEmpty()) {
            ListNode popA = A.pop();
            ListNode popB = B.pop();
            if (popA == popB) {
                result = popA;
                //continue;
            } else
                break;
        }
        
        return result;
        */
    }
}
