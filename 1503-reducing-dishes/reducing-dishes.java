class Solution {
public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        
        int n = satisfaction.length;
        int[] dp1 = new int[n + 1]; // Stores the maximum satisfaction ending at position i
        int[] dp2 = new int[n + 1]; // Stores the maximum satisfaction starting at position i
        
        // Fill dp2 from right to left
        dp2[n] = 0;
        int runningSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            runningSum += satisfaction[i];
            dp2[i] = dp2[i + 1] + runningSum;
        }
        
        // Fill dp1 from right to left
        int maxSatisfaction = 0;
        runningSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            runningSum += satisfaction[i];
            dp1[i] = Math.max(runningSum + dp1[i + 1], 0);
            maxSatisfaction = Math.max(maxSatisfaction, dp1[i]);
        }
        
        return maxSatisfaction;
    }
}