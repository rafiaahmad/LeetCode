class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int len = Integer.MAX_VALUE;

        // Step 1 : Build prefix sum array
        long[] prefix = new long[n+1];
        // prefix[0] = 0;
        for(int i = 0; i<n; i++)
            prefix[i+1] = prefix[i] + nums[i];

        // Step 2 : Process the array
        for(int i = 0; i<=n; i++){
            // Step 2.1 : Check valid subArray
            while(!dq.isEmpty() && prefix[i] - prefix[dq.peekFirst()] >= k)
                len = Math.min(len, i - dq.pollFirst());

            // Step 2.2 : Maintain monotonic increasing order
            while(!dq.isEmpty() && prefix[dq.peekLast()] >= prefix[i])
                dq.pollLast();

            // Step 2.3 : Push current index
            dq.offerLast(i);
        }

        // Step 3 : Return Shortest subArray length
        return len == Integer.MAX_VALUE ? -1 : len;
    }
}