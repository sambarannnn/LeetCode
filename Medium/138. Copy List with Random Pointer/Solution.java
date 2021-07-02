/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //https://leetcode.com/problems/copy-list-with-random-pointer/discuss/258935/Detailed-Explanation-with-Pictures-C%2B%2BJavaScript
        if(head == null)
            return null;
        
        //key is the node in original list
        //value is it's corresponding node in the copied list
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        
        //lets make the new list, setting all random pointers of new list to null and maintaining original copy relationship using hashmap
        
        Node new_head = new Node(head.val);
        Node p = head.next;
        Node q = new_head;
        map.put(head, new_head);
        while(p != null) {
            q.next = new Node(p.val);
            map.put(p, q.next);
            p = p.next;
            q = q.next;
        }
        //now lets iterate over both the list simultaneously, setting the random pointers using the map references
        p = head;
        q = new_head;
        while(p != null) {
            q.random = map.get(p.random);
            p = p.next;
            q = q.next;
        }
        
         return new_head;
    }
}
