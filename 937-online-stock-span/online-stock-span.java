class StockSpanner {
    Stack<int[]> st;
    int i = 0;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        while(!st.isEmpty() && price >= st.peek()[1]) st.pop();

        int ans;
            
        if(st.isEmpty()) ans = i - (-1);
        else ans = i - st.peek()[0];

        st.push(new int[]{i, price});

        i++;

        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */