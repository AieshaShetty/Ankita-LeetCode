class Solution {
    public int numTimesAllBlue(int[] flips) {
        int cnt = 0;
        int max_ = 0;
        int result = 0;
        
        for (int elem : flips) {
            cnt++;
            max_ = Math.max(max_, elem);
            if (cnt == max_) {
                result++;
            }
        }
        return result;
    }
}
