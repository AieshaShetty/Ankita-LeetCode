class MyCircularDeque {
    Deque<Integer> dq;
    int size;
    int capacity;

    public MyCircularDeque(int k) {
        dq = new LinkedList<>();
        size = 0;
        capacity = k;
    }

    public boolean insertFront(int value) {
        if (size >= capacity) return false;
        dq.addFirst(value);
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (size >= capacity) return false;
        dq.addLast(value);
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (size <= 0) return false;
        dq.removeFirst();
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (size <= 0) return false;
        dq.removeLast();
        size--;
        return true;
    }

    public int getFront() {
        if (dq.isEmpty()) {
            return -1;
        } else {
            return dq.peekFirst();
        }
    }

    public int getRear() {
        if (dq.isEmpty()) {
            return -1;
        } else {
            return dq.peekLast();
        }
    }

    public boolean isEmpty() {
        return dq.isEmpty();
    }

    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */