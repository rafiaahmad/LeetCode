class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        long MOD = 1_000_000_007;
        long lcm = (long) (a * b) / gcd(a,b);
        long ans = 0;

        long low = 1, high = (long) n * Math.min(a,b);

        while(low < high){
            long mid = low + (high-low)/2;
            long count = mid/a + mid/b - mid/lcm;

            if(count>=n)
                high = mid;
            else
                low = mid+1;
        }
        ans = low % MOD;
        return (int) ans;
    }

     private long gcd(long x, long y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}