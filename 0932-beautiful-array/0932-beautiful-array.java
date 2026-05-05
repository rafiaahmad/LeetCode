class Solution {
    public int[] beautifulArray(int n) {
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