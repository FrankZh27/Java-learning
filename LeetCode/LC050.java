class Solution {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        
        if (n == Integer.MIN_VALUE) {
            n++;
            return myPow(1.0/x, -n) / x;
        }
        
        if (n <  0) {
            return 1.0/(myPow(x, -n));
        }
        
        double temp = myPow(x, n/2);
        if (n % 2 == 0) {
            return temp * temp;
        }
        else {
            return temp * temp * x;
        }
    }
}
