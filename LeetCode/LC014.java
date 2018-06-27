class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        String ans = "";
        int sz = strs.length;
        if (sz == 0){
            return ans;
        }
        if (sz == 1){
            return strs[0];
        }
        if (strs[0].length() == 0){
            return ans;
        }
        
        int i = 0;
        outer: for (i = 0; i < strs[0].length(); i++){
            for (int j = 1; j < sz; j++){
                if (strs[j].length() < i+1){
                    break outer;
                }
                if (strs[0].charAt(i) != strs[j].charAt(i)){
                    break outer;
                }
            }
        }
        return strs[0].substring(0,i);
        
    }
}
