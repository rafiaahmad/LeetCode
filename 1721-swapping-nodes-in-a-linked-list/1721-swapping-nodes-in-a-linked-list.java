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
    public ListNode swapNodes(ListNode head, int k) {

        ListNode first = head;
        ListNode fast = head;

        // Step 1: Move fast k-1 steps
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }

        first = fast;  // kth node from start

        ListNode second = head;

        // Step 2: Move fast to end
        while (fast.next != null) {
            fast = fast.next;
            second = second.next;
        }

        // Step 3: Swap values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }
}