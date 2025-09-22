class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length-1;

        while(start < end){
            int mid = start + (end-start)/2;

            // If left half is sorted, min must be in right half
            if(nums[mid] > nums[end])
                start = mid + 1;
            else if(nums[mid] < nums[end])
            // Otherwise, min is in left half
                end = mid;
            else{
                end--;
            }
        }
        return nums[start];
    }
}