class MyLinkedList {
    // Node definition
    private class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node dummy; // dummy head
    private int size;   // number of real nodes

    public MyLinkedList() {
        dummy = new Node(0); // dummy node
        size = 0;
    }
    
     // Get value at index
    public int get(int index) {
        if (index < 0 || index >= size) return -1;

        Node curr = dummy.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }
    
    // Add at head
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = dummy.next;
        dummy.next = node;
        size++;
    }
    
    // Add at tail
    public void addAtTail(int val) {
        Node curr = dummy;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node(val);
        size++;
    }
    
    // Add at index
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index < 0) index = 0;

        Node prev = dummy;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node node = new Node(val);
        node.next = prev.next;
        prev.next = node;
        size++;
    }
    
    // Delete at index
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        Node prev = dummy;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = prev.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */