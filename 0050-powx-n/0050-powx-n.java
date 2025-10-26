class Solution {
    public double myPow(double x, int n) {
        // TC: O(log N), S.c : O(1)
        long N = n; // Use long to handle Integer.MIN_VALUE 
        if (N < 0) { 
            x = 1 / x; 
            N = -N; 
        } 
        
        double ans = 1; 
        
        while (N > 0) {
            if ((N & 1) == 1) { // 1010 & 0001 = 100 // 101 & 001 == 1 // 10&01 = 0 // 1&1 =1
                 ans *= x; } // 4 // 2^2 * 2^8 = 2^10 = 1024
            x *= x; // 16 // 256 // 2^20
            N >>= 1; // 5 - 2 - 0
        } 
        return ans; //1024
    }
}