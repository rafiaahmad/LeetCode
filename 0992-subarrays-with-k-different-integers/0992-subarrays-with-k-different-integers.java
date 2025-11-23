class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[n + 1];
        int left = 0, count = 0;

        for (int right = 0; right < n; right++) {
            // Add nums[right]
            if (freq[nums[right]] == 0) 
                k--;  
            freq[nums[right]]++;

            // Shrink until <= k distinct
            while (k < 0) {
                freq[nums[left]]--;
                if (freq[nums[left]] == 0)
                    k++;
                left++;
            }

            // Add number of subarrays ending at right
            count += right - left + 1;
        }

        return count;
    }
}
