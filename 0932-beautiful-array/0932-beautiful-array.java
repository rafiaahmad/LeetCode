class Solution {
    public int[] beautifulArray(int n) {
        // Time Complexity: O(n), Space Complexity: O(n)
        List<Integer> result = new ArrayList<>();
        result.add(1);

        while (result.size() < n) {
            List<Integer> temp = new ArrayList<>();

            // build odds
            for (int x : result) {
                if (2 * x - 1 <= n) {
                    temp.add(2 * x - 1);
                }
            }

            // build evens
            for (int x : result) {
                if (2 * x <= n) {
                    temp.add(2 * x);
                }
            }

            result = temp;
        }

        // convert to array
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna