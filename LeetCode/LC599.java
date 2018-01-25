class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        ArrayList<String> ans = new ArrayList<String>();
        int sum = list1.length + list2.length - 2;
        int currSum;
        
        for (int i = 0; i < list1.length; i++){
            map.put(list1[i], i);
        }
        
        for (int i = 0; i < list2.length; i++){
            if (map.containsKey(list2[i])){
                currSum = map.get(list2[i]) + i;
                if (currSum < sum){
                    sum = currSum;
                    ans.clear();
                    ans.add(list2[i]);
                }
                else if (currSum == sum){
                    ans.add(list2[i]);
                }
            }
        }
        return ans.toArray(new String[0]);
    }
}
