class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;

        while(start < end){
            int mid = start + (end - start)/2;

            if(nums[mid] == target)
                return mid;
            if(nums[mid] > nums[end])
                start = mid + 1;
            else if (nums[mid] < nums[end])
                // end = mid - 1;
                end = mid;
            else{
                if(nums[mid] == nums[start])
                    start++;
                end--;
            }
        }
        //pivot found
        int pivot = start;

        // Step 2: Binary search both halves including pivot
        // Step 2: Decide which half to search
        if(target >= nums[pivot] && target <= nums[nums.length-1]) {
            return binarySearch(nums, pivot, nums.length-1, target);
        } else {
            return binarySearch(nums, 0, pivot-1, target);
        }
    }

    public int binarySearch(int[] nums, int start, int end, int target){
        int low = start, high = end;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target)
                return mid;
            if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid -1 ;
        }

        return -1;
    }
}