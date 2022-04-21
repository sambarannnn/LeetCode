class MyHashSet {

    int[] hashSet;
    public MyHashSet() {
        hashSet = new int[1000001];
    }
    
    public void add(int key) {
        hashSet[key] = 1;
    }
    
    public void remove(int key) {
        hashSet[key] = 0;
    }
    
    public boolean contains(int key) {
        return hashSet[key] == 1;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
