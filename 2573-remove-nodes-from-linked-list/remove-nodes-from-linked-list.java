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
    public ListNode removeNodes(ListNode head) {
        HashMap<ListNode,ListNode> m = new HashMap<ListNode,ListNode>();
        ListNode maxNode=getMax(head,m);
        return removeNodes(head,maxNode,m);
       
  
    }
    public ListNode removeNodes(ListNode head,ListNode maxNode,HashMap<ListNode,ListNode> m) {
        if (head.next==null){ 
            return head;
        }
        if (head == maxNode){
            maxNode=getMax(head.next,m);
            head.next=removeNodes(head.next,maxNode,m);
            return head;
        }else{
            return removeNodes(head.next,maxNode,m);
        }
     

    }
    private ListNode getMax(ListNode head, HashMap<ListNode,ListNode> cache){
        if (head.next==null){
            return head;
        }else if(cache.get(head)!=null){
            return cache.get(head);
        }
        else{
            ListNode max = getMax(head.next,cache);

            if(max.val>head.val){
                cache.put(head,max);
                return max;
            }
            else{
                                cache.put(head,head);

                
            } return head;
        }
    }
}