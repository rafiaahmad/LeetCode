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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Step 1: Count total nodes
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }

        // Step 2: If deleting head
        if (n == count)
            return head.next;

        // Step 3: Move to (length - n - 1)th node
        temp = head;
        for(int i = 0; i < count - n - 1; i++)            
            temp = temp.next;

        // Step 4: Delete node
        temp.next = temp.next.next;

        return head;
    }
}