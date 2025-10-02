class Solution {
    public double myPow(double x, int n) {
        long N = n; // Use long to handle Integer.MIN_VALUE 
        if (N < 0) { 
            x = 1 / x; 
            N = -N; 
        } 
        
        double ans = 1; 
        
        while (N > 0) {
            if ((N & 1) == 1) {
                 ans *= x; } 
            x *= x; 
            N >>= 1; 
        } 
        return ans;
    }
}