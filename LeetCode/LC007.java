class Solution {
    public int reverse(int x) {        
        int ans = 0;
        int newresult = 0;
        
        while(x <= -10 || x >= 10 ){
            newresult = (ans + x % 10) * 10;
            if (newresult / 10 - x % 10 != ans){
                return 0;
            }
            ans = newresult;
            x = x/10;
        }
        ans = ans + x;
        return ans;
    }
}
