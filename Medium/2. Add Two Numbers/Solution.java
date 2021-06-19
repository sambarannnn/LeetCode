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

//You are given two non-empty linked lists representing two non-negative integers. 
//The digits are stored in reverse order, and each of their nodes contains a single digit. 
//Add the two numbers and return the sum as a linked list.
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);//just to keep track of it's next elements which will be built by curr
        ListNode p = l1, q = l2, curr = result;
        int x, y, sum, carry = 0;
        //continue even if any one becomes null. stop if both become null
        while (p != null || q != null) {
            //if either node reaches null, add zero in its place, since ll is reversed, we are basically adding leading zeroes
            if(p != null)
                x = p.val;
            else
                x = 0;
            if(q != null)
                y = q.val;
            else
                y = 0;
            //carry from previous iteration, i.e. from lower place
            sum = carry + x + y;
            //if sum is [0-19] carry will be [0-1] i.e. takes ten's place value
            carry = sum/10;
            //while adding the sum make sure it's single digit number[0-9] as tens place wouldve already been taken by carry
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(p != null)
                p = p.next;
            if(q != null)
                q = q.next;
        }
        //at the end if it carry has some value, add it to the end of the list(1st element)
        if(carry > 0)
            curr.next = new ListNode(carry);
        //now curr had built the new list from result's next node result's first node is just a dummy value with 0 so we skip past that
        result = result.next;
        return result;
    }
}
