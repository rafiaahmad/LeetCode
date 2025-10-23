class Solution {
    public String longestPalindrome(String s) {
        //Approach 2 : Dynamic Programming
        int n = s.length();
        if(n == 0) return "";
        // if(n==1) return s;

        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLength = 1;

        //Length 1 Palindromes
        for(int i = 0; i<n; i++)
            dp[i][i] = true;

        // Length 2 Palindromes
        for(int i = 0; i<n-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                start = i;
                maxLength = 2;
            }
        }

        //Length >= 3 palindromes
        for(int len = 3; len<=n; len++){ // Substring length
            for(int i = 0; i+len-1<n; i++){ // Left index
                int j = i + len - 1; // Right Index

                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    if(len > maxLength){
                        maxLength = len;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start+maxLength);
    }
}