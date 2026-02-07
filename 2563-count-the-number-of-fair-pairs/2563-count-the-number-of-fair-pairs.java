class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        return countLessOrEqual(nums, upper)
             - countLessOrEqual(nums, lower - 1);
    }

    private long countLessOrEqual(int[] nums, int X) {
        int left = 0, right = nums.length - 1;
        long count = 0;

        while (left < right) {
            if (nums[left] + nums[right] <= X) {
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}