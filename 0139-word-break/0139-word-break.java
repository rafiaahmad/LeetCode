class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length()];

        return solve(0, s, set, dp);
    }

    private boolean solve(int index, String s, Set<String> dict, Boolean[] dp){
        //Base Case
        if(index == s.length()) return true;

        if(dp[index] != null) return dp[index];

        for(int end = index; end <= s.length(); end++){
            String prefix = s.substring(index, end);

            //Check if the prefix is in Dictionary Set
            if(dict.contains(prefix)){
                if(solve(end, s, dict, dp)){
                    dp[index] = true;
                    return true;
                }
            }
        }

        dp[index] = false;
        return false;
    }
}