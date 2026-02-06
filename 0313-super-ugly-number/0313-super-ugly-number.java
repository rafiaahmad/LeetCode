class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;

        int[] ugly = new int[n];
        ugly[0] = 1;

        int[] idx = new int[k]; // pointers

        for (int i = 1; i < n; i++) {
            long min = Long.MAX_VALUE;

            // find next ugly number
            for (int j = 0; j < k; j++) {
                min = Math.min(min, (long) primes[j] * ugly[idx[j]]);
            }

            ugly[i] = (int) min;

            // move all pointers that produced min
            for (int j = 0; j < k; j++) {
                if ((long) primes[j] * ugly[idx[j]] == min) {
                    idx[j]++;
                }
            }
        }
        return ugly[n - 1];
    }
}