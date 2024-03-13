class MyHashSet {
    boolean[] setArr;
    public MyHashSet() {
        setArr = new boolean[(int)1e6+1];
    }
    
    public void add(int key) {
        setArr[key] = true;
    }
    
    public void remove(int key) {
        setArr[key] = false;
    }
    
    public boolean contains(int key) {
        return setArr[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
