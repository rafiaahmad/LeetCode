class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        int num1 = nums[0], num2 = nums[1];
        int res = num1^num2;

        for(int i = 2; i < nums.length; i++){
            res = res ^ nums[i];
        }

        return res;
    }
}