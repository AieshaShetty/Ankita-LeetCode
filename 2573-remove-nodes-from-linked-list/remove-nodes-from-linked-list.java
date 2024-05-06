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
        head = reverse(head);
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (curr.val >= prev.val) {
                prev.next = curr;
                prev = curr;
                curr = curr.next;
            } else {
                curr = curr.next;
            }
        }
        prev.next = null;
        head = reverse(head);
        return head;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null && head.next != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        head.next = prev;
        return head;
    }
}
