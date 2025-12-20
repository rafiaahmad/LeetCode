class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        // Step 1 : Initialization
        int left = k, right = k;
        int currentMin = nums[k];
        int maxScore = nums[k];

        // Step 2 : Expansion and calculate score
        while(left >0 || right < n-1){
            // greedy expansion left / right
            int newIdx = 0;
            if(left == 0 && right < n-1) // MUST expand RIGHT
                newIdx = ++right;
            else if (right == n-1 && left > 0) // MUST expant LEFT
                newIdx = --left;
            else
                newIdx = (nums[left-1] > nums[right+1]) ? --left : ++right;

            // score calculation
            currentMin = Math.min(currentMin, nums[newIdx]);
            int score = currentMin * (right - left + 1);
            maxScore = Math.max(maxScore, score);
        }

        return maxScore;
    }
}