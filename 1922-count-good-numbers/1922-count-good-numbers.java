class Solution {
    long mod = 1000000007;

    public int countGoodNumbers(long n) {
       long even = (n + 1) / 2; // no. of even digits
       long odd = n / 2; // no. of odd digits
       return (int) (power(5, even) * power(4, odd)% mod);
    }

    private long power(long x, long n){
        if(n==0) return 1;
        long half = power(x, n/2) % mod;
        long res = (half*half) % mod;

        return (n%2 == 0)? res : (res*x) % mod;
    }
}