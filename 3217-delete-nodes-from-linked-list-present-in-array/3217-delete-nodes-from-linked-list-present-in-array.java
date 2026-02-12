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
    public ListNode modifiedList(int[] nums, ListNode head) {

        // Step 1: Store nums in HashSet
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Step 2: Dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy;

        // Step 3: Traverse and remove
        while (curr.next != null) {
            if (set.contains(curr.next.val)) {
                curr.next = curr.next.next;  // delete
            } else {
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}
