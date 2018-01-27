class Solution {
    public String countAndSay(int n) {

        if (n == 1){
            return "1";
        }
        
        if (n == 2){
            return "11";
        }
        
        String str = "11";
        
        for (int ite = 2; ite < n; ite++){
            int sz = str.length();
            StringBuilder sb = new StringBuilder();

            int i = 0;
            int count = 1;

            while(i < sz-1){

                while(i < sz-1 && str.charAt(i) == str.charAt(i+1)){
                    i++;
                    count++;
                }
                sb.append(Integer.toString(count));
                sb.append(Character.toString(str.charAt(i)));
                count = 1;
                i++;

                if (i == sz-1) {
                    sb.append("1");
                    sb.append(Character.toString(str.charAt(i)));
                }  
            }
            str = sb.toString();
        }
        return str;
    }
}
