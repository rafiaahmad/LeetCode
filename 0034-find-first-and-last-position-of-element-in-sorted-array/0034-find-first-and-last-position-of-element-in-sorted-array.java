class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1, last = -1;
        int start = 0, end = nums.length-1;

        //find the first occurence -- once target found, end = target and 
        // search the  target further in left side
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                first = mid;
                end = mid-1;
            }
            else if( nums[mid] > target)
                end = mid-1;
            else
                start = mid +1;
        }
        //find the last occurence -- once target found, start = target index+1 
        // and search the target in the right side

        start = 0; end = nums.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                last = mid;
                start = mid+1;
                }
            else if( nums[mid] > target)
                end = mid-1;
            else
                start = mid +1;
        }

        return new int[] {first, last};
    }
}