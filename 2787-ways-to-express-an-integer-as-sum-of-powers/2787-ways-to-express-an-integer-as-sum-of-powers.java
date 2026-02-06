class Solution {
    public int numberOfWays(int n, int x) {
        int MOD = 1_000_000_007;

        // Collect all powers <= n
        List<Integer> powers = new ArrayList<>();
        for (int i = 1; Math.pow(i, x) <= n; i++) {
            powers.add((int) Math.pow(i, x));
        }

        // dp[s] = number of ways to make sum s
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int p : powers) {
            for (int s = n; s >= p; s--) {
                dp[s] = (dp[s] + dp[s - p]) % MOD;
            }
        }

        return dp[n];
    }
}