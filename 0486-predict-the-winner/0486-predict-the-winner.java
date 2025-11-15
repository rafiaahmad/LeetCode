class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][n];

        return solve(nums, 0, n-1, dp) >= 0;
    }

    private int solve(int[] nums, int i, int j, Integer[][] dp){
        //Base Case: When only one number left in the array
        if(i==j) return nums[i];

        //Check if score already calculated when i and j picked
        if(dp[i][j] != null) return dp[i][j];

        //Predict sum of left and right to calculate score
        int leftGain =  nums[i] - solve(nums, i+1, j, dp);
        int rightGain = nums[j] - solve(nums, i, j-1, dp);

        dp[i][j] = Math.max(leftGain, rightGain);

        return dp[i][j];
    }
}