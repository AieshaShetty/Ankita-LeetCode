class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int count = 0;
        
        for (int i = 0; tickets[k] > 0; i = (i + 1) % tickets.length) {
            if (tickets[i] > 0) {
                tickets[i]--;
                count++;
            }
        }

        return count;
    }
}