// User function Template for Java

class Solution {
    // Iterative DP (Bottom-Up Catalan Table)
    static int count(int N) {
        int pairs = N/2;
        int[] dp = new int[pairs+1];
        
        dp[0] = dp[1] = 1;
        
        for(int i = 2; i<=pairs; i++){
            for(int left = 0; left<i; left++)
                dp[i] += dp[left] * dp[i-left-1];
        }
        
        return dp[pairs];
    }
}