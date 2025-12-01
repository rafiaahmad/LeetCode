class MyQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    /** Constructor: initialize two stacks */
    public MyQueue() {
        inStack  = new Stack<>();
        outStack = new Stack<>();
    }
    
    /** Push element x to the back of queue */
    public void push(int x) {
        inStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element */
    public int pop() {
        shiftStack();
        return outStack.pop();
    }
    
    /** Get the front element */
    public int peek() {
        shiftStack();
        return outStack.peek();
    }

    /** Returns whether the queue is empty */ 
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    /** Helper method: transfer elements if output is empty */
    public void shiftStack(){
        if(outStack.isEmpty()){
            while(!inStack.isEmpty())
                outStack.push(inStack.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */