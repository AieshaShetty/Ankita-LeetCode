class Node {
    int val;
    Node prev;
    Node next;

    Node(int v) {
        val = v;
        prev = null;
        next = null;
    }
}

class MyCircularQueue {
    Node head = new Node(0);
    Node tail = new Node(0);
    int size;
    int capacity;

    public MyCircularQueue(int k) {
        capacity = k;
        size = 0;
        head.next = tail;
        tail.prev = head;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        Node newNode = new Node(value);
        newNode.prev = tail.prev;
        tail.prev.next = newNode;
        newNode.next = tail;
        tail.prev = newNode;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        head.next = head.next.next;
        head.next.prev = head;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return head.next.val;
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return tail.prev.val;
    }

    public boolean isEmpty() {
        return head.next == tail;
    }

    public boolean isFull() {
        return size == capacity;
    }
}


/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */