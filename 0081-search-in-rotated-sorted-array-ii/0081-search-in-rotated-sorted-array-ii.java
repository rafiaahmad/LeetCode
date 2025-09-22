class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length-1;

        while(start<=end){
            int mid = start + (end-start)/2;

            // Target found
            if(nums[mid] == target) return true;

            //handle duplicates
            if(nums[start] == nums[mid] && nums[mid] == nums[end]){
                start++; end--;
            }

            // ✅ Left half is sorted
            else if(nums[start] <= nums[mid]){
                if(nums[start] <= target && target < nums[mid]){
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            } 

            // ✅ Right half is sorted
            else{
                if(nums[mid] < target && target <= nums[end]){
                    start = mid + 1;
                } else{
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}