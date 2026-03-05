class Solution {
    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        int mod = 1000000007;
        
        long[][] dp = new long[n][n];
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1; // single character
        }
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                
                if (s.charAt(i) == s.charAt(j)) {
                    int low = i + 1;
                    int high = j - 1;
                    
                    while (low <= high && s.charAt(low) != s.charAt(i)) {
                        low++;
                    }
                    while (low <= high && s.charAt(high) != s.charAt(i)) {
                        high--;
                    }
                    
                    if (low > high) {
                        // no same char inside
                        dp[i][j] = dp[i+1][j-1] * 2 + 2;
                    } 
                    else if (low == high) {
                        // one same char
                        dp[i][j] = dp[i+1][j-1] * 2 + 1;
                    } 
                    else {
                        // more than one same char
                        dp[i][j] = dp[i+1][j-1] * 2 
                                 - dp[low+1][high-1];
                    }
                    
                } else {
                    dp[i][j] = dp[i+1][j] 
                             + dp[i][j-1] 
                             - dp[i+1][j-1];
                }
                
                dp[i][j] = (dp[i][j] % mod + mod) % mod;
            }
        }
        
        return (int) dp[0][n-1];
    }
}