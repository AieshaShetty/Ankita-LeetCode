class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int array[]=new int[60];
        int retVal=0;
        for(int i: time){
            int n=i%60;
            retVal+= array[n==0 ?0:60-n];
            array[n]++;
        }
        return retVal;
    }
}