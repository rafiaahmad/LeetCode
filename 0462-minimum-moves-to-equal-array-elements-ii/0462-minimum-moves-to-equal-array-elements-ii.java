class Solution {
    // T.C: O(n log n), S.C: O(1)
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;

        int moves = 0;

        while (left < right) {

            moves += nums[right] - nums[left];

            left++;
            right--;
        }

        return moves;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna