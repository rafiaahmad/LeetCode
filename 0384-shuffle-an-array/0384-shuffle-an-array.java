class Solution {

    private int[] original;
    private Random rand;

    public Solution(int[] nums) {
        original = nums.clone();
        rand = new Random();
    }

    public int[] reset() {
        return original.clone();
    }

    public int[] shuffle() {

        int[] shuffled = original.clone();

        for (int i = 0; i < shuffled.length; i++) {

            int j = i + rand.nextInt(shuffled.length - i);

            // swap
            int temp = shuffled[i];
            shuffled[i] = shuffled[j];
            shuffled[j] = temp;
        }

        return shuffled;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna