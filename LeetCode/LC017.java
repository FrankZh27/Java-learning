class Solution {
    public List<String> letterCombinations(String digits) {
        String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> list = new LinkedList<String>();
        if (digits.length() == 0){
            return list;
        }
        
        list.add("");
        
        int len = digits.length();
        for (int i = 0; i < len; i++){
            int digit = Character.getNumericValue(digits.charAt(i));
            while(list.peek().length() == i){
                String s = list.remove();
                for (char c: map[digit].toCharArray()){
                    String t = Character.toString(c);
                    list.add(s+t);
                }
            }
            
        }
        
        return list;
    }
}
