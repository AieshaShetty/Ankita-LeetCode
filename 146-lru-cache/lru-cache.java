class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }
    
    private final int capacity;
    private final Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // Move the accessed node to the head
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            // Create a new node
            node = new Node();
            node.key = key;
            node.value = value;
            // Add to cache
            cache.put(key, node);
            // Add to the head
            addToHead(node);
            // Check if cache exceeds capacity
            if (cache.size() > capacity) {
                // Remove the least recently used node from the tail
                Node removed = removeFromTail();
                cache.remove(removed.key);
            }
        } else {
            // Update the value of existing node
            node.value = value;
            // Move the updated node to the head
            moveToHead(node);
        }
    }
    
    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    
    private void removeFromNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void moveToHead(Node node) {
        removeFromNode(node);
        addToHead(node);
    }
    
    private Node removeFromTail() {
        Node removed = tail.prev;
        removeFromNode(removed);
        return removed;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */