class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] points = new int[max + 1];

        // collect total points
        for (int num : nums) {
            points[num] += num;
        }

        int take = 0;
        int skip = 0;

        for (int i = 0; i <= max; i++) {

            int takeNew = skip + points[i];

            skip = Math.max(skip, take);

            take = takeNew;
        }

        return Math.max(take, skip);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna