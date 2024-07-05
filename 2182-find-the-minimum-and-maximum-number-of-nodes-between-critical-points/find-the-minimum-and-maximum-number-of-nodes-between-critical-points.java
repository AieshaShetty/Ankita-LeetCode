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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> criticalPoints = new ArrayList<>();
        int i = 2;
        int prev = head.val;
        head = head.next;

        while (head.next != null) {
            if ((head.val > prev && head.val > head.next.val) || 
                (head.val < prev && head.val < head.next.val)) {
                criticalPoints.add(i);
            }
            i++;
            prev = head.val;
            head = head.next;
        }

        if (criticalPoints.size() <= 1) {
            return new int[]{-1, -1};
        }

        int maxi = criticalPoints.get(criticalPoints.size() - 1) - criticalPoints.get(0);
        int mini = Integer.MAX_VALUE;
        for (int j = 1; j < criticalPoints.size(); j++) {
            mini = Math.min(mini, criticalPoints.get(j) - criticalPoints.get(j - 1));
        }

        return new int[]{mini, maxi};
    }
}
