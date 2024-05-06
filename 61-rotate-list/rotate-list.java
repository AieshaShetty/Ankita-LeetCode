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
/*
Given that a list like 1->2->3->4->5

Find length of the list

Now, the resulting list after rotation should be 4->5-> 1->2->3. Here, notice that 4->5 will be same , we just need to update 3 nodes which are as follows,

5 will be pointing to starting node which is 1.
4 will be the new starting node.
3 will be the end node so set null as its next.

Subtract k from length to get the node 3.( Use k as k%length for the case length<k )

Reach to the kth node and update pointers as mentioned in the 2nd point.
 */

class Solution {
    public ListNode rotateRight(ListNode head, int k) 
    {
        if(head == null || head.next == null || k ==0)
            return head;
        
        ListNode temp = head;
        int length =1;
        
        while(temp.next != null)
        {
            length++;
            temp = temp.next;
        }
        
        temp.next = head;
        
        if(k >= length)
            k = k % length;
        
        int pos = length - k;
        
        while(pos-- > 0)
           temp = temp.next;
        
        head = temp.next;
        temp.next = null;
        
        return head;
        
        
    }
}