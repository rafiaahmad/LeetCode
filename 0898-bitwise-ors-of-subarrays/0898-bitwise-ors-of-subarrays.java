class Solution {

    public int subarrayBitwiseORs(int[] arr) {

        Set<Integer> result = new HashSet<>();

        Set<Integer> prev = new HashSet<>();

        for (int num : arr) {

            Set<Integer> curr = new HashSet<>();

            // subarray with only current number
            curr.add(num);

            // extend previous subarrays
            for (int val : prev) {
                curr.add(val | num);
            }

            result.addAll(curr);

            prev = curr;
        }

        return result.size();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna