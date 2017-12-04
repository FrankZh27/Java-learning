class 503 {
    public int[] nextGreaterElements(int[] nums) {
        
        int[] results = new int[nums.length];
        
        for (int curr = 0; curr < nums.length; curr++){
            int nextG = -1;
            int ptrR = curr + 1;
            int ptrL = curr - 1;
            
            while (ptrR < nums.length){
                if (nums[ptrR] > nums[curr]){
                    nextG = nums[ptrR];
                    break;
                }
                ptrR++;
            }
            
            
            while (nextG == -1 && ptrL >= 0 && ptrL < curr){
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