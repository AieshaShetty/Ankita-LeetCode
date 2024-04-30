class LRUCache {

   
    HashMap<Integer,Node>m;
    Node head,tail;
    int maxSize;

    public LRUCache(int capacity) {
        maxSize=capacity;
        m=new HashMap<>();
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
       if(m.containsKey(key)){
        Node curkey=m.get(key);
        remove(curkey);
        insert(curkey);
        return curkey.value;
       }
       else{
        return -1;
       }
    }
    public void insert(Node cur){
        m.put(cur.key,cur);
        Node headNext=head.next;
        head.next=cur;
        cur.prev=head;
        cur.next=headNext;
        headNext.prev=cur;
    }
    public void remove(Node cur){
        m.remove(cur.key);
        cur.prev.next=cur.next;
        cur.next.prev=cur.prev;
        
    }
    
    public void put(int key, int value) {
         if(m.containsKey(key)){
            remove(m.get(key));
        }
        if(m.size()==maxSize){
            remove(tail.prev);
        }
        insert(new Node(key,value));
    }
}
class Node{
    Node prev,next;
    int key,value;
    Node(int key,int value){
        this.key=key;
        this.value=value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */