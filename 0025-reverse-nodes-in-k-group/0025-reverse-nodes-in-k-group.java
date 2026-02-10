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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Step 1: Check if we have k nodes
        ListNode curr = head;
        int count = 0;

        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // If less than k nodes, do not reverse
        if (count < k) return head;

        // Step 2: Reverse first k nodes
        ListNode prev = null;
        ListNode currNode = head;
        ListNode next = null;

        count = 0;
        while (count < k) {
            next = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = next;
            count++;
        }

        // Step 3: Recursively reverse remaining list
        head.next = reverseKGroup(currNode, k);

        // Step 4: Return new head
        return prev;
    }
}