class Solution {
    public double averageWaitingTime(int[][] customers) {
        int start=0;
         double total=0;
         int n=customers.length;

        for(int i=0;i<n;i++){      
           start=Math.max(start,customers[i][0]);
           start+=customers[i][1];
           total+=start-customers[i][0];
        }
      return total/n;
    }
}