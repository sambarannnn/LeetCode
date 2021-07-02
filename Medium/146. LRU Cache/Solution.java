class LRUCache {
    
    private  class Node {
        int key;
        int value;
        Node next;
        Node prev;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
    
    private void delete(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void insertAtHead(Node node) {//repositioning to head . The idea is to have the least used at tail
        //we always insert at head, pushing tail backwards
        // all the recently used keys will be at tail
        node.next = head.next;
        head.next.prev = node;
        
        head.next = node;
        node.prev = head;
    }
    
    private int capacity;
    //using a hashmap for O(1) access
    //key : key | value : corresponding Node
    private HashMap<Integer, Node> map;
    //maintain a doubly linked list for fast deletion and repositioning
    private Node head;//maintined as first dummy node to give instant access to real head node(head.next)
    private Node tail;//maintained as last dummy node to give instant access to real tail node(tail.prev)
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        //we make them a doubly linked list
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            //remove and move to head as recently used
            Node get = map.get(key);
            delete(get);//removed from list but still exists as node
            insertAtHead(get);
            return get.value;
        } else
            return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node get = map.get(key);
            delete(get);//removed from list but still exists as node
            get.value = value;
            insertAtHead(get);
        } else {
            if(map.size() == capacity) {
                //remove tail
                Node toberemoved = map.get(tail.prev.key);
                map.remove(toberemoved.key);
                delete(toberemoved);
            }
            Node newnode = new Node(key, value);
            insertAtHead(newnode);
            map.put(key, newnode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
