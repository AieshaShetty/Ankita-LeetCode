/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode right = head;
        ListNode left = head.next;

        while (left != null) {
            int gcd = 1;
            int n = Math.min(left.val, right.val);
            for (int i = 2; i <= n; i++) {
                if (right.val % i == 0 && left.val % i == 0) {
                    gcd = i;
                }
            }
            ListNode gcdNode = new ListNode(gcd);

            right.next = gcdNode;
            gcdNode.next = left;

            right = left;
            left = left.next;
        }
        return head;
    }
}