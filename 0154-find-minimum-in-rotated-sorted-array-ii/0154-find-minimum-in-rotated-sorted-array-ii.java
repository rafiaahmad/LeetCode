class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int start = 0, end = n-1;
        if( n == 1) return nums[0];
        while(start < end){
            int mid = start + (end-start)/2;
            if(nums[mid] > nums[end]){
                start = mid+1;
            } else if (nums[mid] < nums[end]){
                end = mid;
            } else{
                end--;
            }
        }
        return nums[start];
    }
}