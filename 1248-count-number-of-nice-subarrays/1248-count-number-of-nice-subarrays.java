class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        if(k > n) return 0;

        return atMost(nums, k) - atMost(nums, k-1);
    }

    private int atMost(int[] nums, int k){
        int left = 0, oddCount = 0;
        int count = 0;

        for(int right = 0; right<nums.length; right++){
            //Check whether no. is odd
            if(nums[right] % 2 != 0) oddCount++;

            //maintain the window of OddCount
            while(oddCount > k){
                if(nums[left] % 2 != 0) oddCount--;
                left++;                
            }

            //Count no. of subarray with atMostK
            count += right - left + 1;
        }

        return count;
    }
}