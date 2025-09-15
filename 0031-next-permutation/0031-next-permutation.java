class Solution {
    public void nextPermutation(int[] nums) {
         int n = nums.length;
        
        // Step 1: Find the first "dip" (pivot) from the right
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: If pivot exists, find element just larger than nums[i]
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            // Swap pivot with that element
            swap(nums, i, j);
        }

        // Step 3: Reverse the suffix (right side after pivot)
        reverse(nums, i + 1, n - 1);
    }

    // Helper: swap two elements
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Helper: reverse array from left to right
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}