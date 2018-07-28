class Solution {
    public int numSquares(int n) {
        int[] table = new int[n+1];
        table[1] = 1;
        for (int i = 2; i <= n; i++) {
            int j = 1;
            int minSteps = i;
            while (j*j <= i) {
                if (table[i-j*j]+1 < minSteps) {
                    minSteps = table[i-j*j] + 1;
                }
                ++j;
            }
            table[i] = minSteps;
        }
        return table[n];
    }
}
