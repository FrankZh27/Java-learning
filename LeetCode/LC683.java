/*
class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        int sz = flowers.length;
        int[] bloom = new int[sz];
        // bloom[i] = x ith flower bloom in day x
        for (int i = 0; i < sz; i++) {
            bloom[flowers[i]-1] = i + 1;
        }
        
        int result = Integer.MAX_VALUE;
        int left = 0;
        int right = left + k + 1;
        
        outer: while(right < sz) {
            for (int i = left + 1; i < right; i++) {
                if (bloom[i] < bloom[left] || bloom[i] < bloom[right]) {
                    left = i;
                    right = left + k + 1;
                    continue outer;
                }
            }
            int currResult = Math.max(bloom[left], bloom[right]);
            result = Math.min(result, currResult);
            left = right;
            right = left + k + 1;
        }
        
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        else {
            return result;
        }
    }
}
*/

class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        int sz = flowers.length;
        if (k == sz) {
            return sz;
        }
        TreeSet<Integer> set = new TreeSet<Integer>();
        int position = flowers[sz-1];
/*        if (position == k + 1 || position == sz - k) {
            return position;
        }
        set.add(position);
*/       
        int high = 0;
        int low = 0;
        for (int i = sz-1; i >= 0; i--) {
            position  = flowers[i];
            set.add(position);
            if (set.higher(position) == null) {
                if (position == sz - k) {
                    return i;
                }
            }
            else {
                high = set.higher(position);
                if (high - position - 1 == k) {
                    return i;
                }
            }
            if (set.lower(position) == null) {
                if (position == k + 1) {
                    return i;
                }
            }
            else {
                low = set.lower(position);
                if (position - low - 1 == k) {
                    return i;
                }
            }
        }
        
        return -1;
    }
}
