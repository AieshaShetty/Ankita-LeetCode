class Node{
    int r;
    int c;
    double fraction;
    Node(int r,int c,double ele){
        this.r=r;
        this.c=c;
        this.fraction=ele;
    }
}
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Node> q=new PriorityQueue<>((a, b) -> Double.compare(a.fraction, b.fraction));
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                double frac=(double)arr[i]/arr[j];
                q.add(new Node(arr[i],arr[j],frac));
            }
        }
        Node curr=null;
        while(k>0){
            curr=q.poll();
            k-=1;
        }
        int []ans=new int[2];
        ans[0]=curr.r;
        ans[1]=curr.c;
        
        return ans;
    }
}