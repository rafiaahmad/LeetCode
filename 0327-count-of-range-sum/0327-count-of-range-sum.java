class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        return mergeSort(prefix, 0, n, lower, upper);
    }

    private int mergeSort(long[] prefix, int left, int right,
                          int lower, int upper) {
        if (left >= right) return 0;

        int mid = (left + right) / 2;
        int count = 0;

        count += mergeSort(prefix, left, mid, lower, upper);
        count += mergeSort(prefix, mid + 1, right, lower, upper);

        // Count cross pairs
        int l = mid + 1, r = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (l <= right && prefix[l] - prefix[i] < lower) l++;
            while (r <= right && prefix[r] - prefix[i] <= upper) r++;
            count += (r - l);
        }

        // Merge step
        Arrays.sort(prefix, left, right + 1);
        return count;
    }
}