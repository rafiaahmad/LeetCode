class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long ab = lcmNum(a,b);
        long bc = lcmNum(b,c);
        long ac = lcmNum(a,c);
        long abc = lcmNum(a, bc);

        long low = Math.min(a, Math.min(b,c)); // lowest possible ugly no.
        // int high = 2*10^9; //maximum possible ugly no.
        long high = 2_000_000_000; //maximum possible ugly no.

        while(low<high){
            long mid = low + (high-low)/2;

            if(countUgly(mid, a, b, c, ab, bc, ac, abc, n))
                high = mid;
            else
                low = mid+1;
        }
        return (int) low;
    }

    public boolean countUgly(long target, long a, long b, long c, long ab, 
                             long bc, long ac, long abc, long n){

        long count = (target/a) + (target/b) + (target/c) - (target/ab)
                - (target/bc) - (target/ac)
                + (target/abc);
        
        return (count>=n);
    }

    public long lcmNum(long a, long b){
        return ((a*b)/gcdNum(a,b)); // LCM(a.b) * GCD(a,b) = a*b
    }

    public long gcdNum(long a, long b){
        if(b == 0) return a; //base case b:0, a is GCD
        return gcdNum(b, a%b);//recursive call
    }
}