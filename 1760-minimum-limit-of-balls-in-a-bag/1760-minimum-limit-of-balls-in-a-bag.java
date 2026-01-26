class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = 0;

        // find largest bag
        for (int x : nums) {
            right = Math.max(right, x);
        }

        while (left < right) {
            int mid = (left + right) / 2;

            // calculate how many splits are needed
            int ops = 0;
            for (int x : nums) {
                ops += (x - 1) / mid;
            }

            // if within allowed splits, we can try smaller penalty
            if (ops <= maxOperations) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
