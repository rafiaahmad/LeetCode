class Solution {
    public int findPeakElement(int[] nums) {      
        int start = 0, end = nums.length -1;

        while(start < end){
            int mid = start + (end-start)/2;
            if(nums[mid] > nums[mid+1]) { //search peak in left
                end = mid;
            } else{ // search pick in right
                start = mid + 1;
            }
        }
        return start;
    }
}