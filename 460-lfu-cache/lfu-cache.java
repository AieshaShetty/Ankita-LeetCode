class LFUCache {
    int cap;
    //minimum count present
    int min;
    
    //LRU for each count
    HashMap<Integer,Pair> frequency=new HashMap<>();
    //keeps node address against every key 
    HashMap<Integer,Node> indivEle=new HashMap<>();
    
    public LFUCache(int capacity) {
        cap=capacity;
        min=0;
    }
    
    public int get(int key) {
        //if the key is present
        if(indivEle.containsKey(key)){
            Node temp=indivEle.get(key);
            //increasing frequency
            temp.freq++;
            //delete the node from previous doubly linked list and add it with the nodes which have freq = temp.freq(new freq)
            frequency.get(temp.freq-1).delete(temp);
            
            //if there are no nodes in the previous linked list and it was the minimum count so increase value of min
            if(min==temp.freq-1 && frequency.get(temp.freq-1).size==0){
                min=min+1;
            }
            if(frequency.containsKey(temp.freq)){
                frequency.get(temp.freq).insert(temp);
            }
            else{
                Pair dll=new Pair();
                dll.insert(temp);
                frequency.put(temp.freq,dll);
            }
            return indivEle.get(key).value;
        }
        else
            return -1;
    }
    
    public void put(int key, int value) {
        //if some node is present with this key
        if(indivEle.containsKey(key)){
            //update value of the key
            indivEle.get(key).value=value;
            //deleting the node from the previous doubly linked list and adding it to the doubly linked list with new freq = freq+1
            frequency.get(indivEle.get(key).freq).delete(indivEle.get(key));
            //updating minimum if required
            if(min==indivEle.get(key).freq &&  frequency.get(indivEle.get(key).freq).size==0){
                min=min+1;
            }
            indivEle.get(key).freq++;
            
            //adding to new doubly linked list
            if(frequency.containsKey(indivEle.get(key).freq)){
                frequency.get(indivEle.get(key).freq).insert(indivEle.get(key));
            }
            else{
                Pair temp=new Pair();
                temp.insert(indivEle.get(key));
                frequency.put(indivEle.get(key).freq,temp);
            }
        }
        else{
            if(cap==0 && !frequency.isEmpty()){
                //removing node with least frequency
                indivEle.remove(frequency.get(min).strt.next.key);
                frequency.get(min).delete(frequency.get(min).strt.next);
                cap++;
            }
            if(cap>0){
                cap--;
                Node temp=new Node(key,value);
                if(frequency.containsKey(1)){
                    frequency.get(1).insert(temp);
                }
                else{
                    Pair dll=new Pair();
                    dll.insert(temp);
                    frequency.put(1,dll);
                }
                min=1;
                indivEle.put(key,temp);
            }
            
        }
    }
}

//doubly linked list for LRU
class Pair{
    Node strt;
    Node end;
    int size;
    Pair(){
        strt=new Node(-1,-1);
        end=new Node(-1,-1);
        strt.next=end;
        end.prev=strt;
        size=0;
    }
     //deleting node p from doubly linked list
    void delete(Node p){
        p.prev.next=p.next;
        p.next.prev=p.prev;
        p.next=null;
        p.prev=null;
        size--;
    }
    
    //inserting node p at the back
    void insert(Node p){
        p.prev=end.prev;
        end.prev.next=p;
        p.next=end;
        end.prev=p;
        size++;
    }
}

//for each node
class Node{
    int key;
    int value;
    int freq;
    Node next;
    Node prev;
    Node(int key,int value){
        this.key=key;
        this.value=value;
        freq=1;
        this.next=null;
        this.prev=null;
    }
}