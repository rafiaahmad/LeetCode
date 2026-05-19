class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        int[] result = new int[n];

        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {

            int index = i % n;

            while (!stack.isEmpty()
                    && nums[index] > nums[stack.peek()]) {

                result[stack.pop()] = nums[index];
            }

            // only push during first pass
            if (i < n) {
                stack.push(index);
            }
        }

        return result;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna