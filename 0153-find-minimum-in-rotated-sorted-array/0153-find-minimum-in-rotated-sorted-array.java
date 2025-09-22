class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length-1;

        while(start < end){
            int mid = start + (end - start)/2;

            if(nums[mid] < nums[end])
                end = mid; // Search in left half, right half is sorted
            else if(nums[mid] > nums[end])
                start = mid + 1; // Search in right half,  left half is sorted
            else 
                end--; //Shrink
        }

        return nums[start];
    }
}