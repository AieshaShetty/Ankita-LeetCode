class FrontMiddleBackQueue {
    private LinkedList<Integer> left;
    private LinkedList<Integer> right;

    public FrontMiddleBackQueue() {
        left = new LinkedList<>();
        right = new LinkedList<>();
    }

    private void moveElemToRight() {
        int lastVal = left.removeLast();
        right.addFirst(lastVal);
    }

    private void moveElemToLeft() {
        int frontVal = right.removeFirst();
        left.addLast(frontVal);
    }

    public void pushFront(int val) {
        left.addFirst(val);
        if (left.size() - right.size() > 1) {
            moveElemToRight();
        }
    }

    public void pushMiddle(int val) {
        if (left.size() == right.size()) {
            left.addLast(val);
        } else {
            moveElemToRight();
            left.addLast(val);
        }
    }

    public void pushBack(int val) {
        right.addLast(val);
        if (right.size() > left.size()) {
            moveElemToLeft();
        }
    }

    public int popFront() {
        if (left.isEmpty()) {
            return -1;
        }
        int val = left.removeFirst();
        if (left.size() < right.size()) {
            moveElemToLeft();
        }
        return val;
    }

    public int popMiddle() {
        if (left.isEmpty()) {
            return -1;
        }
        int val = left.removeLast();
        if (left.size() < right.size()) {
            moveElemToLeft();
        }
        return val;
    }

    public int popBack() {
        if (right.isEmpty()) {
            if (left.isEmpty()) {
                return -1;
            } else {
                return popFront();
            }
        }
        int val = right.removeLast();
        if (left.size() - right.size() > 1) {
            moveElemToRight();
        }
        return val;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */