class Solution {

    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;

        int[][] dp = new int[n][n];

        // first row
        for (int c = 0; c < n; c++) {
            dp[0][c] = matrix[0][c];
        }

        for (int r = 1; r < n; r++) {

            for (int c = 0; c < n; c++) {

                int minAbove = dp[r - 1][c];

                if (c > 0) {
                    minAbove = Math.min(minAbove,
                                         dp[r - 1][c - 1]);
                }

                if (c < n - 1) {
                    minAbove = Math.min(minAbove,
                                         dp[r - 1][c + 1]);
                }

                dp[r][c] = matrix[r][c] + minAbove;
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int c = 0; c < n; c++) {
            answer = Math.min(answer,
                               dp[n - 1][c]);
        }

        return answer;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna