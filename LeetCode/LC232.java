class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> in;
    Stack<Integer> out;
    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
        return;
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
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
