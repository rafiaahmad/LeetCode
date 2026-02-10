/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

    // Pass 1: insert copies
    Node curr = head;
    while (curr != null) {
        Node copy = new Node(curr.val);
        copy.next = curr.next;
        curr.next = copy;
        curr = copy.next;
    }

    // Pass 2: random pointers
    curr = head;
    while (curr != null) {
        if (curr.random != null)
            curr.next.random = curr.random.next;
        curr = curr.next.next;
    }

    // Pass 3: separate lists
    Node dummy = new Node(0);
    Node copyTail = dummy;
    curr = head;

    while (curr != null) {
        copyTail.next = curr.next;
        copyTail = copyTail.next;

        curr.next = curr.next.next;
        curr = curr.next;
    }

    return dummy.next;
    }
}