class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n =hand.length;
        if(n%groupSize!=0){
            return false;
        }

        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i:hand){
            pq.add(i);
        }
        while(pq.size()>0){
            int poll = pq.poll();
            for(int i=1;i<groupSize;i++){
                if(!pq.remove(poll+i)){
                    return false;
                }
            }
        }
        return true;
    }
}