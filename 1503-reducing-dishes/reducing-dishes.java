class Solution {
public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        
        int n = satisfaction.length;
        int maxSatisfaction = 0;
        int runningSum = 0;
        int totalSatisfaction = 0; // Stores the total sum of satisfaction
        
        for (int i = n - 1; i >= 0; i--) {
            runningSum += satisfaction[i];
            totalSatisfaction += runningSum;
            maxSatisfaction = Math.max(maxSatisfaction, totalSatisfaction);
        }
        
        return maxSatisfaction;
    }
}