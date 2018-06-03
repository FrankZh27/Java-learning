class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if (dividend > 0 && divisor < 0 
            || dividend < 0 && divisor > 0) {
            sign = -1;
        }
        long longDividend = (long)Math.abs(dividend);
        long longDivisor = (long)Math.abs(divisor);
        int sum = 0;
        int multi = 0;
        int shifts = 1;
        while (sum + longDivisor <= longDividend) {
            while (sum + longDivisor<<shifts <= longDividend) {
                shifts++;
            }
            multi += 1<<(shifts-1);
            sum += longDivisor<<(shifts-1);
            shifts = 1;
        }
        if (sign == -1) {
            multi = -multi;
        }
        if (multi > Integer.MAX_VALUE || multi < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return multi;
    }
}
