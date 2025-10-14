class Solution {
    public void rotate(int[] nums, int k) {
    int n = nums.length;
    k = k%n;

    reverse(nums, 0, n-1); // reverse whole array
    reverse(nums, 0, k-1); // reverse first K elements
    reverse(nums, k, n-1); // reverse last n-k elements

    }

    public void reverse(int[] nums, int left, int right){
        while(left < right){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
}