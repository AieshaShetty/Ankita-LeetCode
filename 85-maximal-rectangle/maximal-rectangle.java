class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n];
           
        int ans = Integer.MIN_VALUE;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
               heights[j] = matrix[i][j] == '1' ? heights[j] + 1: 0;
            }
            ans = Math.max(ans, getMAH(heights, n));
        }
        
        return ans;
    }
    
    private int getMAH(int[] heights, int n) {
        int maxArea = Integer.MIN_VALUE;
        List<Integer> nsl = NSL(heights, n);
        List<Integer> nsr = NSR(heights, n);
        int[] width = new int[n];
        
        for(int i=0; i<n; i++)
            width[i] = nsr.get(i) - nsl.get(i) - 1;
                
        for(int i=0; i<n; i++) {
            int area = heights[i] * width[i];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
    
    
    private List<Integer> NSL(int[] heights, int n) {
            
        List<Integer> nsl = new ArrayList<>();
        Stack<int[]> st = new Stack<>();
        
        for(int i=0; i<n; i++) {
            int curr = heights[i];
            while(!st.isEmpty() && st.peek()[0] >= curr) { st.pop(); }
            if(st.isEmpty()) nsl.add(-1);
            else nsl.add(st.peek()[1]);
            st.add(new int[] { curr, i });
        }
        
        return nsl;
    }
    
    
     private List<Integer> NSR(int[] heights, int n) {
            
        List<Integer> nsr = new ArrayList<>();
        Stack<int[]> st = new Stack<>();
        
        for(int i=n-1; i>=0; i--) {
            int curr = heights[i];
            while(!st.isEmpty() && st.peek()[0] >= curr) { st.pop(); }
            if(st.isEmpty()) nsr.add(n);
            else nsr.add(st.peek()[1]);
            st.add(new int[] { curr, i });
        }
         
        Collections.reverse(nsr);
        return nsr;
    }
    
}