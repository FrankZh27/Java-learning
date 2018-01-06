class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        
        int len = 1;
        while(x/len >= 10){
            len = len * 10;    
        }
        System.out.println(len);
        
        while(x >= 10){
            if (x/len != x%10){
                return false;
            }
            else{
                x = (x % len) / 10;
                len = len/100;
                
                if (x == 0){
                    return true;
                }
                
                while(x % 10 == 0){
                    x = x/10;
                    len = len/100;
                }
                
                if (len == 0 || x < len || x/len >= 10){
                    return false;
                }
                
            }
        }
        return true;
        
    }
}
