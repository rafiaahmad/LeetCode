// User function Template for Java

class Solution {
    // Top-Down Recursion + Memoization
    static int count(int N) {
        int pairs = N/2;
        Integer[] dp = new Integer[pairs+1];
        
        return solve(pairs, dp);
    }
    
    static int solve(int n, Integer[] dp){
        if(n<=1)  return 1;
        
        if(dp[n] != null) return dp[n];
        
        int ways = 0;
        
        for(int i = 0; i<n; i++)
            ways += solve(i, dp)*solve(n-i-1, dp);
            
        dp[n] = ways;
        return ways;
    }
    
}