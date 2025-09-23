class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length-1;
        while(start < end){
                int mid = start + (end-start)/2;
                if(mid %2 != 0) mid--;

                if(nums[mid] != nums[mid+1]) //[even, odd] pair not equal
                //unique ele. already appeared b/w start -- mid, search in left
                    end = mid; 
                else // [even, odd] pair equal 
                // unique ele. not appeared till mid, search in right mid+2--end
                    start = mid + 2;  // mid+2 because we decrement mid
            }
        return nums[start];
    }
}