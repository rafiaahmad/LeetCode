class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length-1;

        while(start < end){
            int mid = start + (end - start)/2;

            // Right half is sorted, min lies in left  half
            if(nums[mid] < nums[end])
                end = mid; 
            // Left half is sorted, min must be in right half
            else if(nums[mid] > nums[end])
                start = mid + 1;
            // else 
            //     end--; //Shrink
        }

        return nums[start];
    }
}