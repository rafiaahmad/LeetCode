class MyQueue {
    private Stack<Integer> input;
    private Stack<Integer> output;

    /** Constructor: initialize your two stacks */
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    /** Push element x to the back of queue */
    public void push(int x) {
        input.push(x);
    }

    /** Removes the element from in front of queue and returns that element */
    public int pop() {
        moveInputToOutput();
        return output.pop();
    }

    /** Get the front element */
    public int peek() {
        moveInputToOutput();
        return output.peek();
    }

    /** Returns whether the queue is empty */
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    /** Helper method: transfer elements if output is empty */
    private void moveInputToOutput() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
    }
}
