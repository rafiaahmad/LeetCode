class Solution {
    public int[] buildArray(int[] nums) {
        int[] res = new int[nums.length];
        int n = nums.length;

        for(int i =0; i<n; i++){
            res[i] = nums[nums[i]];
        }
        return res;
    }
}