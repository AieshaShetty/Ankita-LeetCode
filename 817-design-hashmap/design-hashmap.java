class MyHashMap {
    private HashMap<Integer, Integer> data;

    public MyHashMap() {
        this.data=new HashMap<>();
    }
    
    public void put(int key, int value) {
        data.put(key,value);
    }
    
    public int get(int key) {
        return data.getOrDefault(key,-1);
    }
    
    public void remove(int key) {
        data.remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

