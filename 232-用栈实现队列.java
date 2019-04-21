class MyQueue {
    private Stack<Integer> stack, reverse;
    /** Initialize your data structure here. */
    public MyQueue() {
        this.stack=new Stack<>();
        this.reverse = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!stack.empty())
            reverse.push(stack.pop());
        int top = reverse.pop();
        while(!reverse.empty())
            stack.push(reverse.pop());
        return top;
    }
    
    /** Get the front element. */
    public int peek() {
        while(!stack.empty())
            reverse.push(stack.pop());
        int top = reverse.peek();
        while(!reverse.empty())
            stack.push(reverse.pop());
        return top;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.empty();
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