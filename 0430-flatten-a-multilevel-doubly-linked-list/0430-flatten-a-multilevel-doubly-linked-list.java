/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {

    public Node flatten(Node head) {
        if (head == null) return head;
        dfs(head);
        return head;
    }

    // Returns the tail of the flattened list
    private Node dfs(Node node) {
        Node curr = node;
        Node last = null;

        while (curr != null) {
            Node next = curr.next;

            // If child exists, flatten it
            if (curr.child != null) {
                Node childHead = curr.child;
                Node childTail = dfs(childHead);

                // Connect curr to child
                curr.next = childHead;
                childHead.prev = curr;
                curr.child = null;

                // Connect child tail to next
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                last = childTail;
            } else {
                last = curr;
            }

            curr = next;
        }

        return last;
    }
}