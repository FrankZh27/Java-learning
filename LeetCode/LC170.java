class TwoSum {

    /** Initialize your data structure here. */
    List<Integer> nums;
    public TwoSum() {
        this.nums = new ArrayList<Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        nums.add(number);
        Collections.sort(nums);
        return;
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        int left = 0;
        int right = nums.size()-1;
        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            if (sum == value) {
                return true;
            }
            if (sum < value) {
                left++;
            }
            else {
                right--;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
