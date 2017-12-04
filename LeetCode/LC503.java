class LC503 {
    public int[] nextGreaterElements(int[] nums) {
        
        int[] results = new int[nums.length];
        
        for (int curr = 0; curr < nums.length; curr++){
            int nextG = -1;
            int ptrR = curr + 1;
            int ptrL = 0;
            boolean isEnd = false;
                
            while (ptrR < nums.length){
                if (nums[ptrR] > nums[curr]){
                    nextG = nums[ptrR];
                    isEnd = true;
                    break;
                }
                ptrR++;
            }
            
            
            while ((!isEnd) && nextG == -1 && ptrL < curr){
                if (nums[ptrL] > nums[curr]){
                    nextG = nums[ptrL];
                    break;
                }
                ptrL++;
            }
            results[curr] = nextG;
        }
        
        return results;
    }
}