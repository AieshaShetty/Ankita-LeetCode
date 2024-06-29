/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> minHeap=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode node:lists){
            if(node==null) continue;
            minHeap.add(node);
        }
        ListNode dummy=new ListNode();
        ListNode curr=dummy;
        while(!minHeap.isEmpty()){
            ListNode top=minHeap.poll();
            curr.next=top;
            curr=curr.next;
            if(top.next!=null) minHeap.add(top.next);
        }
        return dummy.next;
    }
}