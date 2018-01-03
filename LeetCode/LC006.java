class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int idx = 0; idx < numRows; idx++){
            sb[idx] = new StringBuffer();
        }
        int i = 0;
        while(i < n){
            for (int idx = 0; idx < numRows && i < n; idx++){
                sb[idx].append(s.charAt(i++));
            }
            for (int idx = numRows-2; idx > 0 && i < n; idx--){
                sb[idx].append(s.charAt(i++));
            }
        }
        for (i = 1; i < numRows; i++){
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}
