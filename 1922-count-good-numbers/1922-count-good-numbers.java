class Solution {
    long mod = 1000000007;

    public int countGoodNumbers(long n) {
       long even = (n + 1) / 2; // no. of even digits
       long odd = n / 2; // no. of odd digits
       return (int) (power(5, even) * power(4, odd)% mod);
    }

    private long power(long x, long n){
        long res = 1;
        long mul = x;
        while(n>0){
            if(n%2 == 1)
                res = (res*mul) % mod;
            mul = (mul*mul) % mod;
            n /= 2;
        }
        
        return res;
    }
}