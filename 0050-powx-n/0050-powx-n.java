class Solution {

    public double myPow(double x, int n) {
        return power(x, n);
    }
    
    private double power(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        
        double res = power(x, n / 2);
        res *= res;
        if (n % 2 != 0) {
            return (n > 0) ? res * x : res / x;
        } else {
            return res;
        }
    }
}