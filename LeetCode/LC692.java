class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        ArrayList<String> ans = new ArrayList<String>();
        int currSum;
        
        for (int i = 0; i < words.length; i++){
            if (map.containsKey(words[i])){
                currSum = map.get(words[i]);
                map.put(words[i], currSum + 1);
            }
            else {
                map.put(words[i], 1);
            }  
        }
        
        PriorityQueue<String> pq = new PriorityQueue<String>(
            (str1, str2) -> map.get(str1) != map.get(str2) ?
            map.get(str1) - map.get(str2) : str2.compareTo(str1));
       
        for (String s : map.keySet()){
            pq.offer(s);
            if (pq.size() > k){
                pq.poll();
            }
        }
        
        for (int i = 0; i < k; i++){
            ans.add(pq.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}
