class Solution {
    public String getPermutation(int n, int k) {
        if (n == 0) {
            return "";
        }
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        int remain = 1;
        for (int i = 1; i <= n; i++) {
            remain *= i;
        }
        int ans = pickHelper(nums, n, 0, remain, k, 0);
        return Integer.toString(ans);
    }
    
    private int pickHelper(List<Integer> nums, int n, int start, int remain, int k, int ans) {
        if (nums.isEmpty()) {
            return ans;
        }
        int div = remain/nums.size();
        int index = 0;
        while(start + div < k) {
            start += div;
            index++;
        }
        ans = ans*10 + nums.remove(index);
        ans = pickHelper(nums, n, start, div, k, ans);
        return ans;
    }
}
