class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Clean invalid numbers
        for(int i = 0; i<n; i++){
            if(nums[i] <= 0 || nums[i] == n)
                nums[i] = n + 1;
        }
 
        // Step 2: Mark presence using index
        for(int x : nums){
            if(x >= 1 && x<=n)
                nums[x-1] = -nums[x-1];
        }

        // Step 3: Find first positive index
        for(int i = 0; i<n; i++){
            if(nums[i] > 0)
                return i+1;
        }

        return 1;
    }
}