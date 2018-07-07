class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int num = n;
        while (num != 1) {
            num = squaresSum(num);
            if (set.contains(num)) {
                return false;
            }
            set.add(num);
        }
        return true;
    }
    
    private int squaresSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += Math.pow(num%10, 2);
            num /= 10;
        }
        return sum;
    }
}
