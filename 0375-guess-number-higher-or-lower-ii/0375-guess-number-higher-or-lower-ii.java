class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];

        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int x = i; x <= j; x++) {
                    int cost = x + Math.max(
                        x - 1 >= i ? dp[i][x - 1] : 0,
                        x + 1 <= j ? dp[x + 1][j] : 0
                    );

                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[1][n];
    }
}