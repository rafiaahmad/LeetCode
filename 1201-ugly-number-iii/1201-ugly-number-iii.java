class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long lcmAB = lcm(a, b);
        long lcmBC = lcm(b, c);
        long lcmAC = lcm(a, c);
        long lcmABC = lcm(lcmAB, c);

        long low = 1, high = 2000000000L; // 2*10^9
        long ans = -1;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long count = mid / a + mid / b + mid / c
                        - mid / lcmAB - mid / lcmBC - mid / lcmAC
                        + mid / lcmABC;

            if (count >= n) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) ans;
    }

    private long gcd(long x, long y) {
        while (y != 0) {
            long tmp = x % y;
            x = y;
            y = tmp;
        }
        return x;
    }

    private long lcm(long x, long y) {
        return x / gcd(x, y) * y;
    }
}