class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;

        // Prefix sums (long to avoid overflow)
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++)
            prefix[i + 1] = prefix[i] + nums[i];

        // Manual deque using array
        int[] dq = new int[n + 1];
        int head = 0, tail = 0;

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {

            // Step 1: Check valid subarrays
            while (head < tail && prefix[i] - prefix[dq[head]] >= k) {
                ans = Math.min(ans, i - dq[head]);
                head++;
            }

            // Step 2: Maintain monotonic increasing order
            while (head < tail && prefix[dq[tail - 1]] >= prefix[i]) {
                tail--;
            }

            // Step 3: Push current index
            dq[tail++] = i;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
