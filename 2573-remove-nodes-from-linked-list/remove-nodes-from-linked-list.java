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
        Map<ListNode, Integer> maxMap = new HashMap<ListNode, Integer>();
        setRightMax(head, maxMap);
        ListNode dummyHead = new ListNode(0, head);
        ListNode curr = dummyHead;
        while (curr.next != null) {
            if (maxMap.get(curr.next) > curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummyHead.next;
    }

    private void setRightMax(ListNode node, Map<ListNode, Integer> maxMap) {
        if (!maxMap.containsKey(node)) {
            if (node.next != null) {
                setRightMax(node.next, maxMap);
                int maxRight = Math.max(node.next.val, maxMap.get(node.next));
                maxMap.put(node, maxRight);
            } else {
                maxMap.put(node, -1);
            }
        }
    }
}