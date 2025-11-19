class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        // Step 0 : If k == n, return total sum directly
        if (k == n) {
            int sum = 0;
            for (int x : cardPoints) sum += x;
            return sum;
        }

        // Step 1 : Find the window size need to be REMOVED
        int windowSize = n-k;

        // Step 2 : Build Prefix Sum TC: O(N), SC: O(N)
        int[] prefixSum = new int[n];
        prefixSum[0] = cardPoints[0];

        for(int i = 1; i<n; i++)
            prefixSum[i] = prefixSum[i-1] + cardPoints[i];

        // Step 3 : Find the minSum of Window size (n-k)
        int totalSum = prefixSum[n-1];
        //Initial Window Sum
        int minSum = prefixSum[windowSize-1];

        // Compute another Window Sum and compare to find minSum
        for(int i = 1; i + windowSize - 1 < n; i++){
            int end = i + windowSize - 1;
            int windowSum = prefixSum[end] - prefixSum[i-1];
            minSum = Math.min(minSum, windowSum);
        }

        // Step 4 : return maxSum
        return totalSum - minSum; // = maxSum
    }
}