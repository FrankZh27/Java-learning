class MovingAverage {

    /** Initialize your data structure here. */
    int sz;
    Queue<Integer> queue = new LinkedList<Integer>();
    int sum;
    int count;
    
    public MovingAverage(int size) {
        this.sz = size;
        this.sum = 0;
        this.count = 0;
    }
    
    public double next(int val) {
        if (count < sz) {
            queue.offer(val);
            sum = sum + val;
            count++;
            return sum*1.0/count;
        }
        else {
            sum = sum - queue.poll();
            sum = sum + val;
            queue.offer(val);
            
            return sum*1.0/sz;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
